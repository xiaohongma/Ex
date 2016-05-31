package com.example.administrator.ex;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.ex.adapter.ChatAdapter;
import com.example.administrator.ex.service.ContactService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ChatMsg;
import model.Contact;

/**
 * Created by Administrator on 2016/5/29.
 */
public class ChatActivity extends Activity  {
    private Button send;
    private EditText editText;
    private ListView listView;
    private ChatAdapter adapter;
    private ContactService contactService = ContactService.getInstance();
    private Contact friend;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        send =(Button)findViewById(R.id.send_chat_msg);
        editText =(EditText)findViewById(R.id.chat_msg);
        listView =(ListView)findViewById(R.id.chat_list_view);
        friend = (Contact)getIntent().getSerializableExtra("friend");
      //  List<Contact> list = contactService.getContactList(getApplicationContext());
       // Contact friend = new Contact(1l,1,1,"email","纵汶静","http://192.168.1.115:8080/exchange/4.jpg","http://192.168.1.115:8080/exchange/4.jpg",new Date(),new Date(),"");
        adapter = new ChatAdapter(initMsg(),this,friend);
        listView.setAdapter(adapter);


    }
    public void onClick(View v){
        createMsg();

    }
    private void createMsg(){
        String inputWords = editText.getText().toString();
        if(TextUtils.isEmpty(inputWords)){
            Toast.makeText(this,"请输入消息",Toast.LENGTH_LONG).show();
            return ;
        }
        ChatMsg chatMsg = new ChatMsg();
        chatMsg.setChatMsg(inputWords);
        chatMsg.setChatType(ChatMsg.MSG_TYPE_TEXT);
        chatMsg.setContactId(friend.getContactId());
        chatMsg.setIsReceived(ChatMsg.SEND);
        chatMsg.setStatus(ChatMsg.STATE_NO_SEND);
       //
       chatMsg.setChatTime(new Date());

        adapter.addData(chatMsg);
        editText.setText("");

        Log.d("Selection", (adapter.getCount() - 1)+"");
       // listView.post(new Runnable() {
         //   @Override
          // public void run() {
               // listView.setSelection(listView.getBottom());//10是你需要定位的位置
              //  listView.requestFocusFromTouch();//获取焦点
             //   listView.setSelection(adapter.getCount()-1);//10是你需要定位的位置
          //  }
     //   });
        listView.setSelection(adapter.getCount());
    }

    private List<ChatMsg> initMsg(){
          List<ChatMsg> list = new ArrayList<ChatMsg>();
        ChatMsg msg1 = new ChatMsg(1l,1,3,"你好",new Date(), ChatMsg.MSG_TYPE_TEXT, ChatMsg.RECEIVER, ChatMsg.STATE_RECEIVED);
        ChatMsg msg2 = new ChatMsg(1l,1,3,"啥事",new Date(), ChatMsg.MSG_TYPE_TEXT, ChatMsg.SEND, ChatMsg.STATE_SEND_SUCCESS);
        ChatMsg msg3 = new ChatMsg(1l,1,3,"做我男朋友吧",new Date(), ChatMsg.MSG_TYPE_TEXT, ChatMsg.RECEIVER, ChatMsg.STATE_RECEIVED);
        ChatMsg msg4 = new ChatMsg(1l,1,3,"我想想",new Date(), ChatMsg.MSG_TYPE_TEXT, ChatMsg.SEND, ChatMsg.STATE_SEND_SUCCESS);

        list.add(msg1);
        list.add(msg2);
        list.add(msg3);
        list.add(msg4);
        return list;
    }


}
