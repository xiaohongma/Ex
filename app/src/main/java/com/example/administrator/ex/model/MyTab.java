package com.example.administrator.ex.model;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.ActionBar.Tab;
import android.view.View;

import static android.support.v7.app.ActionBar.TabListener;

/**
 * Created by Administrator on 2016/4/16.
 */
public class MyTab extends Tab {
    CharSequence name;
    public MyTab(CharSequence name){
        this.name = name;
    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public Drawable getIcon() {
        return null;
    }

    @Override
    public CharSequence getText() {
        return null;
    }

    @Override
    public Tab setIcon(Drawable drawable) {
        return null;
    }

    @Override
    public Tab setIcon(@DrawableRes int i) {
        return null;
    }

    @Override
    public Tab setText(CharSequence charSequence) {
        return null;
    }

    @Override
    public Tab setText(int i) {
        return null;
    }

    @Override
    public Tab setCustomView(View view) {
        return null;
    }

    @Override
    public Tab setCustomView(int i) {
        return null;
    }

    @Override
    public View getCustomView() {
        return null;
    }

    @Override
    public Tab setTag(Object o) {
        return null;
    }

    @Override
    public Object getTag() {
        return null;
    }

    @Override
    public Tab setTabListener(TabListener tabListener) {
        return null;
    }

    @Override
    public void select() {

    }

    @Override
    public Tab setContentDescription(int i) {
        return null;
    }

    @Override
    public Tab setContentDescription(CharSequence charSequence) {
        return null;
    }

    @Override
    public CharSequence getContentDescription() {
        return null;
    }
}
