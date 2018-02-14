package com.example.hp1.movieapp;

/**
 * Created by Hp1 on 14/02/2018.
 */


import android.content.Context;
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

        Movie movie = getItem(position);
        TextView title = (TextView) cuView.findViewById(R.id.tvTitle);
        ImageView image = (ImageView) cuView.findViewById(R.id.imgMovie);

        Button btnAddToFavourite = (Button) cuView.findViewById(R.id.btnAddTotFavourite);
        Button btnWathTrailer = (Button) cuView.findViewById(R.id.btnWathTrailer);

        title.setText(movie.getTitle());
        image.setImageResource(movie.getImageId());

        btnAddToFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Item Poisition: Add to Favourite "+position,Toast.LENGTH_LONG).show();
            }
        });
        btnAddToFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Item Poisition: Watch Trailer"+position,Toast.LENGTH_LONG).show();
            }
        });
        return cuView;
    }
}
