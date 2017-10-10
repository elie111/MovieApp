package com.example.hp1.movieapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;


public class Login extends AppCompatActivity implements OnClickListener{
	Button breturn,blogin;
	TextView tvwelcome,tvmail,tvpassword;
	EditText etmail,etpassword;
	String[] email = {"elie"};
	String[] password = {"elie"};
	String pass,mail;
	Boolean p=false;
	Boolean e=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login2_layout);

		breturn=(Button)findViewById(R.id.breturn);
		blogin=(Button)findViewById(R.id.blogin);

		tvpassword=(TextView)findViewById(R.id.tvpassword);
		tvmail=(TextView)findViewById(R.id.tvmail);
		tvwelcome=(TextView)findViewById(R.id.tvwelcome);

		etpassword=(EditText)findViewById(R.id.etpassword);
		etmail=(EditText)findViewById(R.id.etmail);

		breturn.setOnClickListener(this);
		blogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==breturn){
			Intent i=new Intent(this, MainActivity.class);
			startActivity(i);
		}
			if(v==blogin){
			pass=etpassword.getText().toString();
			mail=etmail.getText().toString();
			for(int i=0;i<password.length;i++){
				if(password[i].equals(pass))
					p=true;
				if(email[i].equals(mail))
					e=true;
			}
			if(e==true&&p==true){
				Intent i=new Intent(this, Home.class);
				startActivity(i);
			}
			else{
				Toast.makeText(this, "your password or email is wrong", Toast.LENGTH_LONG).show();
			}


			}
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.loginm, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.a:
				// do whatever
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}


}



