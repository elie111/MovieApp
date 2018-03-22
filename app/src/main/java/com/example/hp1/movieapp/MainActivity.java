package com.example.hp1.movieapp;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener,OnItemClickListener{
	Button blog,bsign,bguest;
	TextView tvmovies;
	ListView lv;
	ArrayAdapter<String>Adapter;
	ImageView m;
	int[] mid={R.drawable.ci,R.drawable.deadpool,R.drawable.ssm,R.drawable.thehang,R.drawable.whyhim,R.drawable.vacation,R.drawable.fist,R.drawable.lastvegas};

	ArrayList<String>al=new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		m = (ImageView) findViewById(R.id.image);
		blog=(Button)findViewById(R.id.blog);
		bsign=(Button)findViewById(R.id.bsign);
		bguest=(Button)findViewById(R.id.bguest);



		tvmovies=(TextView)findViewById(R.id.tvmovies);

		blog.setOnClickListener(this);
		bsign.setOnClickListener(this);
		bguest.setOnClickListener(this);

		al.add("central intelligence");
		al.add("deadpool");
		al.add("suicide squad");
		al.add("the hangover");
		al.add("why him?");
		al.add("vecation");
		al.add("fist fight");
		al.add("last vegas");
		//add movies to the list







		Adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,al);
		lv=(ListView)findViewById(R.id.lv);
		lv.setAdapter(Adapter);
		lv.setOnItemClickListener(this);

	}




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i;
		if(v==blog){
			i=new Intent(MainActivity.this,Login.class);
			startActivity(i);
			//go to log
		}

		if(v==bsign){
			i=new Intent(MainActivity.this, SignUp.class);
			startActivity(i);
			//go to sign
		}
		if(v==bguest){
			i=new Intent(MainActivity.this, Guest.class);
			startActivity(i);
//go to guest
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		m.setImageResource(mid[position]);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.loginm, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent i;
		switch (item.getItemId()) {
			case R.id.camera:
				i = new Intent(getApplicationContext(), camera.class);
				startActivity(i);
				//go to camera
				break;
			case R.id.aboutMenu:
				i = new Intent(MainActivity.this, About.class);
				startActivity(i);
				// go to about
				break;
		}
		return super.onOptionsItemSelected(item);

	}






}
