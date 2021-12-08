package com.zkyouxi.httprequestdemo;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBUtils {
    private static DBUtils dbUtils;
    private SQLiteDatabase db;
    public String sql;




    public static DBUtils getInstance(){
        if(dbUtils==null){
            dbUtils=new DBUtils();
            return dbUtils;
        }
        return dbUtils;
    }
    public void creates(Context context,String sql){
        String path=context.getCacheDir().getPath()+"/sqlite.db";
        db=SQLiteDatabase.openOrCreateDatabase(path,null);
         db.execSQL(sql);
    }
    @SuppressLint("Range")
    public ArrayList<PayInfo> query(String table){
        ArrayList<PayInfo>list=new ArrayList<>();
        Cursor cursor=db.query(table,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            PayInfo payInfo=new PayInfo();
             //可在这里改变要查询的字段
            list.add(payInfo);

        }
        if (cursor!=null){
            cursor.close();
        }
        return list;
    }

    public int delete(int id,String table){
        int inde=db.delete(table,"id=?",new String[Integer.parseInt(String.valueOf(id))]);
        Log.e("--Main--","======删除了====="+inde);
        return inde;
    }

    public int modifyData(int id,ContentValues contentValues,String table){
        int index=db.update(table,contentValues,"id=?",new String[Integer.parseInt(String.valueOf(id))]);
        Log.e("--Main--","======修改了======"+index);
        return index;
    }
    public  long insertData(String table,ContentValues contentValues){
        long dataSize=db.insert(table,null,contentValues);
        Log.e("--Main--","插入数据成功");
        return dataSize;
    }
}
