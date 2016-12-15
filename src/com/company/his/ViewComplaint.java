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


public class ViewComplaint extends Activity{
	  ExpandableListAdapter listAdapter;
	    ExpandableListView expListView;
	    List<String> listDataHeader;
	    HashMap<String, List<String>> listDataChild;
String getPatient;
	  //  TextView txtPhone;
TextView getComplaint;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewcomplaint);
	 getComplaint=(TextView)findViewById(R.id.textView1);
		
		 // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp8);
 
		try{
			
	        listDataHeader = new ArrayList<String>();
	        listDataChild = new HashMap<String, List<String>>();
	 
	        // Adding child data
	        listDataHeader.add("patients available");
	        
	        // Adding child data
	        List<String> reportsavailable = new ArrayList<String>();
	       
	        
	        
	     	Cursor c=MainActivity.db.rawQuery("SELECT patientID FROM patient " , null);
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
	    			
	    			//get the complaint
			     	Cursor c=MainActivity.db.rawQuery("SELECT * FROM complaint WHERE patientID = '"+ listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition) +"'" , null);
	            	c.moveToFirst();
	            	while (!c.isAfterLast()){
	            		  
	            	if (listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).equals(c.getString(5))){
	            	//getPatient=listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition);
	            	 getComplaint.setText(c.getString(1));
	            		  
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
	        
	
	 /*
			 // get the listview
	        expListView2 = (ExpandableListView) findViewById(R.id.lvExp9);
	 
			try{
				
		        listDataHeader2 = new ArrayList<String>();
		        listDataChild2 = new HashMap<String, List<String>>();
		 
		        // Adding child data
		        listDataHeader2.add("complaints available");
		        
		        // Adding child data
		        List<String> reportsavailable2 = new ArrayList<String>();
		       
		        
		        
		     	Cursor c2=MainActivity.db.rawQuery("SELECT subject FROM complaint WHERE patientID = '"+ getPatient +"'" , null);
	        	c2.moveToFirst();
	        	while (!c2.isAfterLast()){
	        		  // preparing list data
	        	     // prepareListData(c.getString(0));
	    
	        	      reportsavailable2.add(c2.getString(1));

			
	        	      c2.moveToNext();
	        	
	        	}
	        	listDataChild2.put(listDataHeader2.get(0), reportsavailable2); // Header, Child data
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				finally{}
	        listAdapter2 = new ExpandableListAdapter(this, listDataHeader2, listDataChild2);

		      // setting list adapter
		      expListView2.setAdapter(listAdapter2);
		      
	*/
	
	}

    
	}
