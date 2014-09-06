package com.garde.neha;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	
	String classes[]={"Cprogs","Cppprogs","JavaProgs","HTML","PHP","Camera","Take_Quiz","Feedback"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,R.layout.listv,classes ));
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		try{
			String cheese=classes[position];
			Class ourClass= Class.forName("com.garde.neha."+cheese);
			Intent i1=new Intent(Menu.this,ourClass);
			startActivity(i1);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		 super.onCreateOptionsMenu(menu);
		 MenuInflater mi= getMenuInflater();
		 mi.inflate(R.menu.about, menu);
		 return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		 super.onOptionsItemSelected(item);
		 
		 switch(item.getItemId()){
		 case R.id.about:
			 Intent i=new Intent("com.garde.neha.About");
			 startActivity(i);
			 break;
		 }
		return false;
	}
	
	
}
