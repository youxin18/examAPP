package com.examapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class WriteActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<RealQuestion>realQuestionList=new ArrayList<>();
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        upWriteQuestionData();
        loadWriteQuestionData();
        recyclerView=findViewById(R.id.real_question_write);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RealQuestionAdapter adapter=new RealQuestionAdapter(realQuestionList);
        recyclerView.setAdapter(adapter);

    }
    private void upWriteQuestionData(){
        CreateWriteQuestionHelper writequestionHelper=new CreateWriteQuestionHelper(WriteActivity.this,"Writequestion.db",null,1);
        SQLiteDatabase db=writequestionHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("title","2010年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2011年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2012年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2013年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2014年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2015年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2016年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2017年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2018年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2019年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2020年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
        values.clear();
        values.put("title","2021年管理类专业学位联考-写作");
        db.insert("Writequestion",null,values);
    }
    @SuppressLint("Range")
    private void loadWriteQuestionData() {
        CreateWriteQuestionHelper writequestionHelper=new CreateWriteQuestionHelper(WriteActivity.this,"Writequestion.db",null,1);
        SQLiteDatabase db=writequestionHelper.getWritableDatabase();
        Cursor cursor = db.query("Writequestion", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                title=cursor.getString(cursor.getColumnIndex("title"));
                RealQuestion realQuestion=new RealQuestion(title);

                realQuestionList.add(realQuestion);

            } while (cursor.moveToNext());

        }
        cursor.close();
    }
}