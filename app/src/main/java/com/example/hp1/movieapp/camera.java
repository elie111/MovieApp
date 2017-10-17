package com.example.hp1.movieapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class camera extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageView;
    private Button bcamera,bgalery;
    private Bitmap bitmap;
    static final int SELECT_IMAGE=1;
    static final int TAKE_IMAGE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        imageView=(ImageView)findViewById(R.id.im);
        bcamera=(Button)findViewById(R.id.bcamera);
        bgalery=(Button)findViewById(R.id.bgalery);

        bcamera.setOnClickListener(this);
        bgalery.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==bcamera){
            Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,TAKE_IMAGE);
        }
        else{
            Intent i=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,SELECT_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==TAKE_IMAGE&& resultCode==RESULT_OK){
            Bundle Extra =data.getExtras();
            bitmap=(Bitmap) Extra.get("data");
            imageView.setImageBitmap(bitmap);
        }
        else if(requestCode==SELECT_IMAGE && resultCode==RESULT_OK){
            Uri targetUri=data.getData();
            Toast.makeText(getApplicationContext(),targetUri.toString(), Toast.LENGTH_LONG);
            Bitmap bitmap;
            try{
                bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

			Cursor cursor = getContentResolver().query(data.getData(), filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

			String filePath = cursor.getString(columnIndex);
			cursor.close();

			Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
			Toast.makeText(getApplicationContext(), filePath, Toast.LENGTH_SHORT).show();
			imageView.setImageBitmap(yourSelectedImage);


        }
    }
}
