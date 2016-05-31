package com.example.administrator.ex.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.administrator.ex.ChatActivity;
import com.example.administrator.ex.R;
import com.example.administrator.ex.http.VolleyHttpClient;
import com.example.administrator.ex.util.Utils;

/**
 * 聊天界面
 */

public class FragmentWeChat extends Fragment implements View.OnClickListener {
    private VolleyHttpClient client;
    private RequestQueue queue;
    private View view;
    private TextView textView;
   // private int  loadingMsg =R.integer.SHOW_LOADING_DIALOG;



    public FragmentWeChat() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_wechat, container, false);
        textView =(TextView)view.findViewById(R.id.text1);
        textView.setText(Utils.logStringCache);
        Button button =(Button) view.findViewById(R.id.button1);
        button.setOnClickListener(this);
        //loadingDialog = new LoadingDialog(getActivity());
//Context c = this.getActivity();
       client  = VolleyHttpClient.getInstance(this.getActivity());
        return view;
    }
    @Override
    public void onClick(View v) {
        Intent i  = new Intent(getActivity(), ChatActivity.class);
        startActivity(i);
//        String url = "http://192.168.1.145:8080/my/test.json";
//        client.get(url,R.string.loadingMsg_load,new RequestListener() {
//            @Override
//            public void onPreRequest() {
//
//            }
//
//            @Override
//            public void onRequestSuccess(BaseResponse response) {
//                textView.setText(response.getData());
//            }
//
//            @Override
//            public void onRequestError(int code, String msg) {
//                textView.setText("RequestError");
//            }
//
//            @Override
//            public void onRequestFall(int code, String msg) {
//                textView.setText("RequestFall");
//            }
//        });
    }

}
