package http;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

/**
 * Created by Administrator on 2016/4/24.
 */
public class GsonRequest<T> extends Request<T> {
    private Response.Listener<T> listener;
    private Gson gson;
    private Class<T> mClass;
    public GsonRequest(int method, Class<T> mClass,String url,Response.Listener<T> listener ,Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = listener;
        this.mClass = mClass;
        gson = new Gson();
    }
    public GsonRequest(Class<T> mClass,String url,Response.Listener<T> listener ,Response.ErrorListener errorListener) {
       this(Method.GET,mClass,url,listener,errorListener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try{
            String jsonString = new String(networkResponse.data,
                    HttpHeaderParser.parseCharset(networkResponse.headers));//转换成json字符串
            return Response.success(gson.fromJson(jsonString,mClass),HttpHeaderParser.parseCacheHeaders(networkResponse));
            //转换成需要的对象并返回
        }catch(Exception e) {
            e.printStackTrace();
            return Response.error(new ParseError());
        }
    }

    @Override
    protected void deliverResponse(T response) {
        listener.onResponse(response);

    }

}
