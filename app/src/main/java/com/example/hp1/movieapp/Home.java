package com.example.hp1.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class Home extends Activity implements OnClickListener {
TextView tvmovies;
ImageView imc;
VideoView vc;
Button b1,b2,b3,b4,b5,b6,blog;
ImageView[] mp=new ImageView[1];
ImageView[] mp2=new ImageView[1];
VideoView[]mv=new VideoView[1];
int[] im={R.id.imcentral};
int[] im2={R.id.imwhyhim};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		
		tvmovies=(TextView)findViewById(R.id.tvmovies);
		
		for(int i=0;i<mp.length;i++){
			mp[i]=(ImageView)findViewById(im[i]);
			
		}
		
		vc=(VideoView)findViewById(R.id.vcentral);
		
		b1=(Button)findViewById(R.id.b1);
		b2=(Button)findViewById(R.id.b2);
		b3=(Button)findViewById(R.id.b3);
		b4=(Button)findViewById(R.id.b4);
		b5=(Button)findViewById(R.id.b5);
		b6=(Button)findViewById(R.id.b6);
		blog=(Button)findViewById(R.id.blog);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
		blog.setOnClickListener(this);
		
		
		  
	
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==blog){
			Intent i=new Intent(this,MainActivity.class);
			startActivity(i);
		}
		
		
	}
}
