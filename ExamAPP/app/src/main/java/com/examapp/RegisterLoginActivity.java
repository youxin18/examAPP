package com.examapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterLoginActivity extends AppCompatActivity {
    private TextView pwdLogin;
    private TextView register;
    private EditText user;
    private EditText password;
    private ContentValues value;
    private  String a;
    private  String b;
    private CreateDbHelper dbHelper=new CreateDbHelper(this,"1.db",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pwdLogin=findViewById(R.id.userpwd);
        register=findViewById(R.id.register);
        user=findViewById(R.id.phone);
        password=findViewById(R.id.code);
        pwdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterLoginActivity.this,PwdLoginActivity.class);
                startActivity(intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=user.getText().toString();
               b=password.getText().toString();

                checkISexist(a);

            }
        });

    }
    private void registerUserInfo(String username,String pwd){
        SQLiteDatabase db =dbHelper.getWritableDatabase();
         value=new ContentValues();
        value.put("username",username);
        value.put("pwd",pwd);
       db.insert("user",null,value);
        db.close();
        Toast.makeText(this,"注册成功，请登录！",Toast.LENGTH_SHORT).show();
    }
    private boolean checkISexist(String value){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String query="Select*from user where username=?";
        Cursor cursor=db.rawQuery(query,new String[]{value});
        if(cursor.getCount()>0){
            cursor.close();
            Toast.makeText(this,"该用户名已注册，请登录！",Toast.LENGTH_SHORT).show();
            return true;
        }else {
            cursor.close();
            registerUserInfo(a, b);
            return false;
        }
    }
}