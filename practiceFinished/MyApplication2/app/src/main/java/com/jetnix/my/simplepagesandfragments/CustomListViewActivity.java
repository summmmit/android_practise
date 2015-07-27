package com.jetnix.my.simplepagesandfragments;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class CustomListViewActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        String[] resource = { "sumit", "shivi", "singh", "hello"};
        ListAdapter listAdapter = new CustomAdapter(this, resource);
        ListView listView = (ListView) findViewById(R.id.customListView);

        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, "Hello friends"+position, Toast.LENGTH_SHORT).show();

    }
}
