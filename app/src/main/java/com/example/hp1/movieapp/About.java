package com.example.hp1.movieapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class About extends AppCompatActivity implements OnClickListener{
	TextView tv;
	Button breturn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		breturn=(Button)findViewById(R.id.breturn);

		tv=(TextView)findViewById(R.id.tv);



		breturn.setOnClickListener(this);




	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==breturn){
			Intent i=new Intent(this,MainActivity.class);
			startActivity(i);
		}
	}

   /*public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		if(position==1)
			Toast.makeText(getApplicationContext(), "toast", Toast.LENGTH_SHORT).show();

		else{
			if(position==2){
				Intent intent=new Intent(About.this,MainActivity.class);
				startActivity(intent);
			}

		}
	}

	@Override
	*/
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}


}
