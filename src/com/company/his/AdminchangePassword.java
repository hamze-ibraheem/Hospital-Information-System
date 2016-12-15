package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminchangePassword extends Activity{
	EditText password;
	Editable changepassword;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminchangepassword);
		password=(EditText)findViewById(R.id.editText1);
		
		Button change=(Button) findViewById(R.id.button1);
		change.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//get the password from the edit text
				changepassword=password.getEditableText();
				//update the password
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("UPDATE adminUser SET password='"+ changepassword +"' WHERE adminID= 'admin'");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "password changed",
	        			   Toast.LENGTH_LONG).show();
			}
		});
	}
}
