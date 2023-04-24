package com.application.myapplication.sqlitehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_COMMAND = "CREATE TABLE "
                + Util.TABLE_NAME + "("
                + Util.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Util.USERNAME +" TEXT,"
                + Util.PASSWORD + " TEXT"
                + ")";

        db.execSQL(CREATE_TABLE_COMMAND);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public long insertStudent(Student student){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.USERNAME, student.getName());
        contentValues.put(Util.PASSWORD, student.getDescription());

        long rowId = db.insert(Util.TABLE_NAME, null, contentValues);

        return rowId;

    }


    public boolean getStudents(String userName, String password){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.USER_ID},
                Util.USERNAME + " =? and " +
                        Util.PASSWORD + " =?",
                new String[]{userName, password}, null, null, null);


        int numOfRows = cursor.getCount();

        if (numOfRows > 0)
            return true;
        else
            return false;




    }
}
