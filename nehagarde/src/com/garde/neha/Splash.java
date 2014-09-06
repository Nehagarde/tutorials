package com.garde.neha;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle varibl) {
		// TODO Auto-generated method stub
		super.onCreate(varibl);
		setContentView(R.layout.splash);
		mp=MediaPlayer.create(Splash.this,R.raw.wc1);
		mp.start();
		Thread timer=new Thread(){
			public void run(){
			
				try{
					sleep(1500);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity=new Intent("com.garde.neha.Menu");
					startActivity(openMainActivity);
				}
				
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mp.release();
		finish();
	}
	

}
