package com.instinctcoder.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper  extends SQLiteOpenHelper {
    //version number to upgrade database version
    private static final int DATABASE_VERSION = 7;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_STUDENT = "CREATE TABLE IF NOT EXISTS " + Student.TABLE  + "("
                + Student.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Student.KEY_name + " TEXT, "
                + Student.KEY_age + " INTEGER, "
                + Student.KEY_email + " TEXT, "
                + Student.KEY_NewColumn + " TEXT)";

        db.execSQL(CREATE_TABLE_STUDENT);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If you need to add a column
//        if (newVersion > oldVersion) {
//            db.execSQL("ALTER TABLE "+ Student.TABLE +" ADD COLUMN "+ Student.KEY_NewColumn+" TEXT DEFAULT ''");
//        }else {
            // Drop older table if existed, all data will be gone
            db.execSQL("DROP TABLE IF EXISTS " + Student.TABLE);
//        }

        // Create tables again
        onCreate(db);

    }

}
