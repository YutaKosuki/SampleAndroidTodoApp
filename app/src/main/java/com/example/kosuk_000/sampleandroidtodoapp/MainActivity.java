package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        final SQLiteDatabase db = helper.getWritableDatabase();

        final ListView listView = (ListView) findViewById(R.id.listView);

        // データを取得
        String [] columns = {Todo.COLUMN_NAME_TITLE};
        mCursor = db.rawQuery("select * from " + Todo.TODO_TABLE_NAME, null);

        // UIにバインドするデータのカラム
        String[] from = {
                Todo.COLUMN_NAME_TITLE
        };
        // 指定したカラムのデータを表示するViewのID
        int[] to = {
                R.id.todo_title
        };

        mSimpleCursorAdapter = new SimpleCursorAdapter(this, R.layout.listitembook, mCursor, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listView.setAdapter(mSimpleCursorAdapter);


        Button entryButton = (Button) findViewById(R.id.btn_entry);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, EntryActivity.class);
                startActivity(intent);
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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, TodoDetailActivity.class);

                intent.putExtra(Todo.COLUMN_NAME_TITLE, cursor.getString(cursor.getColumnIndex(Todo.COLUMN_NAME_TITLE)));
                intent.putExtra(Todo.COLUMN_NAME_CONTENT, cursor.getString(cursor.getColumnIndex(Todo.COLUMN_NAME_CONTENT)));
                startActivity(intent);
            }
        });

    }
}
