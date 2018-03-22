package com.example.hp1.movieapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Guest extends AppCompatActivity implements AdapterView.OnItemClickListener, OnClickListener {
	Button b1,b2,b3,b4,b5,b6,bsign,blog;
	TextView tvmovies,tvsign,tvci;

	int[] photo1={R.drawable.ci,R.drawable.deadpool,R.drawable.ssm,R.drawable.thehang};
	int[] photo2={R.drawable.whyhim,R.drawable.vacation,R.drawable.fist,R.drawable.lastvegas};

	int youtube1,youtube2;
	ListView lvMovies;
    CustomAdapter Adapter;
	ArrayList<Movie> movies = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest);


		movies.add(new Movie("2016","central intelligence","comedy",R.drawable.ci, "http://www.youtube.com/watch?v=MxEw3elSJ8M"));
		movies.add(new Movie("2016","why him?","comedy",R.drawable.whyhim, "http://www.youtube.com/watch?v=CO6qLC4cL8E"));
		movies.add(new Movie("2016","deadpool","comedy",R.drawable.deadpool, "http://www.youtube.com/watch?v=9vN6DHB6bJc"));
		movies.add(new Movie("2015","vacation","comedy",R.drawable.vacation, "http://www.youtube.com/watch?v=kleG7XCqOb4"));
		movies.add(new Movie("2016","suicide squad","action",R.drawable.ssm, "http://www.youtube.com/watch?v=5AwUdTIbA8I"));
		movies.add(new Movie("2017","fist fight","comedy",R.drawable.fist, "http://www.youtube.com/watch?v=6YVBj2o_3mg"));
		movies.add(new Movie("2009","the hangover","comedy",R.drawable.thehang, "http://www.youtube.com/watch?v=KLAkxSjs8Z"));
		movies.add(new Movie("2013","last vegas","comedy",R.drawable.lastvegas, "http://www.youtube.com/watch?v=TvK3m0wJutI"));

// create new movies
		bsign=(Button)findViewById(R.id.bsignin);
		blog=(Button)findViewById(R.id.blog);


		tvmovies=(TextView)findViewById(R.id.tvmovies);
		tvsign=(TextView)findViewById(R.id.tvsign);



		Adapter=new CustomAdapter(getApplicationContext(),R.layout.custom_row_movie,movies);
		lvMovies=(ListView)findViewById(R.id.lvMovies);
		lvMovies.setAdapter(Adapter);
		lvMovies.setOnItemClickListener(this);



		bsign.setOnClickListener(this);
		blog.setOnClickListener(this);

	}






	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==bsign){
			Intent intent=new Intent(this,SignUp.class);
			startActivity(intent);
			// go to sign
		}
		if(v==blog){
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
// go to log
		}

	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

	}
}






