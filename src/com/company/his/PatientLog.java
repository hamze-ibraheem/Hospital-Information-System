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


public class PatientLog extends Activity{
	Intent login;
	static EditText user;
	static Editable userl;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientlog);
		user=(EditText) findViewById(R.id.editText1);
		userl=user.getEditableText();
		Button log=(Button) findViewById(R.id.button1);
		log.setOnClickListener(new OnClickListener() {
			
			
			EditText password=(EditText) findViewById(R.id.editText2);
			Editable passwordl=password.getEditableText();
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
			
					//login to patient screen
		     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM patient WHERE patientID = '"+ userl +"' AND password= '"+ passwordl +"'" , null);
	        	c.moveToFirst();
	        	while (!c.isAfterLast()){
	        		if (userl.toString().equals(c.getString(0)) && passwordl.toString().equals( c.getString(1))){
	        	login= new Intent(PatientLog.this,PatientScreen.class);
				startActivity(login); 
				c.moveToNext();
	        		}
	        		else{
	        			
    					Toast.makeText(getApplicationContext(), "wrong information",
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
	}

}