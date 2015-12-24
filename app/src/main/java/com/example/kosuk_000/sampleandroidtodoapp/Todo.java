package com.example.kosuk_000.sampleandroidtodoapp;


/**
 * Created by kosuki on 2015/12/22.
 */
public class Todo {
    public static final String TODO_TABLE_NAME = "todo";

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_TODO_CONTENT = "content";

    private String mContent;

    public Todo(String content) {
        super();
        mContent = content;
    }

    public String getContent() {return mContent; };
    public void setContent(String content) { mContent = content; };


}