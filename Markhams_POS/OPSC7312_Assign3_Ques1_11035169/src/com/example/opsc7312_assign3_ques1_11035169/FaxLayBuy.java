package com.example.opsc7312_assign3_ques1_11035169;

import android.app.Activity;  
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class FaxLayBuy extends Activity{

	//declaration of outbox,string outbox and progressDialog objects
	EditText txtInbox;
	ProgressDialog progressDialog;

	
	
	//This method loads the GUI of the fax_lay_buy activity
		@Override
		protected void onCreate(Bundle savedInstanceState) { 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.fax_lay_buy);
			
				//the showDialogue() shows the dialogue
				showDialog(1);
				progressDialog.setProgress(0);
				new Thread(new Runnable(){
					public void run(){
					for (int i=1; i<=15; i++) {
						try {
							
							//simulate doing something lengthy
							Thread.sleep(1000);
						
							//update the dialog
							progressDialog.incrementProgressBy((int)(100/15));
						}
						catch (InterruptedException e){
							e.printStackTrace();
						}
					}
						progressDialog.dismiss();
				}
			}).start();
				
			
			
			//ntent to filter for SMS messages received
			intentFilter = new IntentFilter();
			intentFilter.addAction("SMS_RECEIVED_ACTION");
		}
		
		//This show the dialogue of the activity
		protected Dialog onCreateDialog(int id) {
			switch (id){
			case 0:
					return new AlertDialog.Builder(this).create();
			case 1:
					progressDialog = new ProgressDialog(this);
					progressDialog.setIcon(R.drawable.ic_launcher);
					progressDialog.setTitle("Fax Lay_Buy Form...");
					progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int whichButton){
							Toast.makeText(getBaseContext(),"OK clicked!", Toast.LENGTH_SHORT).show();
						}
					});
					
					progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int whichButton){
							Toast.makeText(getBaseContext(),"Cancel clicked!", Toast.LENGTH_SHORT).show();
						}
					});
				
					Toast.makeText(getBaseContext(), 
					"LAY-BUY FORM SENT SUCCESSFULLY TO HEAD-OFFICE\n PLEASE WAIT PATIENTLY FOR  45minutes (MAX) FOR A REPLY \nTHANK YOU",
					Toast.LENGTH_LONG).show();
					return progressDialog;
					
				}
				
				return null;
			}
		
		//an intent filter for the broadcast receiver
		IntentFilter intentFilter;

				
		//These BroadcastReceiver listen for intents  (which are fired by the SmsManager 
		//when the message has been sent and delivered, respectively)
		private BroadcastReceiver intentReceiver = new BroadcastReceiver() {

			//Within the BroadcastReceiver you override the onReceive() method and get the current result code.
			@Override
			public void onReceive(Context arg0, Intent i){
			// TODO Auto-generated method stub
						
						
				txtInbox = (EditText) findViewById(R.id.txtInbox);	//instantiate object
				txtInbox.setText(i.getExtras().getString("sms"));	//the getExtras() retrieves a map of extended data from the intent
							
			}
			};
			
	
		
		/* When an incoming SMS message is received, the onReceive() method is fired. The SMS message
		is contained in the Intent object (intent; the second parameter in the onReceive() method) via a
		Bundle object.
	 */
		@Override
		public void onResume() {
			super.onResume();
			//register the receiver
			//Note that each SMS message received will invoke the onReceive() method
			registerReceiver(intentReceiver, intentFilter);
		}
		
		
		//Called as part of the activity lifecycle when an activity is going into the background, but has not (yet) been killed
		@Override
		public void onPause() {
			super.onPause();
			//unregister the receiver
			unregisterReceiver(intentReceiver);
		}
		
}
