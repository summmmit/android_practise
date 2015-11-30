package com.example.jetnixx.volleydependency.ListView;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.jetnixx.volleydependency.R;

public class CustomAdapterListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_list_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListAdapter adapter = new CustomAdapterListView(this, getResources().getStringArray(R.array.mobileArray));
        ListView listView = (ListView) findViewById(R.id.customListView);

        listView.setAdapter(adapter);
    }

}
