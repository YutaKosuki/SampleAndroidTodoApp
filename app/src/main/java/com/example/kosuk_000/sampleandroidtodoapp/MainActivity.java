package com.example.kosuk_000.sampleandroidtodoapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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

                LinearLayout layout = (LinearLayout) findViewById(R.id.doto_list);
                TextView textView = new TextView(MainActivity.this);
                textView.setText(String.format("id:%s, todo:%s", id, todo));
                layout.addView(textView);
            }
        });

        Button allDeleteButton = (Button) findViewById(R.id.btn_all_delete);
        allDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete("todo", null, null);
                LinearLayout layout = (LinearLayout) findViewById(R.id.doto_list);
                layout.removeAllViews();
            }
        });

        LinearLayout layout = (LinearLayout) findViewById(R.id.doto_list);

        Cursor c = db.query("todo", new String[] {"id", "todo"}, null, null, null, null, null);
        boolean mov = c.moveToFirst();

        while (mov) {
            TextView textView = new TextView(this);
            textView.setText(String.format("id:%s, todo:%s", c.getString(0), c.getString(1)));
            mov = c.moveToNext();
            layout.addView(textView);
        }
    }
}
