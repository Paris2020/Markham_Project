package com.example.opsc7312_assign3_ques1_11035169;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment{
	
	TextView lblProductList;			//declare the label to display the product price and total
	String str = "";	//declare an initialize a variable
	
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
		View v = inflater.inflate( R.layout.fragment2, container, false);
		
		//instantiate the label object
		lblProductList = (TextView)v.findViewById(R.id.lblProductList);
		
		str = DisplayOutput();	//assign the return value to the string variable
		lblProductList.setText(str);	//set the strung value to the label
		
		return v;
	}
	
	//Method to display product list
	public String DisplayOutput(){
		
		//loop for accessories
		str += "Product Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "ACCESSORIES" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nAccessories.length; x++){
			str += nAccessories[x] + "\t\t\t\t\t\t" + pAccessories[x] + "\n";
		}
		
		str += "==================================================================";
		
		//loop for bottoms
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "BOTTOMS" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nBottoms.length; x++){
			str += nBottoms[x] + "\t\t\t\t\t\t" + pBottoms[x] + "\n";
		}
		
		str += "==================================================================";
		
		//loop for footwear
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "FOOTWEAR" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nFootwear.length; x++){
			str += nFootwear[x] + "\t\t\t\t\t\t" + pFootwear[x] + "\n";
		}
		
		str += "==================================================================";
		
		//loop for fragrance
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "FRAGRANCE" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nFragrance.length; x++){
			str += nFragrance[x] + "\t\t\t\t\t\t" + pFragrance[x] + "\n";
		}
		
		str += "==================================================================";
		
		//loop for golfers
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "GOLFERS" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nGolfers.length; x++){
			str += nGolfers[x] + "\t\t\t\t\t\t" + pGolfers[x] + "\n";
		}
		
		str += "==================================================================";
		
		//loop for jackets
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "JACKETS" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nJackets.length; x++){
			str += nJackets[x] + "\t\t\t\t\t\t" + pJackets[x] + "\n";
		}
		
		str += "==================================================================";
		
		//loop for jeanswear
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "JEANSWEAR" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nJeanswear.length; x++){
			str += nJeanswear[x] + "\t\t\t\t\t\t" + pJeanswear[x] + "\n";
		}
		
		str += "===================================================================";
		
		//loop for shirts
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "SHIRTS" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nShirts.length; x++){
			str += nShirts[x] + "\t\t\t\t\t\t" + pShirts[x] + "\n";
		}
		
		str += "====================================================================";
		
		//loop for sweat-shirts
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "SWEATSHIRTS" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nSweatShirts.length; x++){
			str += nSweatShirts[x] + "\t\t\t\t\t\t" + pSweatShirts[x] + "\n";
		}
		
		str += "====================================================================";
		
		//loop for underwear
		str += "\n\nProduct Name" + "\t\t\t\t\t\t\t\t\t\t\t" + "Product Price" + "\n";
		str += "UNDERWEAR" + "\t\t\t\t\t\t\t\t\t\t\t" + "PRICE" + "\n\n";
		for(int x = 0; x < nUnderwear.length; x++){
			str += nUnderwear[x] + "\t\t\t\t\t\t" + pUnderwear[x] + "\n";
		}
		
		return str;
	}
}
