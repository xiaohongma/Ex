package com.example.administrator.ex.sys;

import android.app.Application;

import com.example.administrator.ex.model.Member;

import greendao.DaoMaster;
import greendao.DaoSession;

/**
 * Created by Administrator on 2016/5/16.
 */
public class ExApplication extends Application {
    private static ExApplication instance;
    private Member loginMember;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    @Override
    public void onCreate(){
        super.onCreate();
        if(instance==null){
            instance = this;
        }
    }
    public static synchronized ExApplication getInstance(){
        return instance;
    }
    public void setLoginMember(Member loginMember){
        this.loginMember = loginMember;
    }
    public Member getLoginMember(){
        return this.loginMember;
    }
    public DaoMaster getDaoMaster(){
        if(daoMaster==null){
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(getApplicationContext(),Constant.DB_NAME,null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }
    public DaoSession getDaoSession(){
        if(daoSession==null){
            if(daoMaster==null){
                daoMaster = getDaoMaster();
            }
        }
        daoSession = daoMaster.newSession();
        return daoSession;
    }
}
