package com.example.hp1.movieapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
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

public class Home extends AppCompatActivity implements OnClickListener {
	Button b1,b2,b3,b4,b5,b6,blog;
	TextView tvmovies,tvci;

	int[] photo1={R.drawable.ci,R.drawable.deadpool,R.drawable.ssm,R.drawable.thehang};
	int[] photo2={R.drawable.whyhim,R.drawable.vacation,R.drawable.fist,R.drawable.lastvegas};

	ListView lvMovies;
	CustomAdapter Adapter;
	ArrayList<Movie> movies = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);


		movies.add(new Movie("2016","central intelligence","comedy",R.drawable.ci, "http://www.anakbnet.com/video/file.php?f=1890"));
		movies.add(new Movie("2016","why him?","comedy",R.drawable.whyhim, "http://cima4up.tv/%D9%85%D8%B4%D8%A7%D9%87%D8%AF%D8%A9-%D9%81%D9%8A%D9%84%D9%85-why-him-2016-%D9%850%D8%AA%D8%B1%D8%AC%D9%85-10/"));
		movies.add(new Movie("2016","deadpool","comedy",R.drawable.deadpool, "http://www.anakbnet.com/video/file.php?f=1808"));
		movies.add(new Movie("2015","vacation","comedy",R.drawable.vacation, "http://www.anakbnet.com/video/file.php?f=1681"));
		movies.add(new Movie("2016","suicide squad","action",R.drawable.ssm, "http://www.anakbnet.com/video/file.php?f=1934"));
		movies.add(new Movie("2017","fist fight","comedy",R.drawable.fist, "http://www.anakbnet.com/video/file.php?f=2021"));
		movies.add(new Movie("2009","the hangover","comedy",R.drawable.thehang, "http://www.anakbnet.com/video/file.php?f=1082"));
		movies.add(new Movie("2013","last vegas","comedy",R.drawable.lastvegas, "http://www.anakbnet.com/video/file.php?f=1189"));

// create a new movie

		blog=(Button)findViewById(R.id.blog);


		tvmovies=(TextView)findViewById(R.id.tvmovies);
		Adapter=new CustomAdapter(getApplicationContext(),R.layout.custom_row_movie,movies);
		lvMovies=(ListView)findViewById(R.id.lvMovies);
		lvMovies.setAdapter(Adapter);
		blog.setOnClickListener(this);

	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if(v==blog){
			showNotification();
			Intent intent=new Intent(this,MainActivity.class);
			startActivity(intent);
// log out
		}

	}
	public void showNotification() {
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
		Resources r = getResources();
		Notification notification = new NotificationCompat.Builder(this)
				.setTicker(r.getString(R.string.notification_title))
				.setSmallIcon(android.R.drawable.ic_menu_report_image)
				.setContentTitle(r.getString(R.string.notification_title))
				.setContentText(r.getString(R.string.notification_text))
				.setContentIntent(pi)
				.setAutoCancel(true)
				.build();

		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(0, notification);
	}
}


