package com.jetnix.my.simplepagesandfragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MultipleFragmentActivity extends ActionBarActivity implements AtoCcommunicator {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    BFragment fragmentResultGroup;
    AFragment fragmentChoiceGroup;
    CFragment fragmentShowResultGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_fragment);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        fragmentChoiceGroup = (AFragment) fragmentManager.findFragmentById(R.id.fragmentChoiceGroup);
        fragmentShowResultGroup = (CFragment) fragmentManager.findFragmentById(R.id.fragmentShowResultGroup);
        fragmentResultGroup = (BFragment) fragmentManager.findFragmentById(R.id.fragmentResultGroup);

        transaction.hide(fragmentShowResultGroup);
        transaction.hide(fragmentResultGroup);
        transaction.commit();

    }


    @Override
    public void sendData(boolean cat, boolean home, boolean chimpangee) {

        transaction = fragmentManager.beginTransaction();
        transaction.hide(fragmentChoiceGroup);
        transaction.show(fragmentResultGroup);
        transaction.commit();

        if(cat){
            fragmentResultGroup.changeResultData(true, false, false);
        }else if(home){
            fragmentResultGroup.changeResultData(false, true, false);
        }else if(chimpangee){
            fragmentResultGroup.changeResultData(false, false, true);
        }

    }
}
