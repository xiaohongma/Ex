package com.example.administrator.ex.sys;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Constant {
  //  public static final  String  ID = "id";
    public static final String NAME ="name";
    public static final String EMAIL ="email";
    public static final String TOKEN ="token";
    public static final String HEAD_ID ="head_id";
    public static final String HEAD_SMALL ="head_small";
    public static final String HEAD_BIG ="head_big";
    public static final String BD_CHANNEL_ID ="channel_id";
    public static final String BD_USER_ID = "user_id";
    public static final String PREFERENCES_NAME ="exchange";


    public static final String DB_NAME ="exchange";
    public static final String IS_DATA_INIT ="isDataInit";
    public static final String MEMBER = "member";
    public static final String MEMBER_ID ="member_id";
    public static final String API_KEY ="api_key";

    public static class API{

        public static final String URL_BASE = "http://192.168.1.101:8080/my/";
        public static final String URL_STATE =URL_BASE+"test2.jsp";
        public static final String URL_BASE2 = "http://192.168.1.101:8080/exchange/";
        public static final String URL_LOGIN =URL_BASE2 +"login";
        public static final String URL_LOGIN_TOKEN = URL_BASE2+"token";
        public static final String URL_FRIENDS = URL_BASE2+"friends";
        public static final String URL_PROFILE =URL_BASE2+"profile" ;
        public static final String URL_CHAT_SEND =URL_BASE2+"chat/send" ;
      //  Base64.encode(new Byte[]());

    }

}
