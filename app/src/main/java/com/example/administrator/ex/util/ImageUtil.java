package com.example.administrator.ex.util;

import android.widget.ImageView;

import com.example.administrator.ex.sys.ExApplication;

/**
 * Created by Administrator on 2016/5/28.
 */
public class ImageUtil {

   public static void displayImage(String url,ImageView imageView){
       ExApplication.getInstance().getImageLoader().displayImage(url,imageView);
   }

}
