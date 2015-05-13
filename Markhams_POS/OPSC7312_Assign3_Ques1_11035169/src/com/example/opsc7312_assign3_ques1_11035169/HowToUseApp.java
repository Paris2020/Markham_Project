package com.example.opsc7312_assign3_ques1_11035169;

import android.os.Bundle;        
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

public class HowToUseApp extends Activity{

	//object variable declaration of button for viewing the info on how to use app
	//object variable declaration of textView for displaying the info
	//variable declaration for storing the information
	Button btnHowTo;
	TextView lblInfo;
	String info = "";
	
	//This method loads the GUI onto the welcome activity
		@Override
		protected void onCreate(Bundle savedInstanceState) { 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.how_to_use);
			
			//object variable instatntiation
			btnHowTo = (Button)findViewById(R.id.btnHowToUse);
			lblInfo = (TextView)findViewById(R.id.lblInfo);
			DisplayInformation();
		}
		
		
		//This method thoroughly explains information on how to use the application
		public void DisplayInformation(){
			info += "HOW TO USE MARKHAMS WEBSITE APPLICATION\n\n";
			info += "Introduction\n============================\n\nThe following android application is a simulation of a website that will soon be considered for\n" +
					"all mobile phones and will be a default application website for android cell phones wanting to access Markhams\n" + 
					" Retailstore online.\nPurpose\n ============================\n\nThe application of the application is to provide convenience to the customer\n" + 
					"especially regular customers who may have an account with the company to be able to access and view latest fashion\n" + 
					"items in the store, to view prices, to purchase on line, request lay-buys etc. from their location. This provides\n" + 
					"the benefit of saving time and money to travel a distance for physically shopping for items.\n" + "Security Issues\n ============================\n\n" +
					"Websites are always the area for threats and this will not change, however to reduce the chances of fraud amongst other\n" + 
					"things, ONLY regular customers will be allowed to login the rest of the customers will be alee to ONLY view catalogue\n" + 
					"and product prices. To become a member of the Markhams , the user will have to go to the nearest store and complete an" + 
					"application in any one of the following stores – Foshini, @Home, TotalSports, SportScene, Exact and other TGF stores.\n\n";
			
			info += "Welcome Page\n ================================\n" + 
					"1. Click Login button to login as a regular customer.\n" +
					"2. Click How To Use button to read instructions.\n" + 
					"3. Click View Catalogue button to view latest trends.\n"+
					"4. Click View Prices button to view prices of items available.\n" +
					"===================================================================\n\n" + 
					"Customer Login Page\n ===============================\n"+ 
					"1. Click Login button after entering your username and password.\n"+
					"2. Click Change Password button to go to ChangeCustPassword webpage.\n" + 
					"3. Click Clear and Exit to clear fields and return to welcom page respectively.\n"+
					"====================================================================\n\n" + 
					"Change Customer Password Page\n ==========================================\n"+ 
					"1. Click Change Pass button to change password.\n" + 
					"2. Click Clear and Exit to clear all fields and logout from website respectively.\n" +
					"======================================================================================\n\n" + 
					"Point Of Sale page (Main Page)\n =====================================\n\n" + 
					"1. Click Cash Sale radioButton to purchase items.\n" +
					"2. Click Lay Buy radioButton to request lay-buy.\n" +
					"3. Click Store Lookup button to view google maps and search for markhams stores.\n" + 
					"4. Click Logout button to return to login page.\n" + 
					"===================================================================================\n\n" +
					"Cash Sale Page\n =====================================\n" + 
					"1. Click Search Item button to search for a product and display its price.\n" +
					"2. Click Checkout button to add the product name and price to the busket list.\n" +
					"3. Click Clear and Exit button to clear all fields and return to main page (Point Of Sale).\n" +
					"==============================================================================================\n\n" +
					"Lay-Buy Page\n ============================\n" + 
					"1. Click Lay-Buy Button to add a product name and price typed in into the busket.\n" +
					"2. Click Cancel Lay-Buy button to reverse transaction and start over.\n" +
					"3. Click Clear and exit buttons to clear all fields and return to the main page (Point Of Sale).\n" +
					"4. Click Send Requested Lay-Buy button to send the request to the head-office.\n" +
					"===================================================================================================\n\n" +
					"Fax Lay-Buy Page\n ====================================\n" + 
					"1. Wait for the replay from the head-office for approximatley 45minutes.\n" +
					"2. Click the return button of your phone to return to the previous page and logut if you will.\n" +
					"===================================THANK YOU= ======================================================";
			
			lblInfo.setText(info);
		}
		
}
