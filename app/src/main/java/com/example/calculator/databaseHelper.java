package com.example.calculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {
    public static final String HISTORY_TABLE = "HISTORY_TABLE";
    public static final String COLUMN_CALCULATION = "CALCULATION";
    public static final String COLUMN_RESULT = "RESULT";

    public databaseHelper(@Nullable Context context) {
        super(context, "history.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE " + HISTORY_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CALCULATION + " TEXT, " + COLUMN_RESULT + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ HISTORY_TABLE);
        onCreate(db);
    }

    public boolean insert(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CALCULATION, s);
        db.insert(HISTORY_TABLE, null, contentValues);
        return true;
    }

}