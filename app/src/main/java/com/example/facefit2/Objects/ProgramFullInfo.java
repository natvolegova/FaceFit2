package com.example.facefit2.Objects;

import android.content.Context;
import android.content.res.Resources;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.facefit2.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ProgramFullInfo {
    private int _id;
    @ColumnInfo(name = "NAME")
    private String name;
    @ColumnInfo(name = "TEXT_DESC")
    private String text_desc;
    @ColumnInfo(name = "IMAGE")
    private String image;

    private int time;
    private int countOfElements;

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getText_desc() {
        return text_desc;
    }

    public String getImage() {
        return image;
    }

    public int getTime() {
        return time;
    }

    public String getTimeFormatting() {
        DateFormat timeFormat = new SimpleDateFormat("mm:ss");
        String timeFormatting = timeFormat.format(new Date(time*1000));
        return timeFormatting;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText_desc(String text_desc) {
        this.text_desc = text_desc;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCountOfElements(int countOfElements) {
        this.countOfElements = countOfElements;
    }

    public String getElementAddition(Context context) {
        Resources res = context.getResources();
        int preLastDigit = countOfElements % 100 / 10;
        if (preLastDigit == 1) {
            return countOfElements + " " + res.getString(R.string.tv_count3);
        }
        switch (countOfElements % 10) {
            case 1:
                return countOfElements + " " + res.getString(R.string.tv_count);
            case 2:
            case 3:
            case 4:
                return countOfElements + " " + res.getString(R.string.tv_count2);
            default:
                return countOfElements + " " + res.getString(R.string.tv_count3);
        }
    }
}
