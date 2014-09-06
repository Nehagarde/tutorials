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

public class q3 extends Activity implements OnClickListener,OnCheckedChangeListener{

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
		t1.setText(Html.fromHtml("Is there any difference between following declarations?" +
				"1 :	extern int fun();" +
				"2 :	int fun();"));
		t2.setText(Html.fromHtml("Answer: Option B " +
				"Explanation:" +
				"extern int fun(); declaration in C is to indicate the existence of a global function and it is defined externally to the current module or in another file." +
				"int fun(); declaration in C is to indicate the existence of a function inside the current module or in the same file."));
		b1.setText(Html.fromHtml("A.	Both are identical"));
		b2.setText(Html.fromHtml("B.	No difference, except extern int fun(); is probably in another file"));
		b3.setText(Html.fromHtml("C.	int fun(); is overrided with extern int fun();"));
		b4.setText(Html.fromHtml("D.	None of these"));
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent i=new Intent("com.garde.neha.q4");
		startActivity(i);
		
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		if(arg1==R.id.b){
			mp=MediaPlayer.create(q3.this,R.raw.m2);
			mp.start();
		}
		else{
			mp=MediaPlayer.create(q3.this,R.raw.m1);
			mp.start();
		}
		t2.setVisibility(View.VISIBLE);
	
	}

}
