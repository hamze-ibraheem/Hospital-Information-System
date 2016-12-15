package com.company.his;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLog extends Activity{
	Intent login,backmain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminlogin);
		
		Button log=(Button) findViewById(R.id.button1);
		log.setOnClickListener(new OnClickListener() {
			EditText user=(EditText) findViewById(R.id.editText1);
			Editable userl=user.getEditableText();
			EditText password=(EditText) findViewById(R.id.editText2);
			Editable passwordl=password.getEditableText();
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
			
					// create cursor to poin tto a recored in table admin user to get the admin login information
		     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM adminUser WHERE adminID = '"+ userl +"' AND password= '"+ passwordl +"'" , null);
	        	c.moveToFirst();
	        	while (!c.isAfterLast()){
	        		if (userl.toString().equals(c.getString(0)) && passwordl.toString().equals( c.getString(1))){
	        //go from login screen too admin screen
	        			login= new Intent(AdminLog.this,AdminScreen.class);
				startActivity(login); 
				c.moveToNext();
	        		}
	        		else {
	        			
	    					Toast.makeText(getApplicationContext(), "wrong login information",
	    		        			   Toast.LENGTH_LONG).show();
	    				
	        		}
	        		
	        	}
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				finally{}
			}
		});
		//create button back to main menu
		Button main=(Button)findViewById(R.id.button2);
		main.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				backmain=new Intent(AdminLog.this,MainActivity.class);
				startActivity(backmain);
			}
		});
	}

}
