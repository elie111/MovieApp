package com.example.hp1.movieapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera extends AppCompatActivity implements View.OnClickListener{
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
    public File saveImage(Bitmap bitmap){
        File root = Environment.getExternalStorageDirectory();// internal storage launching .
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        SharedPreferences pref =getSharedPreferences("mypref",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();



        String filePath = root.getAbsolutePath()+"/DCIM/Camera/IMG_"+timeStamp+".jpg";
        File file = new File(filePath);// determinig the type of the file and its place.
        editor.putString("filepath",filePath);
        editor.commit();
        try
        {
            // if gallary nit full create a file and save images
            file.createNewFile();// create new file to save image.
            FileOutputStream ostream = new FileOutputStream(file);//saves root in this file
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, ostream);// compass bitmap in file
            ostream.close();// close
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Faild to save image", Toast.LENGTH_SHORT).show();
        }
        return file;
    }
}
