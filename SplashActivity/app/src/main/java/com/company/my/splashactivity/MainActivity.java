package com.company.my.splashactivity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements TopFragment.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_click_events:
                clickeventsActivity();
                return true;
            case R.id.action_fragments:
                fragmentsActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fragmentsActivity() {
        Intent intent = new Intent(MainActivity.this, FragmentsActivity.class);
        startActivity(intent);
    }

    private void clickeventsActivity() {
        Intent intent = new Intent(MainActivity.this, ClickEventsActivity.class);
        startActivity(intent);
    }

    @Override
    public void createMeme(String top, String bottom) {
        BottomFragment bottomFragment = (BottomFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setTextToBottomFragment(top, bottom);
    }
}
