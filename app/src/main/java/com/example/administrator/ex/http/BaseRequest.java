package com.example.administrator.ex.http;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/24.
 */
public class BaseRequest extends Request<BaseResponse> {
    private Response.Listener<BaseResponse> listener;
    private Map<String,String> params;
    public BaseRequest(int method,
                       String url,
                       Map<String,String> params,
                       Response.Listener<BaseResponse> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.params =params;
    }

    @Override
    protected Response<BaseResponse> parseNetworkResponse(NetworkResponse response) {
        try {
           // String jsonString = new String(response.data,"UTF-8");

            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            Log.d("Received",  HttpHeaderParser.parseCharset(response.headers));

            BaseResponse baseResponse = parseJson(jsonString);
            return Response.success(baseResponse,HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError());
        }

    }

    @Override
    protected void deliverResponse(BaseResponse response) {
        listener.onResponse(response);

    }

    /**
     * 在这里传入要post的参数，Request会自动调用此方法
     * @return
     */
    @Override
    protected Map<String,String> getParams(){
      //  if(params!=null) {
            return params;
        //}
       // return null;
    }
    private BaseResponse parseJson(String jsonString){
        int status =0;
        String msg = null;
        String data = null;
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            status = jsonObject.getInt("status");
            msg = jsonObject.getString("msg");
            data = jsonObject.getString("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        BaseResponse response = new BaseResponse();
        response.setStatus(status);
        response.setMsg(msg);
        response.setData(data);
        return response;


    }
}
