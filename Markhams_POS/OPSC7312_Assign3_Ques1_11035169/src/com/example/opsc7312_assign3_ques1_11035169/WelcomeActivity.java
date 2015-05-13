package com.example.opsc7312_assign3_ques1_11035169;

import android.os.Bundle;   
import android.app.Activity;


public class WelcomeActivity extends Activity {

	//This method loads the GUI onto the welcome activity which contains the GUI for both fragments
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
	}

}
