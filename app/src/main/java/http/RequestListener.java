package http;

/**
 * Created by Administrator on 2016/4/25.
 */
public interface RequestListener {
    /**
     * 在请求之前调用的方法
     */
    public void onPreRequest();
    /**
     * 请求成功调用
     * @param response
     */
    public void onRequestSuccess(BaseResponse response);

    /**
     * 请求失败调用，致命错误
     * @param code
     * @param  msg
     */
    public void onRequestError(int code,String msg);

    /**
     * 服务器返回失败调用
     * @param code
     * @param  msg
     */
    public void onRequestFall(int code,String msg);
}
