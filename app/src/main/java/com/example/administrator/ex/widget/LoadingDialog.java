package com.example.administrator.ex.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.ex.R;

/**
 * Created by Administrator on 2016/4/19.
 */
public class LoadingDialog {
    private Context context;
    private View dialogView;
    private Dialog dialog;
    private TextView text;
    public LoadingDialog(Context context){
        this.context = context;
       dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_loading,null);
        text = (TextView)dialogView.findViewById(R.id.txt_msg);
        initDialog();

    }
    private void initDialog(){
         dialog = new Dialog(context,R.style.dialog);
        dialog.setContentView(dialogView);
        dialog.setCanceledOnTouchOutside(true);
    }
    public void setMessage(CharSequence msg){
        text.setText(msg);
    }
    public void setMessage(int msg){
        text.setText(msg);
    }
    public void show(){
        if(dialog!=null){
            dialog.show();
        }
    }
    public void dismiss(){
        if(dialog.isShowing()){
            dialog.dismiss();
        }
    }
    public boolean isShowing(){
        return dialog.isShowing();
    }

}
