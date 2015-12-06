package com.example.manny.mynotes.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by manny on 12/6/2015 AD.
 */
public class model extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "notes";
    public static final String COL_ID = "_id";
    public static final String COL_SUBJECT =  "subject";
    public static final String COL_CONTENT= "content";
    public static final String COL_LIKE = "like";
    public model(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTable = String.format("CREATE TABLE %s ("+
                "%s INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "%s TEXT, " +
                "%s TEXT, " +
                "%s TEXT )"
                ,TABLE_NAME, COL_ID,COL_SUBJECT,COL_CONTENT,COL_LIKE);
        db.execSQL(sqlCreateTable);



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
