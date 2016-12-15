package com.company.his;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class AdminScreen extends Activity{
	// create intent object to navigate between admin screens
	Intent patientProfile,patientProfileDelete,patientProfileEdit,adminchangepassword,adminlogout,doctorProfile,doctorProfileEdit,doctorProfileDelete,manageAppointment,viewcomplaint,viewevaluate;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.adminscreen);
		ImageButton patientAdd=(ImageButton) findViewById(R.id.imageButton1);
		patientAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				patientProfile= new Intent(AdminScreen.this,PatientProfile.class);
				startActivity(patientProfile);
			}
		});
		
		ImageButton patientDelete=(ImageButton) findViewById(R.id.imageButton2);
		patientDelete.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				patientProfileDelete= new Intent(AdminScreen.this,PatientProfileDelete.class);
				startActivity(patientProfileDelete);
			}
		});
		ImageButton patientEdit=(ImageButton) findViewById(R.id.imageButton3);
		patientEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				patientProfileEdit= new Intent(AdminScreen.this,PatientProfileEdit.class);
				startActivity(patientProfileEdit);
			}
		});
		
		ImageButton changepassword=(ImageButton) findViewById(R.id.imageButton6);
		changepassword.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				adminchangepassword= new Intent(AdminScreen.this,AdminchangePassword.class);
				startActivity(adminchangepassword);
			}
		});
		
		ImageButton logout=(ImageButton) findViewById(R.id.imageButton4);
		logout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				adminlogout= new Intent(AdminScreen.this,AdminLog.class);
				startActivity(adminlogout);
			}
		});
		
		ImageButton createdoctor=(ImageButton) findViewById(R.id.imageButton5);
		createdoctor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				doctorProfile= new Intent(AdminScreen.this,DoctorProfile.class);
				startActivity(doctorProfile);
			}
		});
		ImageButton editdoctor=(ImageButton) findViewById(R.id.imageButton7);
		editdoctor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				doctorProfileEdit= new Intent(AdminScreen.this,DoctorProfileEdit.class);
				startActivity(doctorProfileEdit);
			}
		});
		
		ImageButton deletedoctor=(ImageButton) findViewById(R.id.imageButton8);
		deletedoctor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				doctorProfileDelete= new Intent(AdminScreen.this,DoctorProfileDelete.class);
				startActivity(doctorProfileDelete);
			}
		});
		
		ImageButton manageApp=(ImageButton) findViewById(R.id.imageButton9);
		manageApp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				manageAppointment= new Intent(AdminScreen.this,ManageAdminappointment.class);
				startActivity(manageAppointment);
			}
		});
		
		ImageButton viewComplaint=(ImageButton) findViewById(R.id.imageButton10);
		viewComplaint.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				viewcomplaint= new Intent(AdminScreen.this,ViewComplaint.class);
				startActivity(viewcomplaint);
			}
		});
		
		ImageButton viewEvaluation=(ImageButton) findViewById(R.id.imageButton11);
		viewEvaluation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				viewevaluate= new Intent(AdminScreen.this,ViewEvaluation.class);
				startActivity(viewevaluate);
			}
		});
	}
}
