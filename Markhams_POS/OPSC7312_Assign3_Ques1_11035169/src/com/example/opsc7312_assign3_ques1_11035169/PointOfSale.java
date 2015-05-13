package com.example.opsc7312_assign3_ques1_11035169;

import android.os.Bundle;        
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
 
public class PointOfSale extends Activity{
	
	RadioGroup rbtnGroupOne;	//declare a radio button object to hold the group of radio buttons
	Button btnPriceLook,btnLogOut;	//declare buttons for displaying prices and logging out
	RadioButton rbtnCashSale,rbtnLayBuys;	//declare radio button objects for  selecting cash sale and reports
	

	//This method loads the GUI onto the welcome activity
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.point_of_sale);
		
		
		//Instantiate the button object and radio button objects
		btnPriceLook = (Button)findViewById(R.id.btnPriceLookup);
		btnLogOut = (Button)findViewById(R.id.btnLogOut);
		
		rbtnGroupOne = (RadioGroup)findViewById(R.id.rbtnGroupOne);
		rbtnCashSale = (RadioButton) findViewById(R.id.rbtnCashSale);
		rbtnLayBuys = (RadioButton) findViewById(R.id.rbtnLaybuys);
		
		//The following are radioButtons that when clicked, 
		//the program will display a message dictating which radio button
		rbtnGroupOne.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
				if (rbtnCashSale.isChecked()) {
					DisplayCashSale();	//call the method to display CashSale activity
				} 
				else {
					DisplayLayBuys();	//call the method to display ViewReports activity
				}
			}
		});
	}
	
	//This method will display an activity that will
	//allow the cashier to search for a particular product
	public void onClickPriceLook(View view){
		startActivity(new Intent(this,StoreLookUp.class));
	}
	
	//This method exits the reverts the cashier to the LoginCashier Activty to continue with transanction
	public void onClickLogOut(View view){
		startActivity(new Intent(this,LoginCustomer.class));
	}
	
	//Method to show output for any sort of messages
	public void DisplayOutput(String output){
		Toast.makeText(getBaseContext(), output,Toast.LENGTH_SHORT).show();
	}
	
	//This method will allow the user to call the CashSale Activity
	private void DisplayCashSale(){
		//Direct user to the CashSale Activity
		startActivity(new Intent(this,CashSale.class));
	}
	
	//This method will allow the user to call the ViewReports Activity
	private void DisplayLayBuys(){
		//Direct user to the CashSale Activity
		startActivity(new Intent(this,LayBuys.class));
	}
	
	
}
