package com.example.hp1.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sign extends Activity implements OnClickListener{
Button breturn;
TextView tvsign,tvmail,tvpassword;
EditText etmail,etpassword;
String mail;
String pass;
Boolean p=false;
Boolean e=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign);
		breturn=(Button)findViewById(R.id.breturn);
		
		tvsign=(TextView)findViewById(R.id.tvsign);
		tvmail=(TextView)findViewById(R.id.tvmail);
		tvpassword=(TextView)findViewById(R.id.tvpassword);
		
		etmail=(EditText)findViewById(R.id.etmail);
		etpassword=(EditText)findViewById(R.id.etpassword);
		
		breturn.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==breturn){
			Intent intent=new Intent(Sign.this,MainActivity.class);
			startActivity(intent);
		}
		
	}
	
	
	
}
