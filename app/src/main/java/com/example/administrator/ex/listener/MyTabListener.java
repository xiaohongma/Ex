package com.example.administrator.ex.listener;

import android.app.ActionBar;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by Administrator on 2016/4/18.
 */
public class MyTabListener<T extends Fragment>  implements TabListener {
    private Activity activity;
    private Fragment fragment;
    private Class<T> mClass;
    /*
    这个构造方法绑定fragment所属的活动
     */
    public MyTabListener(Activity activity,Class<T> mClass){
        this.activity = activity;
        this.mClass =mClass;

    }
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
      if(fragment ==null){
            fragment = Fragment.instantiate(activity,mClass.getName());
            ft.add(android.R.id.content, fragment);
       }
       ft.attach(fragment);

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        if(fragment !=null){
           ft.detach(fragment);
        }

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
