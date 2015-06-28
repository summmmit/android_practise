package com.example.summmmit.fragmentflexibleui;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int i) {
        FragmentManager manager = getFragmentManager();
        FragmentB fragmentB = (FragmentB) manager.findFragmentById(R.id.fragment2);
        fragmentB.changeData(i);
    }
}
