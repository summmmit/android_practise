package com.company.my.newfromall;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class ListsPageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_page);

        String[] movies = {"Ramji London Wale", "Dhoom", "Spider Man", "Iron Man", "Captain America"};

        ListAdapter moviesAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.activity_lists_page, movies);
        ListView movieView = (ListView) findViewById(R.id.sumitListView);

        movieView.setAdapter(moviesAdapter);

    }
}
