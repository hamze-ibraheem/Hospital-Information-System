package com.company.his;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;


public class PatientReport extends Activity{
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
		setContentView(R.layout.patientreport);
		 txtReport=(TextView) findViewById(R.id.textView1);
		 txtDoctor=(TextView) findViewById(R.id.textView2);
		 txtPatient=(TextView) findViewById(R.id.textView3);
		 txtDetails=(TextView) findViewById(R.id.textView4);
		 txtPhone=(TextView) findViewById(R.id.textView5);
		
		 // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp2);
 
		try{
			
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("reports available");
	        
	        // Adding child data
	        List<String> reportsavailable = new ArrayList<String>();
	       
	        
	        
	     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM report WHERE patientID='"+ PatientLog.userl +"'" , null);
        	c.moveToFirst();
        	while (!c.isAfterLast()){
        		  // preparing list data
        	     // prepareListData(c.getString(0));
        	if(PatientLog.userl.toString().equals(c.getString(2))){
        	      reportsavailable.add(c.getString(0));

		
        	      c.moveToNext();
        	}
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
	    			
	    			//select report from doctors
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
	        
	
	 
	
	
	
	}

    
	}