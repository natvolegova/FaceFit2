package com.example.facefit2;

import android.app.Application;
import androidx.room.Room;

import com.example.facefit2.Data.Constants;
import com.example.facefit2.Data.DatabaseHelper;
import com.example.facefit2.Data.RoomHelperDB;

public class App extends Application {
    private static App instance;
    private DatabaseHelper db;
    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        RoomHelperDB helperDB = new RoomHelperDB();
        helperDB.copyDatabase(getApplicationContext(), Constants.DB_NAME);

        db = Room.databaseBuilder(getApplicationContext(), DatabaseHelper.class, Constants.DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public DatabaseHelper getDatabaseInstance() {
        return db;
    }
}
