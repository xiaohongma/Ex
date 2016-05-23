package com.example.administrator.ex.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.example.administrator.ex.http.BaseResponse;
import com.example.administrator.ex.http.RequestListener;
import com.example.administrator.ex.http.VolleyHttpClient;
import com.example.administrator.ex.sys.Constant;
import com.example.administrator.ex.util.Pinyin4j;
import com.example.administrator.ex.util.PreferenceUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Contact;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * 将数据存放在SQLite数据库
 * <p/>
 */

public class DataInitService extends IntentService {
   private VolleyHttpClient httpClient = VolleyHttpClient.getInstance(this);
    private ContactService contactService = ContactService.getInstance();
    public DataInitService() {
        super("DataInitService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("memberId", PreferenceUtils.getInt(this.getApplicationContext(), Constant.MEMBER_ID)+"");
        map.put("token",PreferenceUtils.getString(this.getApplicationContext(),Constant.TOKEN));
        //Log.d("Preference Value", map.get("memberId")+map.get("token"));
        httpClient.post(Constant.API.URL_FRIENDS,map,new RequestListener() {
            @Override
            public void onPreRequest() {

            }

            @Override
            public void onRequestSuccess(BaseResponse response) {
                //String data = response.getData();
                Log.d("service", response.getData());
                List<Contact> contactList = response.getList(Contact.class);
                if(contactList!=null){
                    List<Contact> temp = new ArrayList<Contact>(contactList.size());
                    for(Contact c:contactList){



                        String pinyin = Pinyin4j.getPinyin(c.getName(), true);
                        c.setPinyin(pinyin);
                        temp.add(c);
                        Log.d("friend",c.getPinyin()+c.getName());
                    }
                    contactService.save(temp);
                    PreferenceUtils.setBoolean(getApplicationContext(),Constant.IS_DATA_INIT,true);

                }




            }

            @Override
            public void onRequestError(int code, String msg) {

            }

            @Override
            public void onRequestFall(int code, String msg) {

            }
        });

    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
