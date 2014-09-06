package com.garde.neha;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Cprogs extends ListActivity{

	
	String classes[]={"cprog1","cprog2","cprog3","cprog4","cprog5","cprog6","cprog7","cprog8","cprog9","cprog10","cprog11","cprog12","cprog13","cprog14","cprog15","cprog16","cprog17","cprog18","cprog19","cprog20"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Cprogs.this,R.layout.listv,classes ));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{
			String cheese=classes[position];
			Class ourClass= Class.forName("com.garde.neha."+cheese);
			Intent i1=new Intent(Cprogs.this,ourClass);
			startActivity(i1);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	
}
