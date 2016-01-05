package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TodoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        MyOpenHelper helper = new MyOpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();


        final Intent intent = getIntent();

        TextView textViewId = (TextView) findViewById(R.id.todo_detail_title_data);
        textViewId.setText(intent.getStringExtra(Todo.COLUMN_NAME_TITLE));

        TextView textViewContent = (TextView) findViewById(R.id.todo_detail_content_data);
        textViewContent.setText(intent.getStringExtra(Todo.COLUMN_NAME_CONTENT));

        Button btn_to_main = (Button) findViewById(R.id.btn_to_main);
        btn_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TodoDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn_todo_complete = (Button) findViewById(R.id.btn_todo_complete);
        btn_todo_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(Todo.COLUMN_NAME_STATUS, Todo.STATUS_COMPLETE.toString());
                db.update(Todo.TODO_TABLE_NAME, values, Todo.COLUMN_NAME_ID + " = ?", new String[]{intent.getStringExtra(Todo.COLUMN_NAME_ID)});

                Intent intent = new Intent(TodoDetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
