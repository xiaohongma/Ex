package com.example.administrator.ex.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.example.administrator.ex.sys.ExApplication;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import greendao.ChatMsgDao;
import greendao.ContactDao;
import greendao.DaoSession;
import model.ChatMsg;

public class ChatMsgService extends Service {

    private  static ChatMsgService chatMsgService;
    private DaoSession daoSession;
    private ChatMsgDao chatMsgtDao;
    public static   synchronized  ChatMsgService  getInstance(){
        if(chatMsgService==null) {

            chatMsgService = new ChatMsgService();
            chatMsgService.daoSession = ExApplication.getInstance().getDaoSession();
            chatMsgService.chatMsgtDao = chatMsgService.daoSession.getChatMsgDao();

        }
        return chatMsgService;
    }
    private  ChatMsgService() {
        super();
    }
    public  synchronized long save(ChatMsg msg){
       return  chatMsgtDao.insertOrReplace(msg);
       //return  chatMsgtDao.insert(msg);
    }
    public void upDate(ChatMsg msg){
        this.chatMsgtDao.update(msg);
    }
    public List<ChatMsg> getContactList(Context context){
        int  memberId = ExApplication.getInstance().getLoginMember().getMemberId();
        QueryBuilder<ChatMsg> queryBuilder = chatMsgtDao.queryBuilder();
        queryBuilder.where(ContactDao.Properties.MemberId.eq(memberId)).orderAsc(ContactDao.Properties.Pinyin);
        return queryBuilder.list();
    }
    
    
    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
