package com.example.bnsp_.javaClass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String clm_id = "id";
    public static final String clm_status = "Status";
    public static final String clm_nominal = "Nominal";
    public static final String clm_keterangan = "Keterangan";
    public static final String clm_tanggal = "Tanggal";

    public DBHelper(Context context) {
        super(context, "bnsp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB){
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table cashFlow(id INTEGER PRIMARY KEY AUTOINCREMENT, tanggal TEXT, nominal INTEGER, keterangan TEXT, status TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1){
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists cashFlow");
    }

    public Boolean insertDataUsers(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users",null,contentValues);

        if(result==-1)
            return false;
        else
            return true;
    }

    public Integer total(String status){
        int fix = 0;
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery(
                "SELECT SUM(nominal) FROM cashFlow WHERE status = \"" + status + "\"", null);
        if(cursor.moveToFirst()) {
            fix = cursor.getInt(0);
        }

        return fix;
    }

    public Boolean insertDataCashFlow(String tanggal, Integer nominal, String keterangan, String status){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tanggal", tanggal);
        contentValues.put("nominal", nominal);
        contentValues.put("keterangan", keterangan);
        contentValues.put("status", status);
        long result = MyDB.insert("cashFlow",null,contentValues);

        if(result==-1)
            return false;
        else
            return true;

    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkpassword(String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where password = ? and username = \"user\"", new String[] {password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public void updatePassword(String pwdNew){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("UPDATE users SET password= \"" + pwdNew + "\" WHERE username = \"user\"");
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public ArrayList<CourseModal> readCourses() {

        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM cashFlow", null);

        // on below line we are creating a new array list.
        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new CourseModal(cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getString(3),
                        cursorCourses.getString(4)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }

}
