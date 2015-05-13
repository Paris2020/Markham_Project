package com.example.opsc7312_assign3_ques1_11035169;


import android.os.Bundle;        
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
//import android.database.Cursor;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

public class LoginCustomer extends Activity{
	
	
	EditText txtUsername, txtPassword;	//textboxes for entering username and password
	Button btnLogIn,btnClear,btnChange,btnExit;	//button for logging in, clearing fields, changing password and exiting application
	
	String username,password;	//variables to temporarily hold the username and password
	long id;	//variable to hold the id of admin
	
	//This method loads the GUI onto the welcome activity
			@Override
			protected void onCreate(Bundle savedInstanceState) { 
				super.onCreate(savedInstanceState);
				setContentView(R.layout.login_cust);
				
				//Instantiate declare textbox and button objects
				txtUsername = (EditText)findViewById(R.id.txtUsername);
				txtPassword = (EditText)findViewById(R.id.txtPassword);
				
				btnLogIn = (Button)findViewById(R.id.btnLogIn);
				btnClear = (Button)findViewById(R.id.btnClear);
				btnChange = (Button)findViewById(R.id.btnChangePass);
				btnExit = (Button)findViewById(R.id.btnExit);

			}
			
			//This button event will call the Validate Input()
			public void onClickLoginCust(View view){
				ValidateInput(txtUsername, txtPassword);
			}
			
			
			//This method validates username and password
			private void ValidateInput(EditText user, EditText pass){
				
				if(user.getText().toString().length() < 1 || pass.getText().toString().length() < 1){
					
					//display error message and exit application
					DisplayOutput("PLEASE ENTER USERNAME AND PASSWORD IN THE PROVIDED FIELDS!");
					finish();
				}
				else if(pass.getText().toString().length() < 9){
					
					//display error message and exit application
					DisplayOutput("PASSWORD LENGTH IS INSUFFICIENT - PASSSWORD MUST BE 9 CHARACTERS LONG!");
					finish();
					
				}
				else{
					
					startActivity(new Intent(this,PointOfSale.class));
					/*try{

						//Declare and instantiate the Adapter class and open the database
						DBAdapter db = new DBAdapter(this);
						db.open();
						
						//Insert data into tblCustomers
						db. InsertCashier("Customer01", "cust01*#*");
						db. InsertCashier("Customer02", "cust02*#*");
						
					
						//declare cursor object to get the customer of the specified password
						Cursor c = db.getCashier(txtUsername.getText().toString().trim(),txtPassword.getText().toString().trim());
						if(c.getCount()!= 0){
							
							//store the password and username in the fields assigned
							username = c.getString(1);
							password = c.getString(2);
							
							if(txtUsername.getText().toString().trim() != username){
								
								//display error message and select username field and highlight it to red
								txtUsername.setBackgroundColor(4);
								DisplayOutput("USERNAME IS INCORRECT!");
							}
							else if(txtPassword.getText().toString().trim() != password){
								
								//display error message and select password field and highlight it to red
								txtPassword.setBackgroundColor(4);
								DisplayOutput("PASSWORD IS INCORRECT!");
							}
							else if(txtPassword.getText().length() < 9 || txtPassword.getText().length() > 9){
								
								//display error message and select password field and highlight it to red
								txtPassword.setBackgroundColor(4);
								DisplayOutput("PASSWORD LENGTH IS INSUFFICIENT/ MORE THAN REQUIRED AMOUNT - PASSSWORD MUST BE EXACTLY 9 CHARACTERS LONG!");
								
							}
							else if(txtUsername.getText().toString().trim().equals(username) && txtPassword.getText().toString().trim().equals(password)){
								startActivity(new Intent(this,PointOfSale.class));
							}
						}
						else{
							
							//display an error message telling the user to enter their username and password to login otherwise you log them out automatically
							DisplayOutput("PLEASE ENTER USERNAME AND PASSWORD IN THE PROVIDED FIELDS!");
							finish();
						}
						db.close();	//close the database
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
					*/
				}
			}
			
		
			//The code below is an event that calls  an exit  method to exit the application
			public void onClickExit(View view){
				show_alert();
			}
			
			//Method to exit application
				private void show_alert() {
					// TODO Auto-generated method stub
					AlertDialog.Builder alert_box = new AlertDialog.Builder(this);
					alert_box.setIcon(R.drawable.ic_launcher);
					alert_box.setMessage("Are you sure you want to exit?");
					alert_box.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
							// Close application
								startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.WelcomeActivity"));
							}
					});
					alert_box.setNegativeButton("No",new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int which) {
									
									Toast.makeText(getApplicationContext(),
											"No clicked", Toast.LENGTH_LONG).show();
								}
					});

					alert_box.show();
				}
			
			//This method will direct the customer to the Point Of Sale
			public void onClickChange(View view){
				startActivity(new Intent(this,ChangeCustPassword.class));
			}
			
			//This button event will be clear all text fields on the activity
			public void onClickClear(View view){
				txtUsername.setText("");
				txtPassword.setText("");
			}
			
				
			//Method to show output for error messages
			public void DisplayOutput(String output){
				Toast.makeText(getBaseContext(), output,Toast.LENGTH_SHORT).show();
			}
	
}
