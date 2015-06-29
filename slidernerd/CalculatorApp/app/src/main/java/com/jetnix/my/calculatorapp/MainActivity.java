package com.jetnix.my.calculatorapp;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements Communicator, ClearnText {

    FragmentAdd fragmentAdd;
    FragmentResult fragmentResult ;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        fragmentAdd = (FragmentAdd) manager.findFragmentById(R.id.fragment);

        fragmentResult = (FragmentResult) manager.findFragmentById(R.id.fragment5);
    }


    @Override
    public void respond(String result) {
        fragmentResult.changeResultText(result);
    }

    @Override
    public void clear() {
        fragmentAdd.clearTexts();
    }
}
