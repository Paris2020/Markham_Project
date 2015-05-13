package com.example.opsc7312_assign3_ques1_11035169;

import android.app.Fragment;   
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomeFragment1 extends Fragment implements  OnClickListener{
	
	//The button objects to login and how to use the application
	Button btnLogin,btnHowToUse;
	
	//This method will load the GUI of welcome_fragment1
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
		
		//Inflate the layout for this fragment
		View v =  inflater.inflate(R.layout.welcome_fragment1, container, false);
		
		//instantiate  a button object
		btnLogin = (Button)v.findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(this);
		
		btnHowToUse = (Button)v.findViewById(R.id.btnHowToUse);
		btnHowToUse.setOnClickListener(this);
		
		return v;
	}
	
	//This button event uses a case will allow the administrator to login
	public void onClick(View v){
		
		switch(v.getId()){
			
		case R.id.btnLogin:
			getActivity().startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.LoginCustomer"));
			break;
		case R.id.btnHowToUse:
			getActivity().startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.HowToUseApp"));
			break;
		}
	}
	
}
