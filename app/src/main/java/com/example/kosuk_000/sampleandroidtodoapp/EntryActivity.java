package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText todo_title   = (EditText)findViewById(R.id.entry_todo_title);
        final EditText todo_content = (EditText)findViewById(R.id.entry_todo_content);

        Button btn_entry = (Button) findViewById(R.id.btn_entry);
        btn_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues insertValues = new ContentValues();
                insertValues.put(Todo.COLUMN_NAME_TITLE, todo_title.getText().toString());
                insertValues.put(Todo.COLUMN_NAME_CONTENT, todo_content.getText().toString());
                long id = db.insert(Todo.TODO_TABLE_NAME, null, insertValues);

                Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn_to_main = (Button) findViewById(R.id.btn_to_main);
        btn_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
