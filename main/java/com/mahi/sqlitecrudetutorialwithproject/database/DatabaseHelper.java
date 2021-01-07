package com.mahi.sqlitecrudetutorialwithproject.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "info.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static final String TABLE_NAME = "std_info_table";
    public static final String ROW_ID = "id";
    public static final String NAME = "std_name";
    public static final String IMAGE = "std_image";
    public static final String PHONE = "std_phone";
    public static final String EMAIL = "std_email";
    public static final String CGPA = "std_cgpa";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL,"
            + NAME + " TEXT, "
            + IMAGE + " TEXT, "
            + PHONE + " TEXT, "
            + EMAIL + " TEXT, "
            + CGPA + " TEXT " + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( );
        onCreate(db);
    }
}
