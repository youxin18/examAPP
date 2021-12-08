package com.examapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Information>informationList1=new ArrayList<>();
    public List<schoolName>schoolNameList1=new ArrayList<>();
    public List<RealQuestion>realQuestionList1=new ArrayList<>();
    private LinearLayout findLayout;
    private LinearLayout meLayout;
    private LinearLayout firstLayout;
    private  String title;
    private String content;
    private String name;
    private ImageView warning;
    private ImageView alarm;
    private LinearLayout lianxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findLayout=findViewById(R.id.bottom_find);
        meLayout=findViewById(R.id.bottom_me);
        firstLayout=findViewById(R.id.bottom_first);
        warning=findViewById(R.id.warning);
        alarm=findViewById(R.id.alarm);
        lianxi=findViewById(R.id.xunlian);
      // upData();
        upSchoolData();

        replaceFragment(new FirstFragment(schoolNameList1));



        loadData();
        loadSchoolData();
        warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,WarningActivity.class);
                startActivity(intent);

            }
        });
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AlarmActivity.class);
                startActivity(intent);
            }
        });
        findLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              replaceFragment(new FindFragment(informationList1));


            }
        });

        lianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // upRealQuestionData();
                loadRealQuestionData();

                replaceFragment(new PracticeFragment(realQuestionList1));
            }
        });
        meLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new MeFragment());
            }
        });
        firstLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new FirstFragment(schoolNameList1));
            }
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.content_fragment,fragment);
        transaction.commit();
    }
    @SuppressLint("Range")
    private void loadData() {
            InformationDbHelper dbHelper=new InformationDbHelper(this,"message.db",null,1);
            SQLiteDatabase db=dbHelper.getWritableDatabase();
            Cursor cursor = db.query("information", null, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    title=cursor.getString(cursor.getColumnIndex("title"));
                 content = cursor.getString(cursor.getColumnIndex("content"));
                 int id= cursor.getInt(cursor.getColumnIndex("id"));
                 Information information=new Information(id,title,content);
                informationList1.add(information);

                } while (cursor.moveToNext());

            }
            cursor.close();
        }
        private void upData(){
            InformationDbHelper informationDbHelper=new InformationDbHelper(this,"message.db",null,1);
            SQLiteDatabase db= informationDbHelper.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("id",1);
            values.put("title","指南");
            values.put("content","重要通知！江苏省考笔试疫情防控补充通知");
            db.insert("information",null,values);
            values.clear();

            values.put("title","实时资讯");
            values.put("id",2);
            values.put("content","招1370人！，西安市公开招聘社区工作者公告来了！");
            db.insert("information",null,values);
            values.clear();

            values.put("title","实时资讯");
            values.put("content","教育部：尽早安排机关，事业单位招聘考试！");
            values.put("id",3);
            db.insert("information",null,values);
            values.clear();

            values.put("title","实时资讯");
            values.put("content","2022年广东省考全方位报考专题，持续更新！");
            values.put("id",4);
            db.insert("information",null,values);

            values.clear();

            values.put("title","实时资讯");
            values.put("content","招1370人！，西安市公开招聘社区工作者公告来了！");
            values.put("id",5);
            db.insert("information",null,values);

            values.clear();

            values.put("title","实时资讯");
            values.put("id",6);
            values.put("content","招1370人！，西安市公开招聘社区工作者公告来了！");
            db.insert("information",null,values);

            values.clear();

            values.put("title","实时资讯");
            values.put("id",7);
            values.put("content","招1370人！，西安市公开招聘社区工作者公告来了！");
            db.insert("information",null,values);
            values.clear();

            values.put("title","实时资讯");
            values.put("id",8);
            values.put("content","招1370人！，西安市公开招聘社区工作者公告来了！");
            db.insert("information",null,values);



        }
    private void upSchoolData(){
        SchoolDbHelper schoolDbHelper=new SchoolDbHelper(this,"school.db",null,1);
        SQLiteDatabase db= schoolDbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id",1);
        values.put("name","北京大学");
        db.insert("school",null,values);
        values.clear();
        values.put("id",2);
        values.put("name","清华大学");
        db.insert("school",null,values);
        values.clear();
        values.put("id",3);
        values.put("name","北京理工大学");
        db.insert("school",null,values);
        values.clear();
        values.put("id",4);
        values.put("name","东北大学");
        db.insert("school",null,values);
        values.clear();
        values.put("id",5);
        values.put("name","东南大学");
        db.insert("school",null,values);
        values.clear();
        values.put("id",6);
        values.put("name","复旦大学");
        db.insert("school",null,values);
        values.clear();
        values.put("id",7);
        values.put("name","湖南大学");
        db.insert("school",null,values);
        values.clear();

    }
    private void upRealQuestionData(){
        CreateRealQuestionHelper questionHelper=new CreateRealQuestionHelper(MainActivity.this,"English.db",null,1);
        SQLiteDatabase db=questionHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("id","1");
        values.put("title","2010年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","2");
        values.put("title","2011年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","3");
        values.put("title","2012年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","4");
        values.put("title","2013年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","5");
        values.put("title","2014年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","6");
        values.put("title","2015年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","7");
        values.put("title","2016年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","8");
        values.put("title","2017年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","9");
        values.put("title","2018年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","10");
        values.put("title","2019年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();

        values.put("id","11");
        values.put("title","2020年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
        values.clear();
        values.put("id","12");
        values.put("title","2021年全国硕士研究生招生考试-英语（二）");
        db.insert("question",null,values);
    }
    @SuppressLint("Range")
    private void loadSchoolData() {
        SchoolDbHelper schoolDbHelper=new SchoolDbHelper(this,"school.db",null,1);
        SQLiteDatabase db= schoolDbHelper.getWritableDatabase();
        Cursor cursor = db.query("school", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int schoolid= cursor.getInt(cursor.getColumnIndex("id"));
                name=cursor.getString(cursor.getColumnIndex("name"));
                schoolName schoolNames=new schoolName(schoolid,name);
                schoolNameList1.add(schoolNames);

            } while (cursor.moveToNext());

        }
        cursor.close();
    }
    @SuppressLint("Range")
    private void loadRealQuestionData() {
        CreateRealQuestionHelper realQuestionHelper=new CreateRealQuestionHelper(this,"English.db",null,1);
        SQLiteDatabase db= realQuestionHelper.getWritableDatabase();
        Cursor cursor = db.query("question", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
              title=cursor.getString(cursor.getColumnIndex("title"));
              RealQuestion realQuestion=new RealQuestion(title);
              realQuestionList1.add(realQuestion);

            } while (cursor.moveToNext());

        }
        cursor.close();
    }

}