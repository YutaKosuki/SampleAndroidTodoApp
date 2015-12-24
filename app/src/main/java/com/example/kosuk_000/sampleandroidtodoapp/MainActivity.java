package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Cursor mCursor;
    SimpleCursorAdapter mSimpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOpenHelper helper = new MyOpenHelper(this);
        ListView listView = (ListView) findViewById(R.id.listView);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText todoText = (EditText) findViewById(R.id.entry_todo);

        // データを取得
        mCursor = db.query(Todo.TODO_TABLE_NAME, new String[] {Todo.COLUMN_NAME_ID, Todo.COLUMN_NAME_TODO_CONTENT}, null, null, null, null, null);

        // UIにバインドするデータのカラム
        String[] from = {
                Todo.COLUMN_NAME_ID, Todo.COLUMN_NAME_TODO_CONTENT
        };
        // 指定したカラムのデータを表示するViewのID
        int[] to = {
                R.id.todo_id, R.id.todo_content
        };

        mSimpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.listitembook, mCursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(mSimpleCursorAdapter);


        Button entryButton = (Button) findViewById(R.id.btn_entry);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String todo = todoText.getText().toString();

                ContentValues insertValues = new ContentValues();
                insertValues.put(Todo.COLUMN_NAME_TODO_CONTENT, todo);
                long id = db.insert(Todo.TODO_TABLE_NAME, todo, insertValues);

                // データを再読み込みする
                mSimpleCursorAdapter.getCursor().requery();

            }
        });


        Button allDeleteButton = (Button) findViewById(R.id.btn_all_delete);
        allDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete(Todo.TODO_TABLE_NAME, null, null);

                // データを再読み込みする
                mSimpleCursorAdapter.getCursor().requery();
            }
        });

    }
}
