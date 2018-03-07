package com.example.hp1.movieapp;

/**
 * Created by Hp1 on 14/02/2018.
 */


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Hp1 on 27/09/2017.
 */

public class CustomAdapter extends ArrayAdapter<Movie> {

    private int resource;

    public CustomAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater imageInflater = LayoutInflater.from(getContext());
        View cuView = imageInflater.inflate(resource, parent, false );

        final Movie movie = getItem(position);
        TextView title = (TextView) cuView.findViewById(R.id.tvTitle);
        ImageView image = (ImageView) cuView.findViewById(R.id.imgMovie);


        Button btnWathTrailer = (Button) cuView.findViewById(R.id.btnWathTrailer);

        title.setText(movie.getTitle());
        image.setImageResource(movie.getImageId());


        btnWathTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                watchYoutubeVideo(movie.getYoutube());
            }
        });
        return cuView;
    }
    public void watchYoutubeVideo(String id) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            getContext().startActivity(browserIntent);
        } catch (ActivityNotFoundException ex) {
            Log.d("Cannot Play Video",ex.toString());
        }
    }

}
