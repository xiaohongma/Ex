package com.example.administrator.ex.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ex.R;
import com.example.administrator.ex.http.BaseResponse;
import com.example.administrator.ex.http.RequestListener;
import com.example.administrator.ex.http.VolleyHttpClient;
import com.example.administrator.ex.model.Member;
import com.example.administrator.ex.service.ChatMsgService;
import com.example.administrator.ex.sys.Constant;
import com.example.administrator.ex.sys.ExApplication;
import com.example.administrator.ex.util.ImageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.ChatMsg;
import model.Contact;

/**
 * Created by Administrator on 2016/5/29.
 */
public class ChatAdapter extends BaseAdapter {
    private ChatMsgService chatMsgService= ChatMsgService.getInstance();
    private  VolleyHttpClient client;
    private Context context;
    private List<ChatMsg> msgs;
    private LayoutInflater inflater;
    private Contact friend;
    public ChatAdapter(List<ChatMsg> msgs,Context context, Contact friend){
        this.context = context;
        this.msgs =msgs;
        inflater = LayoutInflater.from(context);
        this.friend = friend;

    }
    @Override
    public int getCount() {
        return msgs.size();
    }

    @Override
    public ChatMsg getItem(int position) {
        Log.d("getItem",msgs.get(position).toString());
        return msgs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(viewType==ChatMsg.SEND?R.layout.chat_list_item_send:R.layout.chat_list_item_receiver,parent,false);
            holder.textTime =(TextView)convertView.findViewById(R.id.txtTime);
            holder.headImage =(ImageView)convertView.findViewById(R.id.image_head_small);
            holder.chatMsg = (TextView)convertView.findViewById(R.id.txt_msg);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        ChatMsg  chatMsg= getItem(position);
        holder.chatMsg.setText(chatMsg.getChatMsg()+"");
        holder.textTime.setText(chatMsg.getChatTime().toString());
       if(viewType==ChatMsg.SEND){
           String url = ExApplication.getInstance().getLoginMember().getHeadSmall();
           ImageUtil.displayImage(url, holder.headImage);
       }else{
           String url =  friend.getHeadSmall();
           Log.d("HeadSmall", friend.getHeadSmall());
           ImageUtil.displayImage(url, holder.headImage);
       }
        if(chatMsg.getIsReceived()==ChatMsg.SEND && chatMsg.getStatus()==ChatMsg.STATE_NO_SEND){
            sendMsg(chatMsg,position);
        }

       // Log.d("contact", getItem(position).getName());
        return convertView;
      //  return null;
    }
    @Override
    public int getItemViewType(int position) {
        return getItem(position).getIsReceived();
    }
     @Override
    public int getViewTypeCount() {
        return 2;
    }
    public boolean isEnabled(int position) {
        return false;
    }
    public void addData(ChatMsg chatMsg){
        if(chatMsg!=null){
           msgs.add(chatMsg);
           // msgs.remove(getCount());
            notifyDataSetChanged();//调用getView刷新界面
        }
    }
    public void sendMsg(final ChatMsg chatMsg, final int position){
        Map<String,String> map = new HashMap<String,String>(4);
        final Member member =  ExApplication.getInstance().getLoginMember();
        map.put("loginId",member.getMemberId()+"");
      //  Log.d("loginId",member.getMemberId()+"");
        map.put("token",member.getToken());
       // Log.d("token",member.getToken());
        map.put("friendId",friend.getContactId()+"");
    //    Log.d("friendId",friend.getContactId()+"");
        map.put("msg",chatMsg.getChatMsg());
        client = VolleyHttpClient.getInstance(context);
        client.post(Constant.API.URL_CHAT_SEND,map,new RequestListener() {
            @Override
            public void onPreRequest() {
                chatMsg.setMemberId(member.getMemberId());
               long id = chatMsgService.save(chatMsg);
                Log.d("id",id+"");
                chatMsg.setId(id);

            }

            @Override
            public void onRequestSuccess(BaseResponse response) {
                if(response.isSuccess()){
                    chatMsg.setStatus(ChatMsg.STATE_SEND_SUCCESS);
                }else{
                    chatMsg.setStatus(ChatMsg.STATE_SEND_FAIL);
                }
                msgs.remove(position);
                msgs.add(position,chatMsg);
                chatMsgService.upDate(chatMsg);

            }


            @Override
            public void onRequestError(int code, String msg) {
                chatMsg.setStatus(ChatMsg.STATE_SEND_FAIL);
                chatMsgService.upDate(chatMsg);

            }

            @Override
            public void onRequestFall(int code, String msg) {
                chatMsg.setStatus(ChatMsg.STATE_SEND_FAIL);
                chatMsgService.upDate(chatMsg);

            }
        });

    }
    private class ViewHolder{
        TextView textTime;
        TextView chatMsg;
        ImageView headImage;
    }
}
