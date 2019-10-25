package com.example.facefit2.Objects;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.facefit2.Data.DateConverter;

import java.util.Date;

@Entity
public class Stat {
    @PrimaryKey (autoGenerate = true)
    private int _id;
    @TypeConverters({DateConverter.class})
    private Date date;
    private int program_id;

    public Stat(Date date, int program_id) {
        this.date = date;
        this.program_id = program_id;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getProgram_id() {
        return program_id;
    }

    public void setProgram_id(int program_id) {
        this.program_id = program_id;
    }
}
