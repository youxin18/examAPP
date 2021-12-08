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

public class MathActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
    private List<RealQuestion>realQuestionList=new ArrayList<>();
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
     upMathQuestionData();
        loadMathQuestionData();
        recyclerView=findViewById(R.id.real_question_math);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RealQuestionAdapter adapter=new RealQuestionAdapter(realQuestionList);
        recyclerView.setAdapter(adapter);


    }
    private void upMathQuestionData(){
        CreateMathQuestionHelper mathquestionHelper=new CreateMathQuestionHelper(MathActivity.this,"Math.db",null,1);
        SQLiteDatabase db=mathquestionHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id","1");
        values.put("title","2010年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","2");
        values.put("title","2011年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","3");
        values.put("title","2012年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","4");
        values.put("title","2013年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","5");
        values.put("title","2014年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","6");
        values.put("title","2015年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","7");
        values.put("title","2016年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","8");
        values.put("title","2017年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","9");
        values.put("title","2018年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","10");
        values.put("title","2019年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","11");
        values.put("title","2020年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
        values.clear();

        values.put("id","12");
        values.put("title","2021年全国硕士研究生招生考试-数学（二）");
        db.insert("Mathquestion",null,values);
    }
    @SuppressLint("Range")
  private void loadMathQuestionData() {
        CreateMathQuestionHelper mathQuestionHelper=new CreateMathQuestionHelper(this,"Math.db",null,1);
        SQLiteDatabase db= mathQuestionHelper.getWritableDatabase();
        Cursor cursor = db.query("Mathquestion", null, null, null, null, null, null);
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