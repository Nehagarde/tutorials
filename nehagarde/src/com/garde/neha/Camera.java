package com.garde.neha;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
public class Camera extends Activity implements View.OnClickListener{

	ImageView iv;
	Button b;
	ImageButton ib;
	Intent i;
	final static int camdat=0;
	Bitmap bmp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cam);
		initialize();
		
		InputStream is=getResources().openRawResource(R.drawable.i1);
		bmp=BitmapFactory.decodeStream(is);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		iv=(ImageView)findViewById(R.id.iv);
		b=(Button)findViewById(R.id.setwall);
		ib=(ImageButton)findViewById(R.id.clickpic);
		b.setOnClickListener(this);
		ib.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.clickpic:
			
			i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i,camdat);
			break;
			
		case R.id.setwall:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras= data.getExtras();
			bmp=(Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}

	
	
}
