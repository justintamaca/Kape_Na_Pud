package com.example.logsignsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table allusers(email TEXT primary key, fullname TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("drop Table if exists allusers");
        onCreate(MyDatabase);
    }

    public Boolean insertData(String email, String fullname, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();


        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allusers WHERE email=?", new String[]{email});
        if (cursor.getCount() > 0) {

            cursor.close();
            return false;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("email", email);
            contentValues.put("fullname", fullname);
            contentValues.put("password", password);
            try {
                long result = MyDatabase.insertOrThrow("allusers", null, contentValues);
                return result != -1;
            } catch (SQLiteConstraintException e) {

                e.printStackTrace();
                return false;
            } finally {
                cursor.close();
            }
        }
    }

    public Boolean checkEmail(String email) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allusers WHERE email = ?", new String[]{email});
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }

    public Boolean checkEmailPassword(String email, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allusers WHERE email = ? AND password = ?", new String[]{email, password});
        boolean result = cursor.getCount() > 0;
        cursor.close();
        return result;
    }
    public String getFullName(String email, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        String fullName = null;

        String[] columns = { "fullname" }; // Define the column to retrieve

        String selection = "email = ? AND password = ?";
        String[] selectionArgs = { email, password };

        Cursor cursor = MyDatabase.query("allusers", columns, selection, selectionArgs, null, null, null);

        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("fullname");
            if (columnIndex != -1) {
                fullName = cursor.getString(columnIndex);
            }
        }

        cursor.close();
        MyDatabase.close();

        return fullName;
    }


}
