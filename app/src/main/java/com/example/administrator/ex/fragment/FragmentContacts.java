package com.example.administrator.ex.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.administrator.ex.ProfileActivity;
import com.example.administrator.ex.R;
import com.example.administrator.ex.adapter.ContactAdapter;
import com.example.administrator.ex.http.VolleyHttpClient;
import com.example.administrator.ex.service.ContactService;

import java.util.List;

import model.Contact;
import stickylistheaders.StickyListHeadersListView;

/**
 * 联系人界面
 */
public class FragmentContacts extends Fragment{
    private VolleyHttpClient client;
    private RequestQueue queue;
    private View view;
    private TextView textView;
    private ContactAdapter adapter ;
    private StickyListHeadersListView listView;
    private List<Contact> contacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       queue = Volley.newRequestQueue(getActivity());
        contacts = ContactService.getInstance().getContactList(getActivity());

    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.fragment_contacts, null);
        listView = (StickyListHeadersListView)view.findViewById(android.R.id.list);
        contacts = ContactService.getInstance().getContactList(getActivity());
        adapter = new ContactAdapter(getActivity(),contacts);
        listView.setAdapter(adapter);
        return view;

	}
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Contact contact = contacts.get(position);
                Intent i = new Intent(getActivity(), ProfileActivity.class);
                i.putExtra("friend",contact);
                startActivity(i);

            }
        });

        //queue = Volley.newRequestQueue(getActivity());


    }
}