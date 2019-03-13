package com.example.mysql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper {

    public MySql(Context context) {
        super(context, "DB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person(author_name text,thumbnail_pic_s02 text,thumbnail_pic_s text,title text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
