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
   // private static boolean showDialog=false;

    private Context context;
    private  static VolleyHttpClient instance;
    private VolleySingleton volleySingleton;
    private  LoadingDialog dialog;
    public static synchronized  VolleyHttpClient getInstance(Context context){
//        if(loadingMsg==R.integer.SHOW_LOADING_DIALOG){
//            showDialog =true;
//        }

        if(instance==null){

            instance = new VolleyHttpClient(context);
        }//加上这个判断是因为Dialog依存于Activity，而如果刚开始创建的单例的context是Application，
        // 后面再显示对话框的话就会发生错误。所以在这里将Dialog的Context重新赋值。
//        else if(showDialog){
//            dialog = new LoadingDialog(context);
//        }
        return instance;
    }
    private VolleyHttpClient(Context context){
        this.context = context;
        volleySingleton = VolleySingleton.getInstance(context);

       dialog = new LoadingDialog(context);



    }
    public void request(int method,String url,
                        Map<String,String> params,
                        final RequestListener listener){
        if(listener!=null){
            listener.onPreRequest();
        }
//        if(showDialog){
//            showDialog();
//        }
        //showDialog();
        BaseRequest request = new BaseRequest(method,url,params,
                new Response.Listener<BaseResponse>(){
                    @Override
                    public void onResponse(BaseResponse response) {
                       // dismissDialog();
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
                      //  dismissDialog();
                        Toast.makeText(context,VolleyErrorHelper.getMessage(context,error),Toast.LENGTH_LONG).show();
                        String msg =error.getMessage();

                        if(listener!=null){
                            //listener.onRequestError(error.networkResponse.statusCode,msg);
                        }


                    }
                });
        volleySingleton.addToRequestQueue(request);
    }
    public void request(int method,String url,int loadingMsg,
                        Map<String,String> params,
                        final RequestListener listener){
        if(listener!=null){
            listener.onPreRequest();
        }
//        if(showDialog){
//            showDialog();
//        }
        showDialog(loadingMsg);
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
//    public void post(){
//
//    }
    public void get( String url,int loadingMsg,
                    final RequestListener listener){
        request(Request.Method.GET, url,loadingMsg,null,listener);

    }
    public void post(String url,int loadingMsg,Map<String,String> params,
                    final RequestListener listener){
        request(Request.Method.POST,url,loadingMsg,params,listener);

    }
    public void post(String url,Map<String,String> params,
                     final RequestListener listener){
        request(Request.Method.POST,url,params,listener);

    }

    private void showDialog(int loadingMsg){
        if(dialog!=null){
            dialog.setMessage(context.getString(loadingMsg));
            dialog.show();
        }
    }
    private void dismissDialog(){
        if(dialog.isShowing()) {

            dialog.dismiss();
        }
    }


}
