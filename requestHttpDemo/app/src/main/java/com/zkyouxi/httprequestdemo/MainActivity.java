package com.zkyouxi.httprequestdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttp;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button btn;
    public static final int SET_TEXT=1;
    private String out_trade_no;
    private int total_charge;//支付金额，rmb，单位为分
    private String access_token;//登录成功后服务端返回的access_token
    private String async_callback_url;//支付成功回调地址
    private String product_id;//商品id
    private String product_name;//商品名
    private int product_amount;//商品数量
    private String product_desc;//商品展示描述
    private int rate;//兑换比率
    private String role_id;//角色id
    private String role_name;//角色名
    private String server_id;//角色所在的区服id
    private String extend;//透传字段，原样返回，
    private String union_extend;//透传字段，SDK专用
    private String currency_code;//使用国际通用货币代码
    private int pay_type;//支付类型，如：支付宝，微信
    private String order_no;
    private String sql;
    private Button save;
    private String table;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case SET_TEXT:
                    textView.setText(out_trade_no+"\n"+total_charge);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview);
        editText=findViewById(R.id.ed_http);
        save=findViewById(R.id.save);
        btn=findViewById(R.id.btn);
        sql="create table if not exists playinfo"+"(id integer primary key autoincrement,"+"out_trade_no,"+"total_charge," +
                "access_token,"+"async_callback_url,"+"product_id,"+"product_name,"+"product_amount,"+"product_desc,"+"rate,"+"role_id,"+
                "role_name,"+"server_id,"+"extend,"+"union_extend,"+"currency_code,"+"pay_type,"+"order_no)";
        table="playinfo";
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBUtils.getInstance().creates(MainActivity.this,sql);
                ContentValues contentValues=new ContentValues();
                contentValues.put("out_trade_no",out_trade_no);
                contentValues.put("total_charge",total_charge);
                contentValues.put("access_token",access_token);
                contentValues.put("async_callback_url",async_callback_url);
                contentValues.put("product_id",product_id);
                contentValues.put("product_name",product_name);
                contentValues.put("product_amount",product_amount);
                contentValues.put("product_desc",product_desc);
                contentValues.put("orate",rate);
                contentValues.put("role_id",role_id);
                contentValues.put("server_id",server_id);
                contentValues.put("extend",extend);
                contentValues.put("union_extend",union_extend);
                contentValues.put("currency_code",currency_code);
                contentValues.put("pay_type",pay_type);
                contentValues.put("order_no",order_no);
                DBUtils.getInstance().insertData(table,contentValues);
                Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
            }
        });



      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String a="a";
              if(editText.getText().toString().equals(a)) {
                  Log.d("Union", "btn onclick");
                  HttpUtil.sendOkHttpRequest("http://172.16.5.89:9000", new okhttp3.Callback() {
                      @Override
                      public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                          try {
                              String responseData = response.body().string();
                              Log.d("Union", responseData);
                              JSONObject object = new JSONObject(responseData);
                         /* JSONArray jsonArray=new JSONArray(responseData);
                          for(int i=0;i<jsonArray.length();i++){*/
                              /* JSONObject jsonObject=jsonArray.getJSONObject(i);*/
                              out_trade_no = object.getString("out_trade_no");
                              total_charge=object.getInt("total_charge");
                              access_token = object.getString("access_token");
                              async_callback_url=object.getString("async_callback_url");
                              product_id=object.getString("product_id");
                              product_name=object.getString("product_name");
                              product_amount=object.getInt("product_amount");
                              product_desc=object.getString("product_desc");
                              rate=object.getInt("rate");
                              role_id=object.getString("role_id");
                              role_name=object.getString("role_name");
                              server_id=object.getString("server_id");
                              extend=object.getString("extend");
                              union_extend=object.getString("union_extend");
                              currency_code=object.getString("currency_code");
                              pay_type=object.getInt("pay_type");
                              order_no=object.getString("order_no");
                              Message message = new Message();
                              message.what = SET_TEXT;
                              handler.sendMessage(message);


                              /*}*/
                          } catch (Exception e) {
                              e.printStackTrace();
                          }

                      }

                      @Override
                      public void onFailure(@NotNull Call call, @NotNull IOException e) {
                          Log.d("Union", "on fail:" + e.toString());
                      }
                  });
              }else {
                  Toast.makeText(MainActivity.this,"invalid ip",Toast.LENGTH_SHORT).show();
              }
          }
      });
    }
}