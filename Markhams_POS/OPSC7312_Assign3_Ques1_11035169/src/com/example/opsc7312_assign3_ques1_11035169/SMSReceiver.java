package com.example.opsc7312_assign3_ques1_11035169;

import android.content.BroadcastReceiver; 
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver{

	
	@Override
	public void onReceive(Context context, Intent intent)
	{
		
		Bundle bundle = intent.getExtras();	//decaler and get the SMS message passed in
		SmsMessage[] msgs = null;	//declare and set the message array to null for now
		String inbox = "From:";
		if (bundle != null){
			
			
			Object[] pdus = (Object[]) bundle.get("pdus");	//retrieve the SMS message received	
			msgs = new SmsMessage[pdus.length];	//get the length of the message
			for (int i=0; i<msgs.length; i++){	//loop trhouh the message to display every character
					
				msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
				if (i==0) {
					
					inbox += msgs[i].getOriginatingAddress() + "\n";	//get the sender address phone number
					inbox += "";
				}
				
			inbox += msgs[i].getMessageBody().toString();	//get the message body
			}
			
			/*
			 An Intent provides a facility for performing late runtime binding between the code in different applications.
			  Its most significant use is in the launching of activities, where it can be thought of as the glue between 
			  activities. It is basically a passive data structure holding an abstract description of an action to be performed.
	 		 */
			Intent broadcastIntent = new Intent();
			broadcastIntent.setAction("SMS_RECEIVED_ACTION");
			broadcastIntent.putExtra("sms", inbox);
			context.sendBroadcast(broadcastIntent);
		}
	}
}
