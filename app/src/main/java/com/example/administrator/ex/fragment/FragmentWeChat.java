package com.example.administrator.ex.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.administrator.ex.BaseFragment;
import com.example.administrator.ex.R;
import com.example.administrator.ex.util.Utils;
import com.example.administrator.ex.widget.LoadingDialog;

import com.example.administrator.ex.http.BaseResponse;
import com.example.administrator.ex.http.RequestListener;
import com.example.administrator.ex.http.VolleyHttpClient;


public class FragmentWeChat extends BaseFragment implements View.OnClickListener {
    private RequestQueue queue;
    private View view;
    private TextView textView;
    private LoadingDialog loadingDialog;



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
        loadingDialog = new LoadingDialog(getActivity());
       client  = VolleyHttpClient.getInstance(getActivity());
        return view;
    }
    /*private Request getRequest(){
       // String url = "http://192.168.1.145:8080//my/test.json";
       // String url = "http://www.weather.com.cn/data/sk/101280101.html";
        Request request = new JsonObjectRequest(url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonArray) {
                String response = jsonArray.toString();
                textView.setText(response);
                loadingDialog.dismiss();

            }
        },
                  new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        loadingDialog.dismiss();
                        textView.setText("Error");
                    }
                });
      /*  StringRequest request = new StringRequest(url,new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
                Log.d("FragmentWeChat", response);
                textView.setText(response);
                loadingDialog.dismiss();

            }
        },
        new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                loadingDialog.dismiss();
                textView.setText("Error");
            }
        });*/
      /* return request;
    }*/


    @Override
    public void onClick(View v) {
        String url = "http://192.168.1.145:8080//my/test.json";
        //String url = "http://www.weather.com.cn/data/sk/101280101.html";
       /*loadingDialog.setMessage("正在缓冲");
        loadingDialog.show();
        queue.add(getRequest());*/
        client.get(Request.Method.GET,url,11,new RequestListener() {
            @Override
            public void onPreRequest() {

            }

            @Override
            public void onRequestSuccess(BaseResponse response) {
                textView.setText(response.getData());
            }

            @Override
            public void onRequestError(int code, String msg) {
                textView.setText("RequestError");
            }

            @Override
            public void onRequestFall(int code, String msg) {
                textView.setText("RequestFall");
            }
        });
    }
}
