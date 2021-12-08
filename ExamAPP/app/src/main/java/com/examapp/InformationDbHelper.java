package com.examapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class InformationDbHelper extends SQLiteOpenHelper {
    public static final String CREATE_INFORMATION="create table information("+"id integer primary key autoincrement,"+"title text,"+"content text)";
    private Context mContext;
    public InformationDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_INFORMATION);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
