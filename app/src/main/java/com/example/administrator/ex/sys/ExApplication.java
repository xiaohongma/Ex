package com.example.administrator.ex.sys;

import android.app.Application;

import com.example.administrator.ex.model.Member;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

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
    private ImageLoader imageLoader;

    @Override
    public void onCreate(){
        super.onCreate();
        if(instance==null){
            instance = this;
            //instance = new ExApplication();
        }

    }
    public static synchronized ExApplication getInstance(){

        return  instance;
    }
    public   ExApplication(){

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
    public ImageLoader getImageLoader(){
        if(imageLoader == null){
            imageLoader = ImageLoader.getInstance();
            imageLoader.init(initImageConf());
        }
        return imageLoader;
    }
    private ImageLoaderConfiguration initImageConf(){
        File cacheDir = StorageUtils.getCacheDirectory(getApplicationContext());
        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .memoryCacheExtraOptions(1024, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)

                 .threadPoolSize(3) // default
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(20) // default
                .diskCache(new UnlimitedDiskCache(cacheDir)) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(this)) // default
                .diskCache(new UnlimitedDiskCache(cacheDir))
               // .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();
        return config;
    }
}
