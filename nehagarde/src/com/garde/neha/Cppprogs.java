package com.garde.neha;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Cppprogs extends ListActivity{

	
	String classes[]={"pgm1","pgm2","pgm3","pgm4","pgm5","pgm6","pgm7","pgm8","pgm9","pgm10","pgm11","pgm12","pgm13","pgm14","pgm15","pgm16","pgm17","pgm18","pgm19","pgm20",};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Cppprogs.this,R.layout.listv,classes ));
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		try{
			String cheese=classes[position];
			Class ourClass= Class.forName("com.garde.neha."+cheese);
			Intent i1=new Intent(Cppprogs.this,ourClass);
			startActivity(i1);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	
}
