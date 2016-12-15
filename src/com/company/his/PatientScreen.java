package com.company.his;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class PatientScreen extends Activity{
	Intent patientProfile,writecomplaint,viewreport,viewmedicine,evaluate,makeappointment,manageappointment,changepassword,logout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientscreen);
		ImageButton pProfile=(ImageButton) findViewById(R.id.imageButton1);
		pProfile.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				patientProfile= new Intent(PatientScreen.this,PatientProfileEdit.class);
				startActivity(patientProfile);
			}
		});
		
		ImageButton wComplaint=(ImageButton) findViewById(R.id.imageButton2);
		wComplaint.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				writecomplaint= new Intent(PatientScreen.this,WriteComplaint.class);
				startActivity(writecomplaint);
			}
		});
		ImageButton vReport=(ImageButton) findViewById(R.id.imageButton3);
		vReport.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				viewreport= new Intent(PatientScreen.this,PatientReport.class);
				startActivity(viewreport);
			}
		});
		
		ImageButton vMedicine=(ImageButton) findViewById(R.id.imageButton4);
		vMedicine.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				viewmedicine= new Intent(PatientScreen.this,ViewMedicine.class);
				startActivity(viewmedicine);
			}
		});
		
		ImageButton evu=(ImageButton) findViewById(R.id.imageButton5);
		evu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				evaluate= new Intent(PatientScreen.this,Evaluation.class);
				startActivity(evaluate);
			}
		});
		
		ImageButton mAppointment=(ImageButton) findViewById(R.id.imageButton6);
		mAppointment.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				makeappointment= new Intent(PatientScreen.this,PatientAppointment.class);
				startActivity(makeappointment);
			}
		});
		ImageButton manageAppoi=(ImageButton) findViewById(R.id.imageButton7);
		manageAppoi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				manageappointment= new Intent(PatientScreen.this,ManageAppointment.class);
				startActivity(manageappointment);
			}
		});
		
		ImageButton cPassword=(ImageButton) findViewById(R.id.imageButton8);
		cPassword.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				changepassword= new Intent(PatientScreen.this,PatientChangePassword.class);
				startActivity(changepassword);
			}
		});
		
		ImageButton lout=(ImageButton) findViewById(R.id.imageButton9);
		lout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				logout= new Intent(PatientScreen.this,PatientLog.class);
				startActivity(logout);
			}
		});
		
		
	}
}
