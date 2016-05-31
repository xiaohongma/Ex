package com.example.administrator.ex;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.ex.fragment.FragmentContacts;
import com.example.administrator.ex.fragment.FragmentLife;
import com.example.administrator.ex.fragment.FragmentMy;
import com.example.administrator.ex.fragment.FragmentWeChat;
import com.example.administrator.ex.listener.MyTabListener;
import com.example.administrator.ex.util.TabUtils;

import java.util.List;

/**
 * 主界面，类似微信界面
 */

public class MainActivity extends Activity {
    public static MainActivity mainAcitvity;
    //private ViewPager pager;
    private List<ActionBar.Tab> tabs;
    private ActionBar actionBar;
    // private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainAcitvity =this;
        initTabs();

        //startService(new Intent(this,DataInitService.class));

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
        if (actionBar != null) actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
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
