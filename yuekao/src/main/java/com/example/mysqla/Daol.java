package com.example.mysqla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mysql.MySql;

public class Daol {

    private final SQLiteDatabase db;

    public  Daol(Context context) {
        MySql mySql = new MySql(context);
        db = mySql.getWritableDatabase();
    }
    public long insert(String table, String nullColumnHack, ContentValues values) {
        return db.insert(table, nullColumnHack, values);
    }

    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {
        return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
}
