package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientProfileDelete extends Activity{
	EditText patientuser,patientpassword;
	Editable user,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientprofiledelete);
		patientuser=(EditText)findViewById(R.id.editText1);
		patientpassword=(EditText)findViewById(R.id.editText2);
		
		Button delete=(Button) findViewById(R.id.button1);
		delete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				user=patientuser.getEditableText();
				password=patientpassword.getEditableText();
				//delete patient profile
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("DELETE  FROM patient WHERE patientID = '"+ user +"' AND password= '"+ password +"'");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "data deleted",
	        			   Toast.LENGTH_LONG).show();
			}
		});
	}

}
