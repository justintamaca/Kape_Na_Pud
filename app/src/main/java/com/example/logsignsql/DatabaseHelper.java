package com.example.logsignsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String databaseName = "signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, databaseName, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS allusers (email TEXT PRIMARY KEY, firstname TEXT, lastname TEXT, contact_number TEXT, gender TEXT, birthday TEXT, password TEXT)";
        Log.d("DatabaseHelper", "onCreate SQL: " + createTableSQL);
        MyDatabase.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("DROP TABLE IF EXISTS allusers");
        onCreate(MyDatabase);
    }

    public boolean insertData(String email, String firstname, String lastname, String contactNumber, String gender, String birthday, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();

        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM allusers WHERE email=?", new String[]{email});
        try {
            if (cursor.getCount() > 0) {
                return false; // User with this email already exists
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("email", email);
                contentValues.put("firstname", firstname);
                contentValues.put("lastname", lastname);
                contentValues.put("contact_number", contactNumber);
                contentValues.put("gender", gender);
                contentValues.put("birthday", birthday);
                contentValues.put("password", password);
                long result = MyDatabase.insertOrThrow("allusers", null, contentValues);
                return result != -1;
            }
        } catch (SQLiteConstraintException e) {
            e.printStackTrace();
            return false;
        } finally {
            cursor.close();
        }
    }


    public String getUserInfo(String email, String password) {
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        String userInfo = null;

        String[] columns = {"firstname", "lastname", "contact_number", "gender", "birthday"};

        String selection = "email = ? AND password = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = MyDatabase.query("allusers", columns, selection, selectionArgs, null, null, null);

        try {
            if (cursor.moveToFirst()) {
                int firstNameIndex = cursor.getColumnIndex("firstname");
                int lastNameIndex = cursor.getColumnIndex("lastname");
                int contactNumberIndex = cursor.getColumnIndex("contact_number");
                int genderIndex = cursor.getColumnIndex("gender");
                int birthdayIndex = cursor.getColumnIndex("birthday");

                if (firstNameIndex != -1 && lastNameIndex != -1 && contactNumberIndex != -1 && genderIndex != -1 && birthdayIndex != -1) {
                    String firstName = cursor.getString(firstNameIndex);
                    String lastName = cursor.getString(lastNameIndex);
                    String contactNumber = cursor.getString(contactNumberIndex);
                    String gender = cursor.getString(genderIndex);
                    String birthday = cursor.getString(birthdayIndex);

                    // Format the retrieved information as needed
                    userInfo = "First Name: " + firstName + "\nLast Name: " + lastName + "\nContact Number: " + contactNumber + "\nGender: " + gender + "\nBirthday: " + birthday;
                }
            }
        } finally {
            cursor.close();
            MyDatabase.close();
        }

        return userInfo;
    }
}
