package com.example.administrator.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.administrator.ex.sys.Constant;

/**
 * Created by Administrator on 2016/4/25.
 * 创建启动页面，可以在此处投放广告，加载后台数据等。
 */
public class StartActivity extends Activity {
    private View view;
    private WebView webView;

    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
       setContentView(R.layout.activity_start);
       // PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY,"KZ8nKXyc8AkZoV2bLKLPBgir");
        this.getActionBar().hide();
        webView =(WebView)findViewById(R.id.web_view_1);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.loadUrl(Constant.API.URL_STATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jump();
            }
        },10000);
    }
    private void jump(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
