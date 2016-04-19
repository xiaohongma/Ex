package com.example.administrator.ex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ex.R;
import com.example.administrator.ex.model.Dialog;

import java.util.List;

/**
 * Created by Administrator on 2016/3/30.
 */
public class DialogAdapter extends ArrayAdapter<Dialog> {
    private int itemId;
    private int test=0;
    private  List<Dialog> list;


    public DialogAdapter(Context context, int itemId, List<Dialog> objects){
        super(context,itemId,objects);
        this.itemId = itemId;
        list = objects;
    }
    @Override
    public Dialog getItem(int position){
        //System.out.println("Main item");
      //  test++;
        return list.get(position);
    }
    @Override
    public View getView(int position , View convertView,ViewGroup parent){
        Dialog dialog = getItem(position);
        View view;
       ViewHolder viewHolder;
        if(convertView==null) {
            viewHolder = new ViewHolder();
            view =   LayoutInflater.from(getContext()).inflate(itemId, null);
            viewHolder.headImage = (ImageView)view.findViewById(R.id.head_image);
           viewHolder.name = (TextView)view.findViewById(R.id.name);
           viewHolder.update = (TextView)view.findViewById(R.id.update);
           viewHolder.currentTime = (TextView)view.findViewById(R.id.current_time);
            viewHolder.warnImage = (TextView)view.findViewById(R.id.warn_image);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.headImage.setImageResource(dialog.getHeadImageId());
        viewHolder.update.setText(dialog.getUpdate());
        viewHolder.name.setText(dialog.getName());
        viewHolder.currentTime.setText(dialog.getTime());
        viewHolder.warnImage.setText(dialog.getWarnImageId());
        return view;
    }
    class ViewHolder{
        ImageView headImage;
        TextView update;
        TextView name;
        TextView currentTime;
        TextView warnImage;
    }
}
