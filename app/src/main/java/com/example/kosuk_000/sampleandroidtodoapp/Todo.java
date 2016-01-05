package com.example.kosuk_000.sampleandroidtodoapp;


/**
 * Created by kosuki on 2015/12/22.
 */
public class Todo {
    public static final String TODO_TABLE_NAME = "todo";

    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_CONTENT = "content";
    public static final String COLUMN_NAME_DEADLINE = "deadline";

    private String mContent;

    public Todo(String content) {
        super();
        mContent = content;
    }

    public String getContent() {return mContent; };
    public void setContent(String content) { mContent = content; };


}
