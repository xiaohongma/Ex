package com.example.administrator.ex.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/5/4 0004.
 */
public class ManifestUtils {
    /**
     * 获取meta值
     */
    public static String getMetaValue(Context context,String metaKey){
        Bundle metaData = null;
        String apiKey = null;
        if(context==null||metaKey==null){
            return null;
        }
        try{
            ApplicationInfo ai = context.getPackageManager().
                    getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if(ai != null){
                metaData = ai.metaData;
            }
            if(metaData !=null){
                apiKey = metaData.getString(metaKey);
            }

        }catch (Exception ex){

        }
        return  apiKey;
    }
}
