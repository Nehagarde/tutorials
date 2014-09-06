package com.garde.neha;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class q1 extends Activity implements OnClickListener,OnCheckedChangeListener{

	TextView t1,t2;
	RadioButton b1,b2,b3,b4;
	RadioGroup r1;
	MediaPlayer mp;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.q1);
		t1=(TextView)findViewById(R.id.que);
		t2=(TextView)findViewById(R.id.ans);
		t2.setVisibility(View.GONE);
		r1=(RadioGroup)findViewById(R.id.rg1);
		r1.setOnCheckedChangeListener(this);
		b=(Button)findViewById(R.id.btn);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	
		Intent openMainActivity=new Intent("com.garde.neha.q2");
		startActivity(openMainActivity);
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg1==R.id.c){
			mp=MediaPlayer.create(q1.this,R.raw.m2);
			mp.start();
		}
		else{
			mp=MediaPlayer.create(q1.this,R.raw.m1);
			mp.start();
		}
		t2.setVisibility(View.VISIBLE);
	
	}

}
