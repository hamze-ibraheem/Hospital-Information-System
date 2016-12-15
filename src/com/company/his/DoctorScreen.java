package com.company.his;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class DoctorScreen extends Activity{
	Intent doctorProfile,addreport,writemedicine,managereport,manageappointment,changepassword,logout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.doctorscreen);
		ImageButton doctoredit=(ImageButton) findViewById(R.id.imageButton1);
		doctoredit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			doctorProfile= new Intent(DoctorScreen.this,DoctorProfileEdit.class);
				startActivity(doctorProfile);
			}
		});
		
		ImageButton doctorAddReport=(ImageButton) findViewById(R.id.imageButton2);
		doctorAddReport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addreport= new Intent(DoctorScreen.this,AddDoctorReport.class);
				startActivity(addreport);
			}
		});
		ImageButton writeMedicine=(ImageButton) findViewById(R.id.imageButton3);
		writeMedicine.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				writemedicine= new Intent(DoctorScreen.this,Medicine.class);
				startActivity(writemedicine);
			}
		});
		
		ImageButton manageReport=(ImageButton) findViewById(R.id.imageButton4);
		manageReport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				managereport= new Intent(DoctorScreen.this,ManageReport.class);
				startActivity(managereport);
			}
		});
		
		ImageButton manageAppointment=(ImageButton) findViewById(R.id.imageButton5);
		manageAppointment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				manageappointment= new Intent(DoctorScreen.this,ManageAppointment.class);
				startActivity(manageappointment);
			}
		});
		
		ImageButton changePassword=(ImageButton) findViewById(R.id.imageButton6);
		changePassword.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				changepassword= new Intent(DoctorScreen.this,DoctorChangePassword.class);
				startActivity(changepassword);
			}
		});
		ImageButton logOut=(ImageButton) findViewById(R.id.imageButton7);
		logOut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				logout= new Intent(DoctorScreen.this,DoctorLog.class);
				startActivity(logout);
			}
		});
		

	}
}
