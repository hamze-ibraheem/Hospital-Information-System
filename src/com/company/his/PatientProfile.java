package com.company.his;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientProfile extends Activity{
	EditText userid,userpass,userfirst,userlast,userage,userphone,useremail;
	Editable user,password,firstname,lastname,age,phone,email;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientprofile);
		userid=(EditText)findViewById(R.id.editText1);
		userpass=(EditText)findViewById(R.id.editText2);
		userfirst=(EditText)findViewById(R.id.editText3);
		userlast=(EditText)findViewById(R.id.editText4);
		userage=(EditText)findViewById(R.id.editText5);
		userphone=(EditText)findViewById(R.id.editText6);
		useremail=(EditText)findViewById(R.id.editText7);
		
		Button save=(Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				user=userid.getEditableText();
				password=userpass.getEditableText();
				firstname=userfirst.getEditableText();
				lastname=userlast.getEditableText();
				age=userage.getEditableText();
				phone=userphone.getEditableText();
				email=useremail.getEditableText();
				
				if (user.equals("")|| password.equals("")||firstname.equals("")||lastname.equals("")||age.equals("")||phone.equals("")||email.equals(""))
				{
					Toast.makeText(getApplicationContext(), "insert data",
		        			   Toast.LENGTH_LONG).show();
				}
				else{
				//create patient profile
				if(password.length() <= 8){
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("INSERT INTO patient VALUES('"+ user +"','"+ password +"','"+ firstname +"','"+ lastname +"','"+ age +"','"+ phone +"','"+ email +"')");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "data saved",
	        			   Toast.LENGTH_LONG).show();
				}
				else{
					Toast.makeText(getApplicationContext(), "password should be less or equal than 8 letters or numbers",
		        			   Toast.LENGTH_LONG).show();
				}
				}
			}
		});
	}
}
