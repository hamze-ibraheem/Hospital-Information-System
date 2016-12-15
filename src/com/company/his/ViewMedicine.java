package com.company.his;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.ExpandableListView.OnChildClickListener;


public class ViewMedicine extends Activity{
	  ExpandableListAdapter listAdapter;
	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;
	    TextView txtDoctor;
	    TextView txtPatient;
	    TextView txtDescription;
	    TextView txtQuantity;
	  //  TextView txtPhone;
	   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewmedicine);
		 txtQuantity=(TextView) findViewById(R.id.textView1);
		 txtDoctor=(TextView) findViewById(R.id.textView2);
		 txtPatient=(TextView) findViewById(R.id.textView3);
		 txtDescription=(TextView) findViewById(R.id.textView4);
		// txtQuantity=(TextView) findViewById(R.id.textView5);
		
		 // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp3);
 
		try{
			
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("medicines available");
	        
	        // Adding child data
	        List<String> reportsavailable = new ArrayList<String>();
	       
	        
	        
	     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM medicine WHERE patientID='"+ PatientLog.userl +"'" , null);
        	c.moveToFirst();
        	while (!c.isAfterLast()){
        		  // preparing list data
        	     // prepareListData(c.getString(0));
        	if(PatientLog.userl.toString().equals(c.getString(5))){
        	      reportsavailable.add(c.getString(1));

		
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
	    			
	    			//view medicine for patient
	    	     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM medicine WHERE name='"+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) +"'" , null);
	            	c.moveToFirst();
	            	while (!c.isAfterLast()){
	            		  
	            	if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equals(c.getString(1))){
	            		txtQuantity.setText(c.getString(3));
	            		txtDoctor.setText(c.getString(4));
	            		  txtPatient.setText(c.getString(5));
	            		  txtDescription.setText(c.getString(2));
	            		  
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
