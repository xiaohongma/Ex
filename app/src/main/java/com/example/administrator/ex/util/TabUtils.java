package com.example.administrator.ex.util;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.administrator.ex.R;

/**
 * Created by Administrator on 2016/4/19.
 */
public class TabUtils {
    public static TextView tabText;
    public static TextView tabBadge;
    public static View renderTabView(Context context,int titleResource,int badgeNumber){
        FrameLayout view = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.tab_badge,null);
        //因为没有viewroot，所以要手动加上这一句设置LayoutParams
       view.setLayoutParams( new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        //((TextView)view.findViewById(R.id.tab_text)).setText(titleResource);
        //((TextView)view.findViewById(R.id.tab_badge)).setText(badgeNumber);
        tabText =(TextView)view.findViewById(R.id.tab_text);
        tabBadge =(TextView)view.findViewById(R.id.tab_badge);
        tabText.setText(titleResource);
        //tabBadge.setText(Integer.toString(badgeNumber));
        updateTabBadge(tabBadge,badgeNumber);
        return view;
    }

    public static void updateTabBadge(ActionBar.Tab tab,int badgeNumber){
        updateTabBadge(tab.getCustomView(),badgeNumber);
    }
    public static void updateTabBadge(View view,int badgeNumber){
        if(badgeNumber>0){
            tabBadge.setVisibility(View.VISIBLE);
            tabBadge.setText((Integer.toString(badgeNumber)));

        }else{
            tabBadge.setVisibility(View.INVISIBLE);
        }
    }
}
