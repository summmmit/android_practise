package com.jetnix.my.dialoguesoldway;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialogue(View view){

        MyAlert myAlert = new MyAlert();
        myAlert.show(getFragmentManager(), "alter_tag");
    }
}
