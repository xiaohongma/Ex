package com.example.administrator.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.example.administrator.ex.sys.Constant;
import com.example.administrator.ex.util.ManifestUtils;
import com.example.administrator.ex.util.PreferenceUtils;

/**
 * Created by Administrator on 2016/4/25.
 * 创建启动页面，可以在此处投放广告，加载后台数据等。如果以前登陆过，就跳转到主界面，如果以前没有登陆过，就跳转到登陆界面。
 */
public class StartActivity extends Activity {
    private View view;
    private WebView webView;
    @Override
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
       setContentView(R.layout.activity_start);
        //开启推送服务
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, ManifestUtils.getMetaValue(getApplicationContext(),Constant.API_KEY));
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
        },500);
    }
    private void jump(){
        String token = PreferenceUtils.getString(getApplicationContext(), Constant.TOKEN);
        String email  = PreferenceUtils.getString(getApplicationContext(),Constant.EMAIL);
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(token)){
            //login(context,userId,channelId,email,token);
            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();


        }else{
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            finish();
        }

    }
}
