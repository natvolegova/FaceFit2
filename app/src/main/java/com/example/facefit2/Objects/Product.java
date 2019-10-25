package com.example.facefit2.Objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey
    private int _id;

    @ColumnInfo(name = "NAME")
    private String name;

    @ColumnInfo(name = "TEXT_DESC")
    private String text_desc;

    @ColumnInfo(name = "IMAGE")
    private String image;

    public Product(String name, String text_desc, String image) {
        this.name = name;
        this.text_desc = text_desc;
        this.image = image;
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

    public String getText_desc() {
        return text_desc;
    }

    public void setText_desc(String text_desc) {
        this.text_desc = text_desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
