package com.company.his;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;


public class ManageAdminappointment extends Activity{
	  ExpandableListAdapter listAdapter;
	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;

	   String appointmentdoctor="";
	   String appointmentpatient="";
	   String getApp="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manageadminappointment);

		 // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp7);
 
		try{
			
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("appointments available");
	        
	        // Adding child data
	        List<String> reportsavailable = new ArrayList<String>();
	       
	        
	        
	     //	Cursor c=MainActivity.db.rawQuery("SELECT appointmentID FROM appointment" , null);
        //	c.moveToFirst();
        //	while (!c.isAfterLast()){
        		  // preparing list data
        	     // prepareListData(c.getString(0));
        	
        	      reportsavailable.add("Doctor");
        	      reportsavailable.add("Patient");
		
        	   //   c.moveToNext();
        		
        	
        	listDataChild.put(listDataHeader.get(0), reportsavailable); // Header, Child data
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
			
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

	      // setting list adapter
	      expListView.setAdapter(listAdapter);
	      
	   // Listview on child click listener
	        expListView.setOnChildClickListener(new OnChildClickListener() {
	 
	            @Override
	            public boolean onChildClick(ExpandableListView parent, View v,
	                    int groupPosition, int childPosition, long id) {
	            	
	            	
	              
	          	try{
	    			
	    	     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM appointment" , null);
	            	c.moveToFirst();
	            	while (!c.isAfterLast()){
	            		  
	            	getApp=c.getString(0);
	            		

	    			c.moveToNext();
	            		
	            		
	            	}
	    	     	//Cursor c=MainActivity.db.rawQuery("SELECT * FROM appointment WHERE appointmentID='"+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) +"'" , null);
	            	//c.moveToFirst();
	            //	while (!c.isAfterLast()){
	            		  
	            	if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equals("Doctor")){
	            		appointmentdoctor=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
	            	
	            		  
	            //	}
	            		

	    		//	c.moveToNext();
	            		
	            		
	            	}
	            	if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equals("Patient")){
	            		appointmentpatient=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
	            	
	            		  
	            //	}
	            		

	    		//	c.moveToNext();
	            		
	            		
	            	}
	            	
	    			}
	    			catch(Exception ex){
	    				ex.printStackTrace();
	    			}
	    			finally{}
	              
	                return false;
	            }
	        });
	        
	Button deleteApp=(Button)findViewById(R.id.button1);
	deleteApp.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
	    	try{
    			
    			if(appointmentdoctor=="Doctor" || appointmentpatient=="Patient"){
	    		MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("DELETE  FROM appointment WHERE appointmentID = '"+ getApp +"'");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "appointment deleted",
	        			   Toast.LENGTH_LONG).show();
            		
            		
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
