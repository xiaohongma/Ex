package com.example.administrator.ex.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.administrator.ex.fragment.MyListFragment;


/**
 * Created by Administrator on 2016/4/3.
 * ViewPager的适配器。连接ViewPager和MyListFragment.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    public final int TOTAL =4;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Log.w("FragmentList", "getItem " + i);
        return MyListFragment.newInstance(i);
      //return null;

    }

    @Override
    public int getCount() {
        return TOTAL;
    }
}
