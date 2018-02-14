package com.example.hp1.movieapp;

/**
 * Created by Hp1 on 14/02/2018.
 */

public class Movie {
    private long id;
    private String year;
    private String title;
    private String gener;
    private int imageId;
    private String youtube;

    public Movie(long id, String year, String title, String gener, int imageId, String youtube) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.gener = gener;
        this.imageId = imageId;
        this.youtube = youtube;
    }
    public Movie(String year, String title, String gener, int imageId, String youtube) {
        this.id = 0;
        this.year = year;
        this.title = title;
        this.gener = gener;
        this.imageId = imageId;
        this.youtube = youtube;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
