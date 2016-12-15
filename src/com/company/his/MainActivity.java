package com.company.his;
//author abdullah al rashid and his team members
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
Intent adminscreen,doctorscreen,patientscreen;

static SQLiteDatabase db=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//create the sqlit database with the tables
		try{
			db=openOrCreateDatabase("mx",MODE_PRIVATE,null);
			db.execSQL("CREATE TABLE IF NOT EXISTS adminUser(adminID VARCHAR,password VARCHAR);");
			db.execSQL("CREATE TABLE IF NOT EXISTS patient(patientID VARCHAR,password VARCHAR,firstname VARCHAR,lastname VARCHAR,age VARCHAR,phone VARCHAR,email VARCHAR);");
			db.execSQL("CREATE TABLE IF NOT EXISTS doctor(doctorID VARCHAR,password VARCHAR,firstname VARCHAR,lastname VARCHAR,specialty VARCHAR,phone VARCHAR,email VARCHAR);");
			db.execSQL("CREATE TABLE IF NOT EXISTS report(reportID VARCHAR,doctorID VARCHAR,patientID VARCHAR,details VARCHAR);");
			db.execSQL("CREATE TABLE IF NOT EXISTS medicine(medicineID VARCHAR,name VARCHAR,description VARCHAR,quantity VARCHAR,doctorId VARCHAR,patientID VARCHAR);");
			db.execSQL("CREATE TABLE IF NOT EXISTS complaint(complaintID VARCHAR,subject VARCHAR,detail VARCHAR,response VARCHAR,patientID VARCHAR);");
			db.execSQL("CREATE TABLE IF NOT EXISTS appointment(appointmentID VARCHAR,appDate VARCHAR,appTime VARCHAR,adminID VARCHAR,doctorID VARCHAR,patientID VARCHAR);");
			db.execSQL("CREATE TABLE IF NOT EXISTS evaluation(evaluationID VARCHAR,reason VARCHAR,patientID VARCHAR,adminID VARCHAR,doctorID VARCHAR);");

			db.beginTransaction();
			db.execSQL("INSERT INTO adminUser VALUES('admin','123456')");
			db.setTransactionSuccessful();
			db.endTransaction();
		}catch(Exception ex){ex.printStackTrace();}
		Button admin=(Button) findViewById(R.id.button1);
	
		admin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
					
				adminscreen= new Intent(MainActivity.this,AdminLog.class);
				startActivity(adminscreen);
				}
				catch (Exception ex){ex.printStackTrace();}
			}
		});
		
		Button doctor=(Button) findViewById(R.id.button2);
		
		doctor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
					
				doctorscreen= new Intent(MainActivity.this,DoctorLog.class);
				startActivity(doctorscreen);
				}
				catch (Exception ex){ex.printStackTrace();}
			}
		});
		
		Button patient=(Button) findViewById(R.id.button3);
		
		patient.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
					
				patientscreen= new Intent(MainActivity.this,PatientLog.class);
				startActivity(patientscreen);
				}
				catch (Exception ex){ex.printStackTrace();}
			}
		});
	}
}
