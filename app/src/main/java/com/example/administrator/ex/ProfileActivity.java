package com.example.administrator.ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.ex.http.BaseResponse;
import com.example.administrator.ex.http.RequestListener;
import com.example.administrator.ex.http.VolleyHttpClient;
import com.example.administrator.ex.model.Member;
import com.example.administrator.ex.sys.Constant;
import com.example.administrator.ex.sys.ExApplication;
import com.example.administrator.ex.util.ImageUtil;

import java.util.HashMap;
import java.util.Map;

import model.Contact;
import model.Profile;

/**
 * Created by Administrator on 2016/5/30.
 */
public class ProfileActivity extends Activity {
    private VolleyHttpClient client;
    private ImageView head;
    private TextView name;
    private TextView email;
    private TextView from;
    private TextView age;
    private TextView company;
    private Button chatButton;
    private Contact friend;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        friend = (Contact)getIntent().getSerializableExtra("friend");

        head = (ImageView)findViewById(R.id.profile_image);
        ImageUtil.displayImage(friend.getHeadSmall(),head);
        name = (TextView)findViewById(R.id.profile_name);
        name.setText(friend.getName());
        email = (TextView)findViewById(R.id.profile_email);
        email.setText(friend.getEmail());

        from = (TextView)findViewById(R.id.profile_from);
       // from.setText(profile.getCity());
        age  = (TextView)findViewById(R.id.profile_age);
      //  age.setText(profile.getAge());
       company = (TextView)findViewById(R.id.profile_company);
       // company.setText(profile.getCompany());
        chatButton = (Button)findViewById(R.id.profile_contact);
        getProfile();


    }
    private void  getProfile(){
        Map<String,String> map = new HashMap<String,String>(3);
       Member member =  ExApplication.getInstance().getLoginMember();
        map.put("loginId",member.getMemberId()+"");
        Log.d("loginId",member.getMemberId()+"");
        map.put("token",member.getToken());
        Log.d("token",member.getToken());
        map.put("friendId",friend.getContactId()+"");
        Log.d("friendId",friend.getContactId()+"");
        client = VolleyHttpClient.getInstance(this);
        client.post(Constant.API.URL_PROFILE,map,new RequestListener(){
            @Override
            public void onPreRequest() {

            }

            @Override
            public void onRequestSuccess(BaseResponse response) {

                profile = response.getObj(Profile.class);
                displayProfile(profile);
                Log.d("Profile",profile.getCity()+"");

            }

            @Override
            public void onRequestError(int code, String msg) {
                Log.d("Pro",code+msg);

            }

            @Override
            public void onRequestFall(int code, String msg) {
                Log.d("Pro",code+msg);

            }
        });

    }
    private void displayProfile(Profile profile){
        from.setText(profile.getProvince()+" "+profile.getCity());
          age.setText(profile.getAge()+"");
         company.setText(profile.getCompany());
    }
    public void onClick(View v){
        Intent i = new Intent(this,ChatActivity.class);
        i.putExtra("friend",friend);
        startActivity(i);
        finish();

    }
}
