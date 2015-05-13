package com.example.opsc7312_assign3_ques1_11035169;

import android.os.Bundle;  
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class ChangeCustPassword extends Activity{
	
	EditText txtUsername,txtNewPass, txtConfirmPass;	//textboxes for entering username and password
	Button btnChangePass,btnClear,btnExit;	//button for logging in, clearing fields, changing password and exiting application
	
	DBAdapter db;	//adapter to communicate with Adapter class
	String username,newPassword,confirmPassword;	//variables to temporarily hold the username
	boolean result;
	
	
	//This method loads the GUI onto the welcome activity
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_cust_pass);
				
		//instantiate and open the database
		db = new DBAdapter(this);
		db.open();
		
		//Instantiate decalre textbox and button objects
		txtUsername = (EditText)findViewById(R.id.txtUsername);
		txtNewPass = (EditText)findViewById(R.id.txtNewPass);
		txtConfirmPass = (EditText)findViewById(R.id.txtConfirmPass);
		
		btnChangePass = (Button)findViewById(R.id.btnChangePass);
		btnClear = (Button)findViewById(R.id.btnClear);
		btnExit = (Button)findViewById(R.id.btnExit);
	
	}
	
	//This button will call the method that changes the password of the administrator
	public void onClickChangePass(View view){
		ValidatePasswords(txtUsername,txtNewPass,txtConfirmPass);
	}
	
	//This method will first validate the input of the user
	//This method will then compare the the new and confirmed passwords
	//if all is good then then the admin will proceed to the allow cashier to login
	private void ValidatePasswords(EditText user,EditText newPass,EditText confirmPass){
		
		if(newPass.getText().toString().length() < 1 || confirmPass.getText().toString().length() < 1){
			
			//display error message and exit application
			DisplayOutput("PLEASE ENTER NEW PASSWORD AND CONFIRM PASSWORD IN THE PROVIDED FIELDS!");
			finish();
		}
		else if(confirmPass.getText().toString().length() < 9){
			//display error message and exit application
			DisplayOutput("PASSWORD LENGTH IS INSUFFICIENT - PASSSWORD MUST BE 9 CHARACTERS LONG!");
		}
		else if(newPass.getText().toString()!= confirmPass.getText().toString()){
			//display error message and exit application
			DisplayOutput("NEW PASSWORD AND CONFIRM PASSWORD DO NOT MATCH!");
		}
		else{
			try{
				
				//store the values in the appropriate variables
				username = user.getText().toString();
				newPassword = newPass.getText().toString();
				confirmPassword = confirmPass.getText().toString();
				
				//Open the db
				db.open();
				
				//store the new password
				result = db.updateCashier(newPassword,username);
				
				if(newPassword.equals(result)){
					//display succes message and direct the cashier back to their login page
					DisplayOutput("PASSWORD SUCCESSFULLY CHANGED!");
					startActivity(new Intent(this,CashSale.class));
				}
				else{
					
					//display error message and exit change password
					DisplayOutput("PASSWORD COULD NOT BE CHANGED!");
					startActivity(new Intent(this,LoginCustomer.class));
				}
				db.close();
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	//This button clears all the text boxes on the activity
	public void onClickClear(View view){
		
		txtNewPass.setText("");
		txtConfirmPass.setText("");
	}
	
	//This event button will exit the application
	public void onClickExit(View view){
		show_alert();
	}
	
	//Method to exit application
	private void show_alert() {
		// TODO Auto-generated method stub
		AlertDialog.Builder alert_box = new AlertDialog.Builder(this);
		alert_box.setIcon(R.drawable.ic_launcher);
		alert_box.setMessage("Are you sure you want to exit?");
		alert_box.setPositiveButton("Yes",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Close application
						finish();
					}
				});
		alert_box.setNegativeButton("No",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
						Toast.makeText(getApplicationContext(),
								"No clicked", Toast.LENGTH_LONG).show();
					}
				});

		alert_box.show();
	}
	
	
	//Method to show output for error messages
	public void DisplayOutput(String output){
		Toast.makeText(getBaseContext(), output,Toast.LENGTH_SHORT).show();
	}
	
}
