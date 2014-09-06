package com.garde.neha;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

public class Users extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.users);
		TextView tv=(TextView)findViewById(R.id.ulist);
		dbconn info=new dbconn(this);
		info.open();
		String data=info.getData();
		info.close();
		tv.setText(data);
	}

	
}
