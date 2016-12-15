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


public class ManageAppointment extends Activity{
	  ExpandableListAdapter listAdapter;
	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;
	    TextView txtAppDate;
	    TextView txtAppTime;
	    TextView txtAdmin;
	    TextView txtDoctor;
	    TextView txtPatient;
	   String appointmentuser="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manageappointment);
		txtAppDate=(TextView) findViewById(R.id.textView1);
		txtAppTime=(TextView) findViewById(R.id.textView2);
		txtAdmin=(TextView) findViewById(R.id.textView3);
		txtDoctor=(TextView) findViewById(R.id.textView4);
		txtPatient=(TextView) findViewById(R.id.textView5);
		
		 // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp6);
 
		try{
			
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("appointments available");
	        
	        // Adding child data
	        List<String> reportsavailable = new ArrayList<String>();
	       
	        
	        
	     	Cursor c=MainActivity.db.rawQuery("SELECT appointmentID FROM appointment" , null);
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
	    			
	    			
	    	     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM appointment WHERE appointmentID='"+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) +"'" , null);
	            	c.moveToFirst();
	            	while (!c.isAfterLast()){
	            		  
	            	if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equals(c.getString(0))){
	            		appointmentuser=c.getString(0);
	            		txtAppDate.setText(c.getString(1));
	            		txtAppTime.setText(c.getString(2));
	            		  txtAdmin.setText(c.getString(3));
	            		  txtDoctor.setText(c.getString(4));
	            		  txtPatient.setText(c.getString(5));
	            		  
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
	        
	Button deleteApp=(Button)findViewById(R.id.button1);
	deleteApp.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
	    	try{
    			
    			
	    		MainActivity.db.beginTransaction();
				MainActivity.db.execSQL("DELETE  FROM appointment WHERE appointmentID = '"+ appointmentuser +"'");
				MainActivity.db.setTransactionSuccessful();
				MainActivity.db.endTransaction();
				Toast.makeText(getApplicationContext(), "appointment deleted",
	        			   Toast.LENGTH_LONG).show();
            		
            		
            	}
    			
    			catch(Exception ex){
    				ex.printStackTrace();
    			}
    			finally{}
		}
	});
	 
	
	
	
	}

    
	}
