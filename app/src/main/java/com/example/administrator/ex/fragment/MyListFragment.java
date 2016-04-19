package com.example.administrator.ex.fragment;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.ex.R;
import com.example.administrator.ex.adapter.DialogAdapter;
import com.example.administrator.ex.model.Dialog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/3.
 */
public class MyListFragment extends ListFragment {
     public int position;
    public ArrayAdapter adapter;

    public static MyListFragment newInstance(int position){

        MyListFragment listFragment= new MyListFragment();
        Bundle args = new Bundle();
        args.putInt("position",position);
        listFragment.setArguments(args);
        Log.w("FragmentList", "newInstance " + position);
        return listFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.w("FragmentList","getArugmrnts"+ getArguments().getInt("position"));

        position = getArguments().getInt("position");
        Log.w("FragmentList","onCreate uNmu "+position);
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View v;
        List<Dialog> list;
        switch(position){
            case 0:
                v = inflater.inflate(R.layout.fragment_wechat,container,false);
               //initDialog();
         list = new ArrayList<Dialog>();
                Dialog sun = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun1 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun2 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun3 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun4 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun5 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun6 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun7 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun8 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                Dialog sun9 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
                list.add(sun);
                list.add(sun1);
                list.add(sun2);
                list.add(sun3);
                list.add(sun4);
                list.add(sun5);
                list.add(sun6);
                list.add(sun7);
                list.add(sun8);
                list.add(sun9);
                setListAdapter(new DialogAdapter(getActivity(),R.layout.layout_item,list));

                break;
            case 1:
                v = inflater.inflate(R.layout.fragment_contacts,container,false);
               initDialog();

                break;
            case 2:
                v = inflater.inflate(R.layout.fragment_life,container,false);
                initContactsList();
                break;
            case 3:
                v = inflater.inflate(R.layout.fragment_my,container,false);
                break;

            default:
                v = inflater.inflate(R.layout.fragment_wechat,container,false);
                break;

        }
        Log.w("FragmentList", "Create View");

        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        Log.w("FragmentList", "onActivityCreated");
    }
    @Override
    public void onListItemClick(ListView l,View v,int position,long id) {

    }
    public void initDialog(){
        List<Dialog> list = new ArrayList<Dialog>();
        Dialog sun = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun1 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun2 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun3 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun4 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun5 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun6 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun7 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun8 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        Dialog sun9 = new Dialog(R.mipmap.ic_launcher,"纵汶静","福利","13:12","提醒");
        list.add(sun);
        list.add(sun1);
        list.add(sun2);
        list.add(sun3);
        list.add(sun4);
        list.add(sun5);
        list.add(sun6);
        list.add(sun7);
        list.add(sun8);
        list.add(sun9);
        setListAdapter(new DialogAdapter(getActivity(),R.layout.layout_item,list));

    }
    public void initContactsList(){
        List<String> array = new ArrayList<String>();
        array.add("Sun");
        array.add("Yang");
        array.add("Sun1");
        array.add("Yang1");
        array.add("Sun2");
        array.add("Yang2");
        array.add("Sun3");
        array.add("Yang3");
        array.add("Sun4");
        array.add("Yang4");
        array.add("Sun5");
        array.add("Yang5");

        setListAdapter(new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1,array));
    }
    public void initAlive(){

    }
    public void initMySettings(){

    }

}
