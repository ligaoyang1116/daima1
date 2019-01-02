package com.gy.lgy20190102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class XiangQingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        WebView web = findViewById(R.id.web);
        Intent intent = getIntent();
        String gy = intent.getStringExtra("gy");
        web.loadUrl(gy);
        web.setWebViewClient(new WebViewClient());
    }
}
