package com.example.facefit2.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Element {
    @PrimaryKey
    private int _id;
    @ColumnInfo(name = "NAME")
    private String name;
    @ColumnInfo(name = "TIME")
    private int time;
    @ColumnInfo(name = "IMAGE")
    private String image;
    @ColumnInfo(name = "VIDEO")
    private String video;

    public Element(String name, int time, String image, String video) {
        this.name = name;
        this.time = time;
        this.image = image;
        this.video = video;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public String getTimeFormatting() {
        DateFormat timeFormat = new SimpleDateFormat("mm:ss");
        String timeFormatting = timeFormat.format(new Date(time*1000));
        return timeFormatting;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
