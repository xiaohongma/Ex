package com.example.administrator.ex.http;


import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/24.
 */
public class BaseResponse{
    private static int SUCCESS =1;
    private Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
   //private Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    private int status;
    private String msg;
    private String  data;


    /*
    处理单个Gson数据
     */
    public<T> T getObj(Class<T> mClass){
        if(TextUtils.isEmpty(data)){
            return null;
        }
        //将data数据转换成指定的对象并返回
        Log.d("ReceivedData", data);
        return gson.fromJson(data,mClass);


    }
    /*
    处理Gson数组
     */
    public<T> List<T> getList(Class<T> mClass){
//        Gson gson = new Gson();
//        if(TextUtils.isEmpty(data)){
//            return null;
//        }
//        List<T> list = gson.fromJson(data,new TypeToken<List<T>>(){}.getType());
//        return list;

        List<T> list = new ArrayList<T>();
        Type listType = type(List.class,mClass);
        list = gson.fromJson(data,listType);
        return list;
    }
    private ParameterizedType type (final Class raw,final Type... args){
        return new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return args;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }

            @Override
            public Type getRawType() {
                return raw;
            }
        };
    }
    public void setStatus(int status){
        this.status = status;

    }
    public int getStatus(){
        return status;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
    public void setData(String data){


        this.data = data;
    }
    public String getData(){
        return data;
    }
    public boolean isSuccess(){
        return status==SUCCESS;
    }

}
