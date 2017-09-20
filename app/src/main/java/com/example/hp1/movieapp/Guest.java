package com.example.hp1.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Guest extends Activity implements OnClickListener{
	Button b1,b2,b3,b4,b5,b6,bsign,blog;
	TextView tvmovies,tvsign,tvci;
	ImageButton[] imv=new ImageButton[4];
	ImageButton[] imv2=new ImageButton[4];
	int[] im={R.id.imcentral,R.id.imdeadpool,R.id.imsuicide,R.id.imthehang};
	int[] im2={R.id.imwhyhim,R.id.imvacation,R.id.imfist,R.id.imlastvegas};


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

		for(int i=0;i<im.length;i++){
			imv[i]=(ImageButton) findViewById(im[i]);
			imv[i].setOnClickListener(this);
		}
		for(int i=0;i<im2.length;i++){
			imv2[i]=(ImageButton) findViewById(im2[i]);
			imv2[i].setOnClickListener(this);
		}




		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		bsign.setOnClickListener(this);
		blog.setOnClickListener(this);



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
			for(int i=0;i<imv.length;i++){
				if(i==0){
					imv[i].setVisibility(View.VISIBLE);
					imv2[i].setVisibility(View.VISIBLE);

				}
				else{
					imv[i].setVisibility(View.INVISIBLE);
					imv2[i].setVisibility(View.INVISIBLE);

				}

			}
		}
		if(v==b2){
			for(int i=0;i<imv.length;i++){
				if(i==1){
					imv[i].setVisibility(View.VISIBLE);
					imv2[i].setVisibility(View.VISIBLE);
					;
				}
				else{
					imv[i].setVisibility(View.INVISIBLE);
					imv2[i].setVisibility(View.INVISIBLE);

				}

			}
		}
		if(v==b3){		

			for(int i=0;i<imv.length;i++){
				if(i==2){
					imv[i].setVisibility(View.VISIBLE);
					imv2[i].setVisibility(View.VISIBLE);

				}
				else{
					imv[i].setVisibility(View.INVISIBLE);
					imv2[i].setVisibility(View.INVISIBLE);

				}}

		}if(v==b4){
			for(int i=0;i<imv.length;i++){
				if(i==3){
					imv[i].setVisibility(View.VISIBLE);
					imv2[i].setVisibility(View.VISIBLE);

				}
				else{
					imv[i].setVisibility(View.INVISIBLE);
					imv2[i].setVisibility(View.INVISIBLE);

				}}

		}/*if(v==b5){
							for(int i=0;i<imv.length;i++){
								if(i==4){
									imv[i].setVisibility(View.VISIBLE);
									imv2[i].setVisibility(View.VISIBLE);
									info[i].setVisibility(View.VISIBLE);
									info2[i].setVisibility(View.VISIBLE);
								}
								else{
									imv[i].setVisibility(View.INVISIBLE);
									imv2[i].setVisibility(View.INVISIBLE);
									info[i].setVisibility(View.INVISIBLE);
									info2[i].setVisibility(View.INVISIBLE);
								}

							}if(v==b6){
								for(int i=0;i<imv.length;i++){
									if(i==5){
										imv[i].setVisibility(View.VISIBLE);
										imv2[i].setVisibility(View.VISIBLE);
										info[i].setVisibility(View.VISIBLE);
										info2[i].setVisibility(View.VISIBLE);
									}
									else{
										imv[i].setVisibility(View.INVISIBLE);
										imv2[i].setVisibility(View.INVISIBLE);
										info[i].setVisibility(View.INVISIBLE);
										info2[i].setVisibility(View.INVISIBLE);
								}	
		 */

	}}






