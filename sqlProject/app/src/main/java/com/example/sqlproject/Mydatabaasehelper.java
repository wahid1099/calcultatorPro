package com.example.sqlproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Mydatabaasehelper extends SQLiteOpenHelper {
    private static final String Database_name="Student.db";
    private static final String TABLE_NAME ="Student_details";
    private static final int Version_number=1;
    private static final String ID="_id";
    private static final String NAME="Name";
    private static final String AGE="Age";
    private static final String GENDER="Gender";

    private static final String CREATE_TABLE="CREATE TABLE " + TABLE_NAME  + "("
            + ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + NAME +
            "TEXT,"  + AGE + "INTEGER,"
            + GENDER + "TEXT" + ")";
    private static final String Drop_Table="DROP TABLE IF EXISTS " + TABLE_NAME;
    private final Context context;



    public Mydatabaasehelper(@Nullable Context context) {
        super(context, Database_name, null, Version_number);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL(CREATE_TABLE);
        }catch (Exception e){

        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(Drop_Table);
            onCreate(db);
        }catch (Exception e){

        }

    }
    public Long insertdata(String name,String age,String gender){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValue=new ContentValues();
        contentValue.put(NAME,name);
        contentValue.put(AGE,age);
        contentValue.put(GENDER,gender);
       long rowID= sqLiteDatabase.insert(TABLE_NAME,null,contentValue);
       return rowID;

    }
}
