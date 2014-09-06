package com.garde.neha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends Activity implements View.OnClickListener {

	EditText etName,etAge,etFeed;
	String stName,stAge,stFeed;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}

	private void initializeVars() {
		// TODO Auto-generated method stub
		etName = (EditText) findViewById(R.id.etName);
		etAge = (EditText) findViewById(R.id.etAge);
		etFeed = (EditText) findViewById(R.id.etFeed);
		
		sendEmail = (Button) findViewById(R.id.bSend);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

		String email="neha.r.garde@gmail.com";
		convertToText();
		String emailaddress[] = {email};
		String message = "Name:"
				+ '\n' +stName
				+ '\n' + "Age:"
				+ stAge
				+ '\n'+"Comments: "
				+ stFeed;

		
		Intent in=new Intent(android.content.Intent.ACTION_SEND);
		in.putExtra(android.content.Intent.EXTRA_EMAIL,emailaddress);
		in.putExtra(android.content.Intent.EXTRA_SUBJECT, "Feed Back");
		in.setType("plain/text");
		in.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(in);
	}

	private void convertToText() {
		// TODO Auto-generated method stub
		stName = etName.getText().toString();
		stAge= etAge.getText().toString();
		stFeed = etFeed.getText().toString();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}