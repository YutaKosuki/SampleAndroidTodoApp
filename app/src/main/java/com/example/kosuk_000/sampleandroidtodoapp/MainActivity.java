package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText todoText = (EditText) findViewById(R.id.entry_todo);

        Button entryButton = (Button) findViewById(R.id.btn_entry);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todo = todoText.getText().toString();

                ContentValues insertValues = new ContentValues();
                insertValues.put("todo", todo);
                long id = db.insert("todo", todo, insertValues);
            }
        });
    }
}
