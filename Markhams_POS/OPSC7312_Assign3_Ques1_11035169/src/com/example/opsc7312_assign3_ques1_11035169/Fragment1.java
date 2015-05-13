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

public class Fragment1 extends Fragment implements OnClickListener{
	
	EditText txtProductName,txtProductPrice;	//declare the field to enter a product name and price
	TextView lblProdName,lblProdPrice,lblTotalDue;			//declare the label to display the product name, price and total
	Button btnClear,btnExit,btnBuy;	//declare the buttons for searching,exiting and clearing
	
	double itemPrice,total,totalDue;	//declare variables to store price, total and totaldue
	String name,price;	//declare variable to store product name
	
	//Prices of all the cloths
	String[] nAccessories = {"Pack Stone Earings Accessories","Orange Messager Bag Accessories","Brown Burnish Buckle Belt Accessories","Burgundy 5 Panel Cap Accessories"};
	double[] pAccessories = {140,450,130,120};
		
	String[] nBottoms = {"Burgundy Skinny Chino Bottoms","Black Skinny Bottoms","Gray Chino Bottoms","Red Active Bottoms"};
	double[] pBottoms = {240,350,280,280};
	
	String[] nFootwear = {"Navy Chuka Footwear","Navy Leather Toe Post Footwear","Black Patent Loafer Footwear","Converse Turo Footwear"};
	double[] pFootwear = {570,660,670,899};
		
	String[] nFragrance = {"David Off Champion 50ml Fragrance","Dunhill Desire Blue 50ml Fragrance","Hugo Man 100ml Fragrance","Paco Million 50ml Fragrance"};
	double[] pFragrance = {680,780,650,860};
		
	String[] nGolfers = {"Blue Relay Pigment Golfers","Coral Melange Cowel Neck Golfers","Navy Shangai Cowel Neck Golfers","White Plain Vest Golfers"};
	double[] pGolfers = {230,180,340,370};
		
	String[] nJackets = {"Charcoal Jacket","Stone Jacket","Denim Vest Jacket"};
	double[] pJackets = {780,760,660};
		
	String[] nJeanswear = {"Light Indigo Skinny Jeanwear","Light Indigo Straightleg Jeanwear"};
	double[] pJeanswear = {450,380};
		
	String[] nShirts = {"Blue Denim Shirt","Green Gingham Check Shirt","Orange Check Shirt","White Shoulder Patch Shirt"};
	double[] pShirts = {220,240,260,280};
		
	String[] nSweatShirts = {"Black College Baseball Jacket","Black Plain Crew Neck","Blue Collegiate Cardigan","White Ribbed Crew Neck"};
	double[] pSweatShirts = {450,350,480,300};
		
	String[] nUnderwear = {"Red-Black Seamless Boxer","Three Pack Stone Surface","Blue and Grey Seamless Boxer","Black Padded Trainer Socks"};
	double[] pUnderwear = {220,290,280,230};
	
	
	//This method will load the GUI of Fragment1
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
		
		//Inflate the layout for this fragment
		View v = inflater.inflate( R.layout.fragment1, container, false);
		
		//instantiatte objects for product name, price and total
		txtProductName = (EditText)v.findViewById(R.id.txtProductName);
		txtProductPrice = (EditText)v.findViewById(R.id.txtProductPrice);
		lblProdName = (TextView)v.findViewById(R.id.lblProdName);
		lblProdPrice = (TextView)v.findViewById(R.id.lblProdPrice);
		lblTotalDue = (TextView)v.findViewById(R.id.lblTotalDue);
		
		
		//Instantiate the buttons for searching,clearing and exiting
		//Then register the event OnClickListener to the buttons
		btnBuy = (Button)v.findViewById(R.id.btnBuy);
		btnBuy.setOnClickListener(this);
		btnClear = (Button)v.findViewById(R.id.btnClear);
		btnClear.setOnClickListener(this);
		btnExit = (Button)v.findViewById(R.id.btnExit);
		btnExit.setOnClickListener(this);
		
		return v;
	}
	
	//This method will validate and add the price to the total incrementally
			private void AddPriceToTotal(EditText pName,EditText pPrice){
				
				if(pName.toString().length() < 1 || pPrice.toString().length() < 1){
					
					//display an error message
					DisplayOutput("PLEASE ENTER A VALUE FOR PRODUCT NAME AND PRODUCT PRICE!");	
				}
				else{
					
					total = Double.parseDouble(pPrice.getText().toString());	//assign the price to a string variable
					totalDue +=total;	//convert what is in the string to double and simultaneously add it to the total due
					lblTotalDue.setText(Double.toString(totalDue));	//finally convert the double back to string so that you can place it in the label
					
					//take the values from the edit text fields
					name += pName.getText().toString() + "\n";
					price += pPrice.getText().toString() + "\n";
					
					//set them to the labels
					lblProdName.setText(name);
					lblProdPrice.setText(price);
					
					//clear the text fields for product name and price
					pName.setText("");
					pPrice.setText("");
					
				}
					
			}
	
	//This button event uses a case structure that will allow the cashier serach, clear and exit application
		public void onClick(View v){
				
			switch(v.getId()){
	
				case R.id.btnBuy:
					AddPriceToTotal(txtProductName,txtProductPrice);
					txtProductName.setText("");	//clear both textview and edittext view of product name and price
					txtProductPrice.setText("");
					break;
				case R.id.btnClear:
					//Clear the fields
					txtProductName.setText("");
					lblTotalDue.setText("");
					txtProductPrice.setText("");
					break;
				case R.id.btnExit:
					//revert to the point of sale activity
					getActivity().startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.PointOfSale"));
					break;
				}
		}

	
	//Method to show output for error messages
	public void DisplayOutput(String output){
		Toast.makeText(getActivity(), output,Toast.LENGTH_SHORT).show();
	}
}
