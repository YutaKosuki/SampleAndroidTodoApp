package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kosuk_000 on 2015/12/20.
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    private static final String TODO_DB_CREATE =
            "CREATE TABLE " + Todo.TODO_TABLE_NAME + " (" +
                    Todo.COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Todo.COLUMN_NAME_TITLE + " TEXT NOT NULL, " +
                    Todo.COLUMN_NAME_CONTENT + " TEXT NOT NULL, " +
                    Todo.COLUMN_NAME_STATUS + " TEXT NOT NULL);";
    private static final String TODO_TABLE_DELETE =
            "DROP TABLE IF EXISTS " + Todo.TODO_TABLE_NAME;

    public MyOpenHelper(Context context) {
        super(context, "TodoDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TODO_DB_CREATE);
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
