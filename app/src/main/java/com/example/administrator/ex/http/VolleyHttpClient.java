package com.example.administrator.ex.http;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.administrator.ex.widget.LoadingDialog;

import java.util.Map;

/**
 * Created by Administrator on 2016/4/25.
 */
public class VolleyHttpClient {

    private Context context;
    private  static VolleyHttpClient instance;
    private VolleySingleton volleySingleton;
    private LoadingDialog dialog;
    public static synchronized  VolleyHttpClient getInstance(Context context){
        if(instance==null){
            instance = new VolleyHttpClient(context);
        }
        return instance;
    }
    private VolleyHttpClient(Context context){
        this.context = context;
        volleySingleton = VolleySingleton.getInstance(context);
        dialog = new LoadingDialog(context);


    }
    public void request(int method,String url,
                        Map<String,String> params,
                        int loadingMsg,
                        final RequestListener listener){
        if(listener!=null){
            listener.onPreRequest();
        }
        showDialog();
        BaseRequest request = new BaseRequest(method,url,params,
                new Response.Listener<BaseResponse>(){
                    @Override
                    public void onResponse(BaseResponse response) {
                        dismissDialog();
                        if (listener != null) {
                            if (response.isSuccess()) {
                                listener.onRequestSuccess(response);
                            }else {
                                listener.onRequestFall(response.getStatus(), response.getMsg());
                            }

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dismissDialog();
                        Toast.makeText(context,VolleyErrorHelper.getMessage(context,error),Toast.LENGTH_LONG).show();
                        String msg =error.getMessage();

                        if(listener!=null){
                            //listener.onRequestError(error.networkResponse.statusCode,msg);
                        }


                    }
                });
        volleySingleton.addToRequestQueue(request);
    }
    public void post(){

    }
    public void get(int method,String url,int loadingMsg,
                    final RequestListener listener){
        request(Request.Method.GET,url,null,loadingMsg,listener);

    }
    public void post(int method,String url,Map<String,String> params,int loadingMsg,
                    final RequestListener listener){
        request(Request.Method.POST,url,params,loadingMsg,listener);

    }

    private void showDialog(){
        if(dialog!=null){
            dialog.show();
        }
    }
    private void dismissDialog(){
        if(dialog.isShowing()) {
            dialog.dismiss();
        }
    }


}
