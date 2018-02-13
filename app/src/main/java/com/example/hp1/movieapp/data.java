package com.example.hp1.movieapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Hp1 on 13/02/2018.
 */

public class data extends SQLiteOpenHelper{
    private static data sInstance;
   public static int DATABASE_VERSION =1;
    public static final String DATABASE_NAME="MOVIES";
    public static final String TABLE_ALC="MOVIES";
    public static final String MOVIE_TITLE="TITLE";
    public static final String MOVIE_YEAR="YEAR";
    public static final String MOVIE_GENRE="GENRE";

    public data(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static synchronized data getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new data(context.getApplicationContext());
        }
        return sInstance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table"+ TABLE_ALC
                +"("+MOVIE_TITLE+"TEXT,"
                +MOVIE_YEAR+"INTEGER"
                +MOVIE_GENRE+"TEXT"
                +")";
        Log.d("query",query);
        try {
            db.execSQL("DROP TABLE OF EXISTS" + TABLE_ALC);
            db.execSQL(query);
        }
            catch(Exception e){
                e.printStackTrace();
            }
        }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
