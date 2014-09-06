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

public class q2 extends Activity implements OnClickListener,OnCheckedChangeListener{

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
		t1.setText(Html.fromHtml("What are the types of linkages?"));
		t2.setText(Html.fromHtml("Answer: Option B " +
				"Explanation: External Linkage-> means global, non-static variables and functions." +
				"Internal Linkage-> means static variables and functions with file scope." +
				"None Linkage-> means Local variables."));
		b1.setText(Html.fromHtml("A.	Internal and External"));
		b2.setText(Html.fromHtml("B.	External, Internal and None"));
		b3.setText(Html.fromHtml("C.	External and None"));
		b4.setText(Html.fromHtml("D.	Internal"));
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent("com.garde.neha.q3");
		startActivity(i);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg1==R.id.b){
			mp=MediaPlayer.create(q2.this,R.raw.m2);
			mp.start();
		}
		else{
			mp=MediaPlayer.create(q2.this,R.raw.m1);
			mp.start();
		}
		t2.setVisibility(View.VISIBLE);
	
	}

}
