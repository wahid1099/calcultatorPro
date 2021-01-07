package com.mahi.sqlitecrudetutorialwithproject.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mahi.sqlitecrudetutorialwithproject.database.DatabaseHelper;
import com.mahi.sqlitecrudetutorialwithproject.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {
    private DatabaseHelper databaseHelper;

    public DBAdapter(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void insertIntoDB(Student student){
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, student.getName());
        contentValues.put(DatabaseHelper.IMAGE, student.getImage());
        contentValues.put(DatabaseHelper.PHONE, student.getPhone());
        contentValues.put(DatabaseHelper.EMAIL, student.getEmail());
        contentValues.put(DatabaseHelper.CGPA, student.getCgpa());

        database.insert(DatabaseHelper.TABLE_NAME,null, contentValues);
        database.close();

    }
    public List<Student> getAllData(){
        List<Student> studentList = new ArrayList<>();

        String[] getColumn = {DatabaseHelper.ROW_ID,
                DatabaseHelper.NAME,
                DatabaseHelper.IMAGE,
                DatabaseHelper.PHONE,
                DatabaseHelper.EMAIL,
                DatabaseHelper.CGPA};
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,getColumn,null,null,null,null,null);

        if (cursor.moveToFirst()){
            do {
                Student student = new Student(); //need constructor here
                student.setId(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setImage(cursor.getString(2));
                student.setPhone(cursor.getString(3));
                student.setEmail(cursor.getString(4));
                student.setCgpa(cursor.getFloat(5));
                studentList.add(student);
            }while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return studentList;
    }

    public void updateFromDB(Student student){
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME,student.getId());
        contentValues.put(DatabaseHelper.IMAGE,student.getImage());
        contentValues.put(DatabaseHelper.PHONE,student.getPhone());
        contentValues.put(DatabaseHelper.EMAIL,student.getEmail());
        contentValues.put(DatabaseHelper.CGPA,student.getCgpa());

        database.update(DatabaseHelper.TABLE_NAME,contentValues,DatabaseHelper.ROW_ID + " = ? ", new String[]{String.valueOf(student.getId())});
        database.close();

    }
    public void deleteFromDB(Student student) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        db.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.ROW_ID + " = ? ", new String[]{String.valueOf(student.getId())});
        db.close();
    }


}
