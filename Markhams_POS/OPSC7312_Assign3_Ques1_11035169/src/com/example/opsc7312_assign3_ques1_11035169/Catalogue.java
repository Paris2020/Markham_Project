package com.example.opsc7312_assign3_ques1_11035169;

import android.os.Bundle;       
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class Catalogue extends Activity{

	//declaration of button objects
	Button btnAccessUnder,btnShirts,btnJackJeans,btnGolfsBottoms,btnFragFoot;
	//This method loads the GUI onto the welcome activity
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalogue);
		
		btnAccessUnder = (Button)findViewById(R.id.btn1);
		btnShirts = (Button)findViewById(R.id.btn2);
		btnJackJeans = (Button)findViewById(R.id.btn3);
		btnGolfsBottoms = (Button)findViewById(R.id.btn4);
		btnFragFoot = (Button)findViewById(R.id.btn5);
	}
	
	//This button event will open gallery containing all of the accessories and underwear
	public void onClickAU(View view){
		startActivity(new Intent(this,AccessoriesAndUnderwear.class));
	}
	
	//This button event will open the gallery containing all the shirts and sweat shirts
	public void onClickSS(View view){
		startActivity(new Intent(this,ShirtsAndSweatShirts.class));
	}
	
	//This button event will open the gallery containing all the shirts and sweat shirts
	public void onClickJJ(View view){
		startActivity(new Intent(this,JacketsAndJeans.class));
	}
	
	//This button event will open the gallery containing all the Golfers and Bottom pants
	public void onClickGB(View view){
		startActivity(new Intent(this,GolfersAndBottoms.class));
	}
	
	//This button event will open the gallery containing all Fragrances and Footwear
	public void onClickFF(View view){
		startActivity(new Intent(this,FragranceAndFootwear.class));
	}
}
