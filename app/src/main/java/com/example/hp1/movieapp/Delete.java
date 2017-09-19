package com.example.hp1.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Delete extends Activity implements OnClickListener{
Button breturn,bdelete;
TextView tvmail,tvpass,tvdelete;
EditText etmail,etpass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		breturn=(Button)findViewById(R.id.breturn);
	//	bdelete=(Button)findViewById(R.id.delete);
		
		tvmail=(TextView)findViewById(R.id.tvmail);
		tvpass=(TextView)findViewById(R.id.tvpass);
		tvdelete=(TextView)findViewById(R.id.tvdelete);
		
		etmail=(EditText)findViewById(R.id.etmail);
		etpass=(EditText)findViewById(R.id.etpass);
		
		breturn.setOnClickListener(this);
	//	bdelete.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==breturn){
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
		}
		if(v==bdelete){
			etpass.setText("");
			etmail.setText("");
		}
	}
}
