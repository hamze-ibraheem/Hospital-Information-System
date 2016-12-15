package com.company.his;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PatientChangePassword extends Activity{
	EditText password,oldpassword;
	Editable changepassword,oldPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientchangepassword);
		password=(EditText)findViewById(R.id.editText1);
		oldpassword=(EditText)findViewById(R.id.editText2);
		Button change=(Button) findViewById(R.id.button1);
		change.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				changepassword=password.getEditableText();
				oldPassword=oldpassword.getEditableText();
				
				
				try{
					
				       
			     	Cursor c=MainActivity.db.rawQuery("SELECT password FROM patient WHERE patientID='"+ PatientLog.userl +"'" , null);
		        	c.moveToFirst();
		        	while (!c.isAfterLast()){
		        		  // preparing list data
		        	     // prepareListData(c.getString(0));
		        	if(PatientLog.userl.toString().equals(c.getString(0))){

				if(c.getString(1).equals(oldPassword)){
					MainActivity.db.beginTransaction();
					MainActivity.db.execSQL("UPDATE patient SET password='"+ changepassword +"' WHERE patientID= '"+PatientLog.userl+"'");
					MainActivity.db.setTransactionSuccessful();
					MainActivity.db.endTransaction();
					Toast.makeText(getApplicationContext(), "password changed",
		        			   Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(getApplicationContext(), "old password wrong",
		        			   Toast.LENGTH_LONG).show();
				}
		        	      c.moveToNext();
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