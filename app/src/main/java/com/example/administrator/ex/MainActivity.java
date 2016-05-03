package com.example.administrator.ex;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.example.administrator.ex.fragment.FragmentContacts;
import com.example.administrator.ex.fragment.FragmentLife;
import com.example.administrator.ex.fragment.FragmentMy;
import com.example.administrator.ex.fragment.FragmentWeChat;
import com.example.administrator.ex.listener.MyTabListener;
import com.example.administrator.ex.util.TabUtils;

import java.util.List;


public class MainActivity extends Activity {
    //private ViewPager pager;
    private List<ActionBar.Tab> tabs;
    private ActionBar actionBar;
    // private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, "KZ8nKXyc8AkZoV2bLKLPBgir");
       // setContentView(R.layout.activity_main);
        //  pager = (ViewPager)findViewById(R.id.pager);
        // MyFragmentAdapter myAdapter = new MyFragmentAdapter(getFragmentManag);
        // pager.setAdapter(myAdapter);
        initTabs();
       /* client.get(Request.Method.GET,"http://www.weather.com.cn/data/sk/101280101.html",12, new RequestListener() {
            @Override
            public void onPreRequest() {

            }

            @Override
            public void onRequestSuccess(BaseResponse response) {

            }

            @Override
            public void onRequestError(int code, String msg) {

            }

            @Override
            public void onRequestFall(int code, String msg) {

            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("deprecation")
    public void initTabs() {
        //  tabs = new ArrayList<ActionBar.Tab>();
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setCustomView(TabUtils.renderTabView(getApplicationContext(), R.string.actionBar_wechat, 3)).
                setTabListener(new MyTabListener<FragmentWeChat>(this, FragmentWeChat.class)));
        actionBar.addTab(actionBar.newTab().setCustomView(TabUtils.renderTabView(getApplicationContext(), R.string.actionBar_contacts, 4)).
                setTabListener(new MyTabListener<FragmentContacts>(this, FragmentContacts.class)));
        actionBar.addTab(actionBar.newTab().setCustomView(TabUtils.renderTabView(getApplicationContext(), R.string.actionBar_friends_life, 0)).
                setTabListener(new MyTabListener<FragmentLife>(this, FragmentLife.class)));
        actionBar.addTab(actionBar.newTab().setCustomView(TabUtils.renderTabView(getApplicationContext(), R.string.actionBar_my, 3)).
                setTabListener(new MyTabListener<FragmentMy>(this, FragmentMy.class)));
        // tabs.add(new MyTab("Contancts"));
        //tabs.add(new MyTab("Life"));
        //tabs.add(new MyTab("My"));
    }

    public void initActionBar() {

    }


}
