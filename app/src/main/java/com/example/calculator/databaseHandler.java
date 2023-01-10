package com.example.calculator;

import static com.example.calculator.databaseHelper.HISTORY_TABLE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class databaseHandler extends databaseHelper{
    public databaseHandler(@Nullable Context context) {
        super(context);
    }

    public ArrayList<historyView> readCourses() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + HISTORY_TABLE, null);

        ArrayList<historyView> courseModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            do {
                courseModalArrayList.add(new historyView(cursorCourses.getString(1),
                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return courseModalArrayList;
    }

}
