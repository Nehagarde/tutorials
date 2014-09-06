package com.garde.neha;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class dbconn {

	private DbHelper dbhelp;
	private final Context ct;
	private SQLiteDatabase datb;
	private static class DbHelper extends SQLiteOpenHelper{

		public DbHelper(Context context) {
			super(context, "users", null, 1);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE dbtable(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
			"uname TEXT NOT NULL," +
				"passw TEXT NOT NULL);");
					
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			// TODO Auto-generated method stub
			db.execSQL("DELETE TABLE IF EXISTS dbtable");
			onCreate(db);
		}
		
	
	}
	
	public dbconn(Context c){
		ct=c;
	}
	
	
	public dbconn open() throws SQLException{
		dbhelp=new DbHelper(ct);
		datb=dbhelp.getWritableDatabase();
		return this;
	}
	
	public void close(){
		dbhelp.close();
	}
	
	public long createacc(String un,String pas){
		
		String[] cols=new String[]{"id","uname","passw"};
		Cursor c=datb.query("dbtable", cols, null, null, null, null, null);
		boolean flag=false;
		int name=c.getColumnIndex("uname");
		int passw=c.getColumnIndex("passw");
	
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			
			String n=c.getString(name);
			String p=c.getString(passw);
			if(n.equals(un) && p.equals(pas)){
				flag=true;
			}
		}
		
		if(!flag){
			ContentValues cv=new ContentValues();
			cv.put("uname",un);
			cv.put("passw",pas);
			return datb.insert("dbtable",null,cv);
		}
		else{
			
			return (Long) null;
		}
	}


	public String getData() {
		// TODO Auto-generated method stub
		String[] cols=new String[]{"id","uname","passw"};
		Cursor c=datb.query("dbtable", cols, null, null, null, null, null);
		String res="";
		
		int row=c.getColumnIndex("id");
		int name=c.getColumnIndex("uname");
		int passw=c.getColumnIndex("passw");
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			res=res+c.getString(row)+"    "+c.getString(name)+"    "+c.getString(passw) +"\n";
		}
		return res;
	}


	public int checkentry(String u,String p) {
		// TODO Auto-generated method stub
		String[] cols=new String[]{"id","uname","passw"};
		Cursor c=datb.query("dbtable", cols, null, null, null, null, null);
		String res="";
		
		
		int name=c.getColumnIndex("uname");
		int passw=c.getColumnIndex("passw");
		
		for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
			String x=c.getString(name);
			String y=c.getString(passw);
			if(x.equals(u) && y.equals(p) ){
				return 1;
			}
			
			
		}
		return 0;
	}


	public void delete() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++){
		datb.delete("dbtable","id="+i, null);
		}
	}





}
