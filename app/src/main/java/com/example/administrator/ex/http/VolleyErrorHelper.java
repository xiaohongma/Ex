package com.example.administrator.ex.http;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.example.administrator.ex.R;

/**
 * Created by Administrator on 2016/4/25.
 */
public class VolleyErrorHelper {
    /**
     * @param error
     * @param context
     */
    public static String getMessage(Context context,VolleyError error){
        if(error instanceof TimeoutError){
            return context.getResources().getString(R.string.server_error);
        }else if(isServerProblem(error)){
            return handleServerError(context,error);
        }else if(isNetworkProblem(error)){
            return context.getResources().getString(R.string.no_internet);
        }
      //int i =error.networkResponse.statusCode;
       // return  Integer.toString(i);
        return context.getResources().getString(R.string.network_error);
    }
    /**
     * @param error
     */
    private static boolean isNetworkProblem(VolleyError error){
        return (error instanceof NetworkError)||(error instanceof NoConnectionError);
    }
    /**
     * @param error
     */
    private static boolean isServerProblem(VolleyError error){
        return (error instanceof ServerError)||(error instanceof AuthFailureError);
    }
    /**
     * @param context
     * @param error
     */
    private static String handleServerError(Context context, VolleyError error){
        NetworkResponse response = error.networkResponse;
        if(response==null){
            switch(response.statusCode){
                case 404:
                case 422:
                case 401:

                    return context.getResources().getString(R.string.resource_error);
                case 0:
                default:
                    return context.getResources().getString(R.string.server_error);

            }
        }else {
            switch(response.statusCode){

                case 500:

                    return context.getResources().getString(R.string.resource_error);
                default:
                    return context.getResources().getString(R.string.network_error);

        }
        }
        //return context.getResources().getString(R.string.network_error);
    }
}
