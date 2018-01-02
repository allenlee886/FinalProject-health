package com.example.allen.finalproject_health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.NumberFormat;

import android.webkit.WebView;
import android.widget.TextView;

public class activity_count_bmi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_bmi);Bundle bundle = getIntent().getExtras();
        String h = bundle.getString("height" );
        String w = bundle.getString("width");
        String b = bundle.getString("waist");

        float fh = Float.parseFloat(h);      // 取得 身高輸入值
        double fw = Float.parseFloat(w);     // 取得 體重輸入值

        double fb = Float.parseFloat(b);

        double fresult;                     // BMI值 計算結果
        double bresult;
        double fw1;

        TextView result = (TextView)findViewById(R.id.textView1);// 取得 顯示結果 物件
        fh = fh/100; // 計算BMI
        fh = fh*fh;  // 計算BMI


        NumberFormat nf = NumberFormat.getInstance();   // 數字格式
        nf.setMaximumFractionDigits(2);                 // 限制小數第二位
        fresult = fw/fh;                                // 計算BMI
        result.setText(nf.format(fw/fh) );           // 顯示BMI計算結果

        TextView dia = (TextView)findViewById(R.id.textView2);// 取得 顯示診斷 物件
        // 診斷結果 顯示
        if (fresult<18.5)
            dia.setText("體重過輕");
        else if (18.5 <= fresult && fresult< 24)
            dia.setText("正常範圍");
        else if (24 <=fresult && fresult < 27)
            dia.setText("過    重");
        else if (27 <=fresult && fresult < 30)
            dia.setText("輕度肥胖");
        else if (30 <= fresult && fresult < 35)
            dia.setText("中度肥胖");
        else if (fresult >= 35)
            dia.setText("重度肥胖        ");

        TextView result1 = (TextView)findViewById(R.id.textView3);

        NumberFormat bf = NumberFormat.getInstance();   // 數字格式
        bf.setMaximumFractionDigits(2);

        bresult = fb*0.74;
        fw1 = fw*0.082;
        fw = fw1+44.74;
        bresult = bresult-fw;
        result1.setText(bf.format(Math.abs(bresult-fw1) ));


        WebView webView = (WebView) findViewById(R.id.webView01);
        String url = "https://www.mohw.gov.tw/mp-1.html";
        webView.loadUrl(url);
    }
}
