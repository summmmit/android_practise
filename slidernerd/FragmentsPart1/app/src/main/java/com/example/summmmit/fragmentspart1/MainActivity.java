package com.example.summmmit.fragmentspart1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void respond(String data) {

        FragmentManager manager = getFragmentManager();
        FragmentB fragmentB = (FragmentB) manager.findFragmentById(R.id.fragment3);

        fragmentB.changeTextData(data);

    }
}
