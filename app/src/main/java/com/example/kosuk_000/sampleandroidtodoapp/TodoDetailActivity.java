package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TodoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);

        Intent intent = getIntent();

        TextView textViewId = (TextView) findViewById(R.id.todo_detail_title_data);
        textViewId.setText(intent.getStringExtra(Todo.COLUMN_NAME_TITLE));

        TextView textViewContent = (TextView) findViewById(R.id.todo_detail_content_data);
        textViewContent.setText(intent.getStringExtra(Todo.COLUMN_NAME_CONTENT));

    }
}
