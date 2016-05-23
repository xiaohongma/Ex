package com.example.administrator.ex.message;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.administrator.ex.LoginActivity;
import com.example.administrator.ex.MainActivity;
import com.example.administrator.ex.http.BaseResponse;
import com.example.administrator.ex.http.RequestListener;
import com.example.administrator.ex.http.VolleyHttpClient;
import com.example.administrator.ex.model.Member;
import com.example.administrator.ex.sys.Constant;
import com.example.administrator.ex.util.PreferenceUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/7.
 */
public class MessageHandler {
    //private static int loadingMsg = R.integer.NOT_SHOW_LOADING_DIALOG;
    private static VolleyHttpClient httpClient;
    public static void bindSuccess(Context context,int errorCode,String userId,String channelId){
        PreferenceUtils.setPreference(context, errorCode, userId, channelId);
        //验证本地的token，若token已过期或不存在），则重新登录
        String token = PreferenceUtils.getString(context, Constant.TOKEN);
        String email  = PreferenceUtils.getString(context,Constant.EMAIL);
       // if(!TextUtils.isEmpty(token) &&(!TextUtils.isEmpty(email))){
            login(context,userId,channelId,email,token);

      //  }
    }
    private static void login( final Context context,String userId,String channelId,String email,String token){
        Map<String,String> map =  new HashMap<String,String>(4);
        map.put("email",email);
        map.put("channelId",channelId);
        map.put("token",token);
        map.put("userId",userId);
        httpClient = VolleyHttpClient.getInstance(context);
       httpClient.post(Constant.API.URL_LOGIN_TOKEN,map,new RequestListener(){

            @Override
            public void onPreRequest() {

            }

            @Override
            public void onRequestSuccess(BaseResponse response) {
                Member member = response.getObj(Member.class);
                PreferenceUtils.saveMember(context,member);

            }

            @Override
            public void onRequestError(int code, String msg) {
                authError(context);
            }

            @Override
            public void onRequestFall(int code, String msg) {
                authError(context);
            }
        });
    }
    private static void authError(Context context){

        Toast.makeText(context,"认证过期，请重新认证",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(context, LoginActivity.class);

       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if(MainActivity.mainAcitvity !=null) {
            MainActivity.mainAcitvity.finish();
            //context.getClass().getSimpleName();
        }

    }
}
