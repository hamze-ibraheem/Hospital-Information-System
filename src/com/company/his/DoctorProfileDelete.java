package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DoctorProfileDelete extends Activity{
	EditText doctoruser,doctorpassword;
	Editable user,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctorprofiledelete);
		doctoruser=(EditText)findViewById(R.id.editText1);
		doctorpassword=(EditText)findViewById(R.id.editText2);
		
		Button delete=(Button) findViewById(R.id.button1);
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				user=doctoruser.getEditableText();
				password=doctorpassword.getEditableText();
				//delete doctor profile
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("DELETE  FROM doctor WHERE doctorID = '"+ user +"' AND password= '"+ password +"'");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "data deleted",
	        			   Toast.LENGTH_LONG).show();
			}
		});
	}

}
