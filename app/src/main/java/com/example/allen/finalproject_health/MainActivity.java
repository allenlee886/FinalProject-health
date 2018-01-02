package com.example.allen.finalproject_health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText h;                //宣告全域變數
    EditText w;                //宣告全域變數
    EditText b;               //宣告全域變數

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h = (EditText)findViewById(R.id.editText1);                            // 取得身高物件
        w = (EditText)findViewById(R.id.editText2);                           // 取得體重物件
        b =(EditText)findViewById(R.id.editText);                         // 取得腰圍物件
        Button submit = (Button)findViewById(R.id.button1); // 取得按鈕物件


        // 按下按鈕 觸發事件
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行
                if ( !("".equals(h.getText().toString())
                        || "".equals(w.getText().toString())) || "".equals(b.getText().toString()) )
                {
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,activity_count_bmi.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("height",h.getText().toString());
                    bundle.putString("width",w.getText().toString());
                    bundle.putString("waist",b.getText().toString());
                    intent.putExtras(bundle);   // 記得put進去，不然資料不會帶過去哦

                    startActivity(intent);
                }
            }
        });

    }
}
