package com.company.his;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ManageReport extends Activity{
	  ExpandableListAdapter listAdapter;
	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;
	    TextView txtDoctor;
	    TextView txtPatient;
	    TextView txtDetails;
	    TextView txtReport;
	    TextView txtPhone;
	   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.managereports);
		 txtReport=(TextView) findViewById(R.id.textView1);
		 txtDoctor=(TextView) findViewById(R.id.textView2);
		 txtPatient=(TextView) findViewById(R.id.textView3);
		 txtDetails=(TextView) findViewById(R.id.textView4);
		 txtPhone=(TextView) findViewById(R.id.textView5);
		
		 // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
		try{
			
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("reports available");
	        
	        // Adding child data
	        List<String> reportsavailable = new ArrayList<String>();
	       
	        
	        
	     	Cursor c=MainActivity.db.rawQuery("SELECT reportID FROM report" , null);
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
	    			
	    			
	    	     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM report WHERE reportID='"+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) +"'" , null);
	            	c.moveToFirst();
	            	while (!c.isAfterLast()){
	            		  
	            	if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equals(c.getString(0))){
	            		txtReport.setText(c.getString(0));
	            		txtDoctor.setText(c.getString(1));
	            		  txtPatient.setText(c.getString(2));
	            		  txtDetails.setText(c.getString(3));
	            		  
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
	        
	Button deleteReport=(Button)findViewById(R.id.button1);
	deleteReport.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
	    	try{
    			
    			
	    		MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("DELETE  FROM report WHERE reportID = '"+ txtReport.getText() +"'");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "report deleted",
	        			   Toast.LENGTH_LONG).show();
            		
            		
            	}
    			
    			catch(Exception ex){
    				ex.printStackTrace();
    			}
    			finally{}
		}
	});
	 
	
	Button sendReport=(Button)findViewById(R.id.button2);
	sendReport.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
	    	try{
    			
		     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM patient WHERE patientID='"+ txtPatient.getText() +"'" , null);
            	c.moveToFirst();
            	while (!c.isAfterLast()){
            		  
            	txtPhone.setText(c.getString(6));
            	 
                SmsManager sms = SmsManager.getDefault();
			       sms.sendTextMessage(txtPhone.getText().toString(), null, txtDetails.getText().toString(), null, null);
      		

    			c.moveToNext();
            		
            		
            	}
         
            

            		
            		
            	}
    			
    			catch(Exception ex){
    				ex.printStackTrace();
    			}
    			finally{}
		}
	});
	
	
	}

    
	}