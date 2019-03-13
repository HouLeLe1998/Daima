package com.example.Sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Dao {


    private final SQLiteDatabase db;
    private Context context;

    public Dao(Context context) {
        this.context = context;
        Sql sql = new Sql(context);
        db= sql.getWritableDatabase();
    }

    public long insert(String table, String nullColumnHack, ContentValues values) {
        return  db.insert(table, nullColumnHack, values);
    }
    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {
        return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
}
