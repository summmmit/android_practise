package com.jetnix.my.fragmentbackstack;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements DialogueFragment.Communicator {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView2);
    }

    public void showDialogue(View view){

        FragmentManager manager = getFragmentManager();
        DialogFragment dialogFragment = new DialogueFragment();
        dialogFragment.show(manager, "dialogue_fragment");

    }

    @Override
    public void onDialogueMessage(String message) {
        textView.setText(message);
    }
}
