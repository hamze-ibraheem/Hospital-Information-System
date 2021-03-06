package com.company.his;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;


public class PatientAppointment extends Activity{
	EditText appid,appdate,apptime,adminid,patientid;
	Editable apointment,date,time,admin,patient;
	  ExpandableListAdapter listAdapter;
	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;
	    String doctoruser="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patientappointment);
		appid=(EditText)findViewById(R.id.editText1);
		appdate=(EditText)findViewById(R.id.editText2);
		apptime=(EditText)findViewById(R.id.editText3);
		adminid=(EditText)findViewById(R.id.editText4);
		patientid=(EditText)findViewById(R.id.editText5);
		 expListView = (ExpandableListView) findViewById(R.id.lvExp4);
		 
			try{
				
		        listDataHeader = new ArrayList<String>();
		        listDataChild = new HashMap<String, List<String>>();
		 
		        // Adding child data
		        listDataHeader.add("doctors available");
		        
		        // Adding child data
		        List<String> reportsavailable = new ArrayList<String>();
		       
		        
		        
		     	Cursor c=MainActivity.db.rawQuery("SELECT doctorID FROM doctor " , null);
	        	c.moveToFirst();
	        	while (!c.isAfterLast()){
	        		  // preparing list data
	        	     // prepareListData(c.getString(0));
	        	
	        	      reportsavailable.add(c.getString(0));

			
	        	      c.moveToNext();
	        	}
	        	
	        	listDataChild.put(listDataHeader.get(0), reportsavailable); // Header, Child data
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				finally{}
	        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		      // setting list adapter
		      expListView.setAdapter(listAdapter);
		      
		      // Listview on child click listener
		        expListView.setOnChildClickListener(new OnChildClickListener() {
		 
		            @Override
		            public boolean onChildClick(ExpandableListView parent, View v,
		                    int groupPosition, int childPosition, long id) {
		            	
		            	
		              
		          	try{
		    			
		    			//view patient appointment
		    	     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM appointment WHERE doctorID='"+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) +"'" , null);
		            	c.moveToFirst();
		            	while (!c.isAfterLast()){
		            		  
		            	if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equals(c.getString(4))){
		            	
		            		  doctoruser=c.getString(4);
		            	}
		            		

		    			c.moveToNext();
		            		
		            		
		            	}
		    			}
		    			catch(Exception ex){
		    				ex.printStackTrace();
		    			}
		    			finally{}
		              
		                return false;
		            }
		        });
		        
				
				        
				        
		Button save=(Button) findViewById(R.id.button1);
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				apointment=appid.getEditableText();
				date=appdate.getEditableText();
				time=apptime.getEditableText();
				admin=adminid.getEditableText();
				patient=patientid.getEditableText();
				
				MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("INSERT INTO appointment VALUES('"+ apointment +"','"+ date +"','"+ time +"','"+ admin +"','"+ doctoruser +"','"+ patient +"')");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "appointment created",
	        			   Toast.LENGTH_LONG).show();
				
		    	/*try{
	    			
			     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM patient WHERE patientID='"+ txtPatient.getText() +"'" , null);
	            	c.moveToFirst();
	            	while (!c.isAfterLast()){
	            		  
	            	//txtPhone.setText(c.getString(6));
	            	 
	                SmsManager sms = SmsManager.getDefault();
				       sms.sendTextMessage(txtPhone.getText().toString(), null, txtDetails.getText().toString(), null, null);
	      		

	    			c.moveToNext();
	            		
	            		
	            	}
	         
	            

	            		
	            		
	            	}
	    			
	    			catch(Exception ex){
	    				ex.printStackTrace();
	    			}
	    			finally{}*/

			}
		});
	}
}