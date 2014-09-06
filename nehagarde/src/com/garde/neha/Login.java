package com.garde.neha;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity implements OnClickListener{

	EditText un,pass;
	Button b1,b2,b3;
	String name,passw;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		un=(EditText)findViewById(R.id.un);
		pass=(EditText)findViewById(R.id.pass);
		b1=(Button)findViewById(R.id.Login);
		b2=(Button)findViewById(R.id.Cancel);
		b3=(Button)findViewById(R.id.signup);
		
	//	b5=(Button)findViewById(R.id.Dele);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
	
		//b5.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		 name=un.getText().toString();
		passw=pass.getText().toString();
		boolean wrks=true;
		switch(v.getId()){
		
		case R.id.Login:
			
			dbconn dbc1=new dbconn(this);
			dbc1.open();
			int x=dbc1.checkentry(name,passw);
			if(x==1){
				Intent i=new Intent("com.garde.neha.Splash");
				startActivity(i);
			}
			else{
				Dialog d=new Dialog(this);
				d.setTitle("Error");
				TextView tv=new TextView(this);
				tv.setText("Username/password incorrect.. Sign up if not registered yet!");
				d.setContentView(tv);
				d.show();
			}
			break;
		case R.id.Cancel:
			Intent i=new Intent("com.garde.neha.Login");
			startActivity(i);
			break;
		
		case R.id.signup:
			
			try{
				dbconn dbc=new dbconn(this);
				dbc.open();
				dbc.createacc(name,passw);
				dbc.close();
			}catch(Exception e){
				wrks=false;
				
				String err=e.toString();
				Dialog d=new Dialog(this);
				d.setTitle("Failed");
				TextView tv=new TextView(this);
				tv.setText(err);
				d.setContentView(tv);
				d.show();
			}finally{
				if(wrks){
					Dialog d=new Dialog(this);
					d.setTitle("Success");
					TextView tv=new TextView(this);
					tv.setText("Account Created");
					d.setContentView(tv);
					d.show();
				}
			}
			break;
	/*	case R.id.View:
			Intent in=new Intent("com.garde.neha.Users");
			startActivity(in);
			dbconn dbc2=new dbconn(this);
			dbc2.open();
			dbc2.delete();
			dbc2.close();
			break;
		*/
		
		}
		
	}

}
