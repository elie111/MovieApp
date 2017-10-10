package com.example.hp1.movieapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Guest extends AppCompatActivity implements OnClickListener{
	Button b1,b2,b3,b4,b5,b6,bsign,blog;
	TextView tvmovies,tvsign,tvci;
	/*ImageButton[] imv=new ImageButton[4];
	ImageButton[] imv2=new ImageButton[4];*/

	ImageButton imv1,imv2;
	int[] im={R.id.imcentral,R.id.imdeadpool,R.id.imssm,R.id.imthehang};
	int[] im2={R.id.imwhyhim,R.id.imvacation,R.id.imfist,R.id.imlastvegas};

	int[] photo1={R.drawable.ci,R.drawable.deadpool,R.drawable.ssm,R.drawable.thehang};
	int[] photo2={R.drawable.whyhim,R.drawable.vacation,R.drawable.fist,R.drawable.lastvegas};

	int youtube1,youtube2;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest);
		b1=(Button)findViewById(R.id.b1);
		b2=(Button)findViewById(R.id.b2);
		b3=(Button)findViewById(R.id.b3);
		b4=(Button)findViewById(R.id.b4);
		b5=(Button)findViewById(R.id.b5);
		b6=(Button)findViewById(R.id.b6);
		bsign=(Button)findViewById(R.id.bsignin);
		blog=(Button)findViewById(R.id.blog);


		tvmovies=(TextView)findViewById(R.id.tvmovies);
		tvsign=(TextView)findViewById(R.id.tvsign);



		imv1=(ImageButton)findViewById(R.id.imcentral);
		imv2=(ImageButton) findViewById(R.id.imwhyhim);


		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		bsign.setOnClickListener(this);
		blog.setOnClickListener(this);

		imv1.setOnClickListener(this);
		imv2.setOnClickListener(this);

		imv1.setImageResource(photo1[0]);
		imv2.setImageResource(photo2[0]);

	}

	/**
	 *
	 * @param id
     */
	public void watchYoutubeVideo(String id) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.youtube.com/watch?v=" + id));
		try {
			startActivity(browserIntent);
		} catch (ActivityNotFoundException ex) {
			Log.d("Cannot Play Video",ex.toString());
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==bsign){
			Intent intent=new Intent(this,Sign.class);
			startActivity(intent);
		}
		if(v==blog){
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);

		}

		if(v==b1){


			imv1.setImageResource(photo1[0]);
			imv2.setImageResource(photo2[0]);
youtube1=1;
			youtube2=1;
		}
		if(v==b2){

			imv1.setImageResource(photo1[1]);
			imv2.setImageResource(photo2[1]);
			youtube1=2;
			youtube2=2;
		}
		if(v==b3){		


			imv1.setImageResource(photo1[2]);
			imv2.setImageResource(photo2[2]);
			youtube1=3;
			youtube2=3;
		}if(v==b4){

			imv1.setImageResource(photo1[3]);
			imv2.setImageResource(photo2[3]);
			youtube1=4;
			youtube2=4;
		}

		if(v==imv1){
			if(youtube1==1)
			watchYoutubeVideo("MxEw3elSJ8M");
			if(youtube1==2)
				watchYoutubeVideo("9vN6DHB6bJc");
			if(youtube1==3)
				watchYoutubeVideo("5AwUdTIbA8I");
			if(youtube1==4)
				watchYoutubeVideo("KLAkxSjs8ZY");
		}
		if(v==imv2){
			if(youtube2==1)
				watchYoutubeVideo("CO6qLC4cL8E");
			if(youtube2==2)
				watchYoutubeVideo("kleG7XCqOb4");
			if(youtube2==3)
				watchYoutubeVideo("6YVBj2o_3mg");
			if(youtube2==4)
				watchYoutubeVideo("TvK3m0wJutI");
		}

	}}






