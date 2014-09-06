package com.garde.neha;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class q6 extends Activity implements OnClickListener,OnCheckedChangeListener{

	TextView t1,t2;
	RadioButton b1,b2,b3,b4;
	RadioGroup r1;
	MediaPlayer mp;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.q2);
		t1=(TextView)findViewById(R.id.que);
		
		t2=(TextView)findViewById(R.id.ans);
		t2.setVisibility(View.GONE);
		r1=(RadioGroup)findViewById(R.id.rg1);
		r1.setOnCheckedChangeListener(this);
		b=(Button)findViewById(R.id.btn);
		b.setOnClickListener(this);
		b1=(RadioButton)findViewById(R.id.a);
		b2=(RadioButton)findViewById(R.id.b);
		b3=(RadioButton)findViewById(R.id.c);
		b4=(RadioButton)findViewById(R.id.d);
		t1.setText(Html.fromHtml("By default a real number is treated as?"));
		t2.setText(Html.fromHtml("Answer: Option B" +
				"\nExplanation: In computing, 'real number' often refers to non-complex floating-point numbers. It include both rational numbers," +
				" such as 42 and 3/4, and irrational numbers such as pi = 3.14159265... " +
				"When the accuracy of the floating point number is insufficient, we can use the double to define the number. The double is same as float but with longer precision and takes double space (8 bytes) than float." +
				"To extend the precision further we can use long double which occupies 10 bytes of memory space."));
		b1.setText(Html.fromHtml("A.	float"));
		b2.setText(Html.fromHtml("B.	double"));
		b3.setText(Html.fromHtml("C.    long double"));
		b4.setText(Html.fromHtml("D.    far double"));
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent("com.garde.neha.q7");
		startActivity(i);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg1==R.id.b){
			mp=MediaPlayer.create(q6.this,R.raw.m2);
			mp.start();
		}
		else{
			mp=MediaPlayer.create(q6.this,R.raw.m1);
			mp.start();
		}
		t2.setVisibility(View.VISIBLE);
	
	}

}
