package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.Intent;
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

        Intent intent = getIntent();

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
    }
}
