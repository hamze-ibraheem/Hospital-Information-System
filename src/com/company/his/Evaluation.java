package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Evaluation extends Activity{
	EditText evaluateid,reason,patientid,adminid,doctorid;
	Editable evaluate,ereason,patient,admin,doctor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.evaluate);
		evaluateid=(EditText)findViewById(R.id.editText1);
		reason=(EditText)findViewById(R.id.editText2);
		patientid=(EditText)findViewById(R.id.editText3);
		adminid=(EditText)findViewById(R.id.editText4);
		doctorid=(EditText)findViewById(R.id.editText5);
		
		
		Button save=(Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				evaluate=evaluateid.getEditableText();
				ereason=reason.getEditableText();
				patient=patientid.getEditableText();
				admin=adminid.getEditableText();
				doctor=doctorid.getEditableText();
			
				//insert new evaluation for the doctor
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("INSERT INTO evaluation VALUES('"+ evaluate +"','"+ ereason +"','"+ patient +"','"+ admin +"','"+ doctor +"')");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "devaluate created",
	        			   Toast.LENGTH_LONG).show();

			}
		});
	}
}
