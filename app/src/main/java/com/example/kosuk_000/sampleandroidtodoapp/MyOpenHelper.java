package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kosuk_000 on 2015/12/20.
 */
public class MyOpenHelper extends SQLiteOpenHelper {
    public MyOpenHelper(Context context) {
        super(conte, "TodoDB", null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table todo(" + "todo text not null," + ");");
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
