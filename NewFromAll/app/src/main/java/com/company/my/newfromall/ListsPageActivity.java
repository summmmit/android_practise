package com.company.my.newfromall;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListsPageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists_page);

        String[] movies = {"Ramji London Wale", "Dhoom", "Spider Man", "Iron Man", "Captain America"};

        ListAdapter moviesAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, movies);
        ListView movieView = (ListView) findViewById(R.id.sumitListView);

        movieView.setAdapter(moviesAdapter);

        movieView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String movie = String.valueOf(parent.getItemAtPosition(position));

                        Toast.makeText(ListsPageActivity.this, movie, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
