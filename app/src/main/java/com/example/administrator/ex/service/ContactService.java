package com.example.administrator.ex.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.administrator.ex.sys.ExApplication;

import java.util.List;

import greendao.ContactDao;
import greendao.DaoSession;
import model.Contact;

public class ContactService extends Service {
    private  static ContactService contactService;
    private DaoSession daoSession;
    private ContactDao contactDao;
    public static   synchronized  ContactService  getInstance(){
        if(contactService==null) {

            contactService = new ContactService();
            contactService.daoSession = ExApplication.getInstance().getDaoSession();
            contactService.contactDao = contactService.daoSession.getContactDao();

        }
        return contactService;
    }
    private  ContactService() {
        super();
    }
public void save(List<Contact> contactList){
    contactDao.insertOrReplaceInTx(contactList);
}
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
