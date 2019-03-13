package com.bwie.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySql extends SQLiteOpenHelper {
    public MySql(Context context) {
        super(context, "db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table person(title text,pics text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
