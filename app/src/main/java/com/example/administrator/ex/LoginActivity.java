package com.example.administrator.ex;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.ex.http.BaseResponse;
import com.example.administrator.ex.http.RequestListener;
import com.example.administrator.ex.http.VolleyHttpClient;
import com.example.administrator.ex.model.Member;
import com.example.administrator.ex.service.DataInitService;
import com.example.administrator.ex.sys.Constant;
import com.example.administrator.ex.sys.ExApplication;
import com.example.administrator.ex.util.PreferenceUtils;
import com.example.administrator.ex.widget.LoadingDialog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/3.
 * 登陆界面，单例。点击登陆，从服务器验证账号和令牌。成功的话，跳转到主界面。
 */
public class LoginActivity extends Activity {
    //private int loadingMsg = R.integer.SHOW_LOADING_DIALOG;
    private LoadingDialog loadingDialog;
    private SharedPreferences prefs;
    private VolleyHttpClient httpClient;
    private static int connectionIntent=0;
    private EditText userNameText;
    private EditText passwordText;
    private Button loginButton;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==1){
               loginButton.setEnabled(true);
              //  loginButton.setText("keyi");

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameText = (EditText)findViewById(R.id.user_name);
        passwordText = (EditText)findViewById(R.id.user_password);
        loginButton = (Button)findViewById(R.id.button_login);
        loginButton.setEnabled(false);
        handler.post(new ConnectionChannelRunnable());
       // loadingDialog =new LoadingDialog(getApplicationContext());

    }
    public void login(View v){
        String email = userNameText.getText().toString();
        String password = passwordText.getText().toString();
        if(TextUtils.isEmpty(email)||(TextUtils.isEmpty(password))){
            Toast.makeText(getApplicationContext(),"请输入邮箱或者密码",Toast.LENGTH_LONG).show();
            return;
        }

        doLogin(email,password);
    }
    private void doLogin(String email,String password){
        //Map<String,String> map = new Map<>(4);
        //在这里登陆

        Map<String,String> params = new HashMap<String,String>(4);
        params.put("email",email);
        params.put("password",password);
        params.put("userId",PreferenceUtils.getString(getApplicationContext(),Constant.BD_USER_ID));
        params.put("channelId",PreferenceUtils.getString(getApplicationContext(),Constant.BD_CHANNEL_ID));
        httpClient = VolleyHttpClient.getInstance(this);
        httpClient.post( Constant.API.URL_LOGIN,R.string.loadingMsg_login,params,new RequestListener(){

            @Override
            public void onPreRequest() {

            }

            @Override
            public void onRequestSuccess(BaseResponse response) {
                //获取的信息保存到application和SharedPreferences
                Member member = response.getObj(Member.class);
                PreferenceUtils.saveMember(getApplicationContext(),member);
                ExApplication.getInstance().setLoginMember(member);
                jump();
                //prefs = getSharedPreferences("exchange", Context.MODE_PRIVATE);
                //SharedPreferences.Editor editor = prefs.edit();



            }

            @Override
            public void onRequestError(int code, String msg) {
                Toast.makeText(getApplicationContext(),"状态码"+code+msg,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRequestFall(int code, String msg) {
                Toast.makeText(getApplicationContext(),"状态码"+code+msg,Toast.LENGTH_LONG).show();

            }
        });
    }
    public void jump(){
        startInitDataService();
        Intent i  = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
        this.finish();
    }
    private void  startInitDataService(){
        //初始完数据的时候，将这个标志存为true
        //如果没有初始化数据，则启动该服务
        boolean isDataInit = PreferenceUtils.getBoolean(this,Constant.IS_DATA_INIT,false);

        if(!isDataInit){
            startService(new Intent(this,DataInitService.class));
        }
        //return true;
    }
    class ConnectionChannelRunnable implements  Runnable{

        @Override
        public void run() {
            if(PreferenceUtils.getString(getApplicationContext(), Constant.BD_CHANNEL_ID)!=null){
                handler.sendEmptyMessage(1);
               // return;
                //loginButton.setText(PreferenceUtils.getString(getApplicationContext(), Constant.BD_CHANNELID, null));
            }else if(connectionIntent<5){
                handler.postDelayed(new ConnectionChannelRunnable(),2000);
                connectionIntent = connectionIntent +1;
            }else{
                //请求超过五次，则意味着获取channnel失败
                Toast.makeText(getApplicationContext(),"获取Channel失败",Toast.LENGTH_LONG).show();
                //finish();
                return;
            }
        }
    }
}
