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
import com.example.administrator.ex.util.ImageUtil;

import java.util.List;

import model.Contact;
import stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Administrator on 2016/5/24.
 */
public class ContactAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    private List<Contact> contacts;
    private LayoutInflater inflater;
    public ContactAdapter(Context context,List<Contact> contacts){
        this.contacts = contacts;
        inflater = LayoutInflater.from(context);
       // contacts = ContactService.getInstance().getContactList(context);
    }
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder holder;
        View view;
        if(convertView==null){
            holder = new HeaderViewHolder();
            //view = LayoutInflater.from(getC)
            view = inflater.inflate(R.layout.contact_list_header,null);
            holder.text =(TextView)view.findViewById(R.id.contact_list_header_text);
            view.setTag(holder);

        }else{
            view = convertView;
            holder = (HeaderViewHolder)view.getTag();
        }
        String headerText = getItem(position).getPinyin().subSequence(0,1).charAt(0)+"";
        Log.d("headerText", headerText);
       // TextView textV =holder.text;
        holder.text.setText(headerText);
        return view;

    }

    @Override
    public long getHeaderId(int position) {
        return getItem(position).getPinyin().subSequence(0,1).charAt(0);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Contact getItem(int position) {
        Log.d("getItem",contacts.get(position).getName());
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.contact_list_item,parent,false);
            holder.text =(TextView)convertView.findViewById(R.id.contact_list_text);
            holder.headImage =(ImageView)convertView.findViewById(R.id.contact_list_head);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.text.setText(contacts.get(position).getName());
        String url =  getItem(position).getHeadSmall();
        ImageUtil.displayImage(url, holder.headImage);
        Log.d("contact", getItem(position).getName());
        return convertView;
    }

    class ViewHolder{
        TextView text ;
        ImageView headImage;
    }
    class HeaderViewHolder{
        TextView text;

    }
}
