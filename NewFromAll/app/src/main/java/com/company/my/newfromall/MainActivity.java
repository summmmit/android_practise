package com.company.my.newfromall;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

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

        switch (id) {
            case R.id.action_list_view:
                openListsPage();
                return true;
            case R.id.action_custom_list_view:
                Intent i = new Intent(getApplicationContext(), CustomListPageActivity.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void openListsPage() {
        Intent i = new Intent(getApplicationContext(), ListsPageActivity.class);
        startActivity(i);
    }
}
