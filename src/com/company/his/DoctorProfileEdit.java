package com.company.his;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorProfileEdit extends Activity{
	EditText userid,userpass,userfirst,userlast,userspecialty,userphone,useremail;
	Editable user,password,firstname,lastname,specialty,phone,email;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctorprofileedit);
		
		userid=(EditText)findViewById(R.id.editText1);
		userpass=(EditText)findViewById(R.id.editText2);
		userfirst=(EditText)findViewById(R.id.editText3);
		userlast=(EditText)findViewById(R.id.editText4);
		userspecialty=(EditText)findViewById(R.id.editText5);
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
				specialty=userspecialty.getEditableText();
				phone=userphone.getEditableText();
				email=useremail.getEditableText();
				//edit doctor profile
				if (password.length() >= 8){
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("UPDATE doctor SET doctorID='"+ user +"',password='"+ password +"',firstname='"+ firstname +"',lastname='"+ lastname +"',specialty='"+ specialty +"',phone='"+ phone +"',email='"+ email +"' WHERE doctorID= '"+ user +"'");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "data updated",
	        			   Toast.LENGTH_LONG).show();
				}
				else{
					Toast.makeText(getApplicationContext(), "password should be more than 8 letters or numbers",
		        			   Toast.LENGTH_LONG).show();
				}
			}
		});
		
	}
}
