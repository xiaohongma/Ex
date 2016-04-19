package com.example.administrator.ex.model;

/**
 * Created by Administrator on 2016/3/30.
 */
public class Dialog {
    private String name;
    private int headImageId;
    private String update;
    private String time;
    private String  warnImageId;
    public Dialog(int headImageId,String name,String update,String time,String  warnImageId){
        this.headImageId= headImageId;
        this.name= name;
        this.time = time;
        this.update =update;
        this.warnImageId = warnImageId;

    }
    public String getName(){
        return name;
    }
    public String getUpdate(){
        return update;
    }
    public int getHeadImageId(){
        return headImageId;
    }
    public String getWarnImageId(){
        return warnImageId;
    }
    public String getTime(){
        return time;
    }
}
