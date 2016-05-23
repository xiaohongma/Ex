package com.example.administrator.ex.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.ex.model.Member;
import com.example.administrator.ex.sys.Constant;

/**
 * Created by Administrator on 2016/5/4 0004.
 */
public class PreferenceUtils {
    private static String userId ;
    private static String channelId;

    public static String  getString(Context context,String key){

        SharedPreferences  prefs = context.getSharedPreferences(Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
        String value = prefs.getString(key,"");


        return value;
    }
    public static int    getInt(Context context,String key){
        //Log.d("received key", key);
        SharedPreferences  prefs = context.getSharedPreferences(Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
        int  value = prefs.getInt(key,0);
       // Log.d("Preference Value", value+"");
        return value;
    }

    public static void setPreference(Context context,int errorCode,String userId,String channelId){
        PreferenceUtils.userId = userId;
        PreferenceUtils.channelId =channelId;
        //将ChannelId和userId保存到本地
        SharedPreferences  prefs = context.getSharedPreferences(Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(Constant.BD_USER_ID, userId);
        editor.putString(Constant.BD_CHANNEL_ID,channelId);
        editor.commit();

    }
    public static void saveMember(Context context ,Member member){
       SharedPreferences  prefs = context.getSharedPreferences(Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(Constant.MEMBER_ID,member.getMemberId());
        editor.putString(Constant.EMAIL, member.getEmail());
        editor.putString(Constant.TOKEN,member.getToken());
        editor.putString(Constant.NAME,member.getName());
        editor.putString(Constant.HEAD_ID,member.getHeadId());
        editor.putString(Constant.HEAD_SMALL,member.getHeadSmall());
        editor.putString(Constant.HEAD_BIG,member.getHeadBig());
       // editor.putString(Constant.MEMBER,member.toString());
        editor.commit();
        //存在Application里面

    }
    public static boolean getBoolean(Context context,String key,boolean defaultValue){

        SharedPreferences preferences = context.getSharedPreferences(Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
        boolean  value = preferences.getBoolean(Constant.IS_DATA_INIT,defaultValue);
        return value;
    }
    public static void setBoolean(Context context,String key,boolean value){

        SharedPreferences preferences = context.getSharedPreferences(Constant.PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(Constant.IS_DATA_INIT,value);
        editor.commit();
       // boolean  value = preferences.getBoolean(Constant.IS_DATA_INIT,defaultValue);
        //return value;
    }
}
