package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDoctorReport extends Activity{
	EditText reportid,doctorid,patientid,detailsid;
	Editable report,doctor,patient,details;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adddoctorreport);
		//create edit text opbjects
		reportid=(EditText)findViewById(R.id.editText1);
		doctorid=(EditText)findViewById(R.id.editText2);
		patientid=(EditText)findViewById(R.id.editText3);
		detailsid=(EditText)findViewById(R.id.editText4);
	
		//add button save
		Button save=(Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//get the text from the edit text
				report=reportid.getEditableText();
				doctor=doctorid.getEditableText();
				patient=patientid.getEditableText();
				details=detailsid.getEditableText();
		
				//connect o the database and insert the report data
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("INSERT INTO report VALUES('"+ report +"','"+ doctor +"','"+ patient +"','"+ details +"')");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "report  created",
	        			   Toast.LENGTH_LONG).show();

			}
		});
	}
}