
package com.garde.neha;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;

import android.widget.TextView;

public class cprog20 extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cprog1);
		TextView helloTxt = (TextView)findViewById(R.id.hellotxt);
        helloTxt.setText(readTxt());
	
	}
	private String readTxt(){

	     InputStream inputStream = getResources().openRawResource(R.raw.cprog20);
	     
	     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	     
	     int i;
	     try {
	    	 i = inputStream.read();
	    	 while (i != -1)
	    	 {
	    		 byteArrayOutputStream.write(i);
	    		 i = inputStream.read();
	    	 }
	    	 inputStream.close();
	     } catch (IOException e) {
	   // TODO Auto-generated catch block
	    	 e.printStackTrace();
	     }
	  
	     return byteArrayOutputStream.toString();
	}

}
