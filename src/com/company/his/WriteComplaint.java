package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class WriteComplaint extends Activity{
	EditText complaintid,csubject,cdetail,cresponse,adminid,patientid;
	Editable complaint,subject,detail,response,admin,patient;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.writecomplaint);
		complaintid=(EditText)findViewById(R.id.editText1);
		csubject=(EditText)findViewById(R.id.editText2);
		cdetail=(EditText)findViewById(R.id.editText3);
		cresponse=(EditText)findViewById(R.id.editText4);
		//adminid=(EditText)findViewById(R.id.editText5);
		patientid=(EditText)findViewById(R.id.editText6);
		
		
		Button save=(Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				complaint=complaintid.getEditableText();
				subject=csubject.getEditableText();
				detail=cdetail.getEditableText();
				response=cresponse.getEditableText();
				//admin=adminid.getEditableText();
				patient=patientid.getEditableText();
			
				//write new complaint
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("INSERT INTO complaint VALUES('"+ complaint +"','"+ subject +"','"+ detail +"','"+ response +"','"+ patient +"')");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "complaint sent to admin",
	        			   Toast.LENGTH_LONG).show();

			}
		});
	}
}