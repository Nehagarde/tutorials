package com.garde.neha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Take_Quiz extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.take_quiz);
		Thread timer=new Thread(){
			public void run(){
			
				try{
					sleep(1200);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity=new Intent("com.garde.neha.q1");
					startActivity(openMainActivity);
				}
				
			}
	};
	timer.start();

}
}
