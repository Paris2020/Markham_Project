package com.example.opsc7312_assign3_ques1_11035169;
  
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.app.Activity;


public class DBAdapter extends Activity{

	static final String DATABASE_NAME = "DineoDB";
	static final int DATABASE_VERSION = 1;
	static final String TAG = "DBAdapter";
	
	static final String KEY_ROW_ID = "CustomerID";
	static final String KEY_USER = "Username";
	static final String KEY_PASS = "Password";
	
	
	//Declare database,tables and version of database
	static final String DATABASE_TABLE = "tblCustomers";
	static final String DATABASE_CREATE = "create table tblCustomers (CustomerID integer primary key autoincrement, " + "Username text not null, Password text not null);";
	
	DatabaseHelper DBHelper;
	SQLiteDatabase db;
	final Context context;
	 
	 
	//declare adapter
	 public DBAdapter(Context cont){
		 this.context = cont;
		 DBHelper = new DatabaseHelper(context);
	 }
	 
	/* Add a private class that extends the SQLiteOpenHelper class,
		which is a helper class in Android to manage database creation and version management. In particular,
		you overrode the onCreate() and onUpgrade() methods
	 */
	 private static class DatabaseHelper extends SQLiteOpenHelper{
		 
		 DatabaseHelper(Context context){
			 super(context,DATABASE_NAME,null,DATABASE_VERSION);
		 }
		 
		 /* The onCreate() method creates a new database if the required database is not present*/
		 @Override
		 public void onCreate(SQLiteDatabase db){
			 
			 try{
				 db.execSQL(DATABASE_CREATE);
			 }
			 catch(SQLException sqle){
				 sqle.printStackTrace();
			 }
		 }
		 
		 /*The onUpgrade() method is called when the database needs to be upgraded. This is achieved by checking
			the value defined in the DATABASE_VERSION constant. For this implementation of the onUpgrade()
			method, you simply drop the table and create it again. */
		 @Override
		 public void onUpgrade(SQLiteDatabase db,int oldV,int newV){
			 Log.w(TAG,"Upgrading databases from version " + oldV + "to " + newV + ", which will destroy all data");
			 db.execSQL("DROP TABLE IF EXISTS tblCustomers");
			 onCreate(db);
		 } 
	 }
	 
	//Open DineoDB
	 public DBAdapter open() throws SQLException{
		 
		 db = DBHelper.getWritableDatabase();
		 return this;
	 }
	 
	 //Close DineoDB
	 public void close(){
		 DBHelper.close();
	 }
	 
	 //This allows the user to insert data into the table
	 public void InsertCashier(String username, String password)
	{
		String sql="INSERT INTO tblCustomers (Username,Password) VALUES('" +username+"','"+password+"')";
		db.execSQL(sql);
	}

	 
	 //Retrieves a single cashier
	 public Cursor getCashier(String user,String pass) throws SQLException {

	        Cursor c = this.db.query(true, DATABASE_TABLE, new String[] {KEY_ROW_ID, KEY_USER,KEY_PASS}, KEY_USER + "='" + user 
	        			+ "' AND" + KEY_PASS + "='" + pass + "'", null, null, null, null, null);
	        if (c != null) {
	            c.moveToFirst();
	        }
	        return c;
	 }

	 //This will update the cashiers password
	  public boolean updateCashier(String pass,String user){
		 ContentValues args = new ContentValues();
	     args.put(KEY_PASS, pass);
	     
	     Cursor cur = db.rawQuery("UPDATE "+ DATABASE_TABLE +" SET " + KEY_PASS + " = '" + pass +"' WHERE "+ KEY_USER +"=?", new String[]{user});

         if (cur != null)
         {           
             if(cur.getCount() > 0)
             {
                 return true;
             }
         }
         return false;
	  }

}
