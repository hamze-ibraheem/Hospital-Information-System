package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Medicine extends Activity{
	EditText medicineid,medicinename,medicinedesc,medicinequantity,doctorid,patientid;
	Editable id,name,desc,quantity,doctor,patient;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.medicine);
		medicineid=(EditText)findViewById(R.id.editText1);
		medicinename=(EditText)findViewById(R.id.editText2);
		medicinedesc=(EditText)findViewById(R.id.editText3);
		medicinequantity=(EditText)findViewById(R.id.editText4);
		doctorid=(EditText)findViewById(R.id.editText5);
		patientid=(EditText)findViewById(R.id.editText6);
		
		
		Button save=(Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				id=medicineid.getEditableText();
				name=medicinename.getEditableText();
				desc=medicinedesc.getEditableText();
				quantity=medicinequantity.getEditableText();
				doctor=doctorid.getEditableText();
				patient=patientid.getEditableText();
				
				//insert new medicine
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("INSERT INTO medicine VALUES('"+ id +"','"+ name +"','"+ desc +"','"+ quantity +"','"+ doctor +"','"+ patient +"')");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "medicine  added to patient",
	        			   Toast.LENGTH_LONG).show();

			}
		});
	}
}