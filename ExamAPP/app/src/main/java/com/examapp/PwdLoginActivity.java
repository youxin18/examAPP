package com.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PwdLoginActivity extends AppCompatActivity {
    private CreateDbHelper dbHelper;
    private EditText user;
    private EditText pwd;
    private TextView login;
    private String mid;
    private String mpwd;
    private boolean is;
    private TextView code_login;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pwd_login);
        user=findViewById(R.id.user);
        pwd=findViewById(R.id.pwd);
        login=findViewById(R.id.login);
        code_login=findViewById(R.id.code_login);
    dbHelper=new CreateDbHelper(this,"1.db",null,1);
        SQLiteDatabase db =dbHelper.getWritableDatabase();
     ContentValues contentValues=new ContentValues();
        contentValues.put("username","123");
        contentValues.put("pwd","123");
        db.insert("user",null,contentValues);
        //String sql="insert OR IGNORE into userInfo2(username)values(username)";
        //db.execSQL(sql);
        //db.insert("userInfo2",null,contentValues);
        Cursor cursor=db.query("user",null,null,null,null,null,null);

        if(cursor.moveToFirst()) {
            do {
                mid = cursor.getString(cursor.getColumnIndex("username"));
                mpwd = cursor.getString(cursor.getColumnIndex("pwd"));
            } while (cursor.moveToNext());
        }
        cursor.close();
        login.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String a=user.getText().toString();
                String b=pwd.getText().toString();
                login(a,b);
                if(mid.equals(a)&&mpwd.equals(b)){
                    Intent intent=new Intent(PwdLoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(PwdLoginActivity.this,"账户或密码不对，请核对后重试！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        code_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PwdLoginActivity.this,RegisterLoginActivity.class);
                startActivity(intent);
            }
        });






    }
    @SuppressLint("Range")
    public void login(String username,String pwd) {
        dbHelper=new CreateDbHelper(this,"1.db",null,1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "Select*from user where username=? and pwd=?";
        Cursor cursor = db.rawQuery(sql, new String[]{username, pwd});
        if (cursor.moveToFirst()) {
            do {
                mid = cursor.getString(cursor.getColumnIndex("username"));
                mpwd = cursor.getString(cursor.getColumnIndex("pwd"));
            } while (cursor.moveToNext());
        }
        cursor.close();
    }
}