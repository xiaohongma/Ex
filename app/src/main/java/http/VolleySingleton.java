package http;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/4/24.
 */
public class VolleySingleton {
    private RequestQueue queue;
    private static VolleySingleton ourInstance;

    public static  synchronized VolleySingleton getInstance(Context context) {
        if(ourInstance==null){
            ourInstance = new VolleySingleton(context.getApplicationContext());
        }
        return ourInstance;
    }

    private VolleySingleton(Context context) {
        queue = Volley.newRequestQueue(context);
    }
    public RequestQueue getRequestQueue(){
        return this.queue;
    }
    public<T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }
}
