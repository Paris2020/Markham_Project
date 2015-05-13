package com.example.opsc7312_assign3_ques1_11035169;

import android.app.Fragment;   
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lay_Buy_Fragment1 extends Fragment implements OnClickListener{
	
	EditText txtProductName,txtProductPrice;	//declare the field to enter a product name and price
	TextView lblTotalDue,lblProdName,lblProdPrice;			//declare the label to display the product name, price and total
	Button btnLayBuy,btnCancel,btnClear,btnExit,btnSendFax;	//declare the buttons for lay-buying,cancelling lay-buy,exiting and clearing
	
	
	//Declare variables for storing price,total,totalDue,subtracted total,and lay-buys for product name and price
	double price,total,totalDue,sTotal,conversion;
	String layBuy = "",layBuy2 = "";

	
	//This method will load the GUI of Lay_Buy_Fragment1
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
		
		//Inflate the layout for this fragment
		View v = inflater.inflate( R.layout.lay_buy_fragment1, container, false);
		
		//instantiatte objects for product name, price and total
		txtProductName = (EditText)v.findViewById(R.id.txtProductName);
		txtProductPrice  = (EditText)v.findViewById(R.id.txtProductPrice);
		lblTotalDue = (TextView)v.findViewById(R.id.lblTotalDue);
		lblProdName = (TextView)v.findViewById(R.id.lblProdName);
		lblProdPrice = (TextView)v.findViewById(R.id.lblProdPrice);
		
		//Instantiate the buttons for searching,clearing and exiting
		//Then register the event OnClickListener to the buttons
		btnLayBuy = (Button)v.findViewById(R.id.btnLayBuy);
		btnLayBuy.setOnClickListener(this);
		btnCancel = (Button)v.findViewById(R.id.btnCancel);
		btnCancel.setOnClickListener(this);
		btnClear = (Button)v.findViewById(R.id.btnClear);
		btnClear.setOnClickListener(this);
		btnExit = (Button)v.findViewById(R.id.btnExit);
		btnExit.setOnClickListener(this);
		btnSendFax = (Button)v.findViewById(R.id.btnSendFax);
		btnSendFax.setOnClickListener(this);
		
		
		return v;
	}

	
	//This method will validate input
	private void ValidateInput(EditText prodName,EditText prodPrice){
		if(prodName.getText().toString().length() < 1 || prodPrice.getText().toString().length() < 1){
			
			//display error message and exit application
			DisplayOutput("PLEASE ENTER PRODUCT NAME AND PRICE IN THE PROVIDED FIELDS!");
		}	
	}
	
	
	//This method will add the price to the total incrementally
	private void AddPriceToTotal(EditText p,EditText n){
		
		if(p.getText().toString().length() < 1 || n.getText().toString().length() < 1){
			
			//display an erro message
			DisplayOutput("PLEASE ENTER A VALUE FOR PRODUCT NAME AND PRODUCT PRICE");	
		}
		else{
			
			total = Double.parseDouble(p.getText().toString());	//assign the price to a string variable
			totalDue +=total;	//convert what is in the string to double and simultaneously add it to the total due
			lblTotalDue.setText(Double.toString(totalDue));	//finally convert the double back to string so that you can place it in the label
			
			//take the values from the edit text fields
			layBuy += n.getText().toString() + "\n";
			layBuy2 += p.getText().toString() + "\n";
			
			//set them to the labels
			lblProdName.setText(layBuy);
			lblProdPrice.setText(layBuy2);
			
			//clear the text fields for product name and price
			n.setText("");
			p.setText("");
		}
		
	}
	
	//This method will subtract the price from the total
	private double SubtractPriceFromTotal(EditText p,TextView t,EditText n){
		
		if(p.getText().toString().length() < 1 || n.getText().toString().length() < 1){
			
			//display an erro message
			DisplayOutput("PLEASE ENTER A VALUE FOR PRODUCT NAME AND PRODUCT PRICE");
		}
		else{
			
			sTotal = Double.parseDouble(t.getText().toString());	//take the total due value from the label and convert it to a double
			sTotal -= Double.parseDouble(p.getText().toString());	//then convert the price value to a double as well so that you can subtract it from the sTotal
			lblTotalDue.setText(Double.toString(sTotal));	//display the new subtracted value
			
			//if the label contains the product and price entered to be cancelled, then cancel the entire transaction and start over
			//it is possible but will be difficult to cancel one product at a time
			if(lblProdName.getText().toString().contains(n.getText().toString()) && lblProdPrice.getText().toString().contains(p.getText().toString())){
				lblProdName.setText("");
				lblProdPrice.setText("");
			
				Toast.makeText(getActivity(), "Transaction Cancelled!", Toast.LENGTH_SHORT).show();
			}
		}
		
		return sTotal;
	}
	
	//The following method will send the lay-buy for approval to the head-office
	//Head office only approves lay-buys for amounts greater than R2000
	private void SendFexToHeadOffice(TextView n,TextView t){
		
		//convert the value in the label to a double to determine if the user qualifies for a lay-buy
		conversion = Double.parseDouble(t.getText().toString());
		
		//if the label contains R2000 the start new activity
		if(conversion >= 2000){
			
			//this activity processes the lay-buy form
			getActivity().startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.FaxLayBuy"));
			
		}
		else if(n.getText().toString().length() < 1 || t.getText().toString().length() < 1){
			//display an erro message
			DisplayOutput("PLEASE ENTER A VALUE FOR PRODUCT NAME AND PRODUCT PRICE");
		}
		else{
			
			//display an erro message
			DisplayOutput("CUSTOMER CAN ONLY QUALIFY FOR LAY-BUY IF THEY PURCHASE OVER R2000.00");
		}
			
	}
	
	//This button event uses a case structure that will allow the cashier serach, clear and exit application
	public void onClick(View v){
			
		switch(v.getId()){
			case R.id.btnLayBuy:
				//Call method to validate input
				txtProductName.findFocus();
				ValidateInput(txtProductName,txtProductPrice);
				AddPriceToTotal(txtProductPrice,txtProductName);
				break;
			case R.id.btnCancel:
				//Call the method that adds the price to the total
				SubtractPriceFromTotal(txtProductPrice,lblTotalDue,txtProductName);
				break;
			case R.id.btnClear:
				//Clear the fields
				txtProductName.setText("");
				lblTotalDue.setText("");
				txtProductPrice.setText("");
				total = 0;	//so that I can start over
				sTotal = 0;	//so as to start over
				break;
			case R.id.btnExit:
				//revert to the point of sale activity
				getActivity().startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.PointOfSale"));
				break;
			case R.id.btnSendFax:
				//Fax the Lay-Buy to head-office for approval
				SendFexToHeadOffice(lblProdName,lblTotalDue);
			}
	}
	
	//Method to show output for error messages
	public void DisplayOutput(String output){
		Toast.makeText(getActivity(), output,Toast.LENGTH_SHORT).show();
	}

}
