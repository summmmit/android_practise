package com.jetnix.my.simplepagesandfragments;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


public class VotingActivity extends ActionBarActivity implements View.OnClickListener {

    protected static Integer countCat = 0, countHome = 0, countChimpangee = 0;
    ImageButton imageButtonCat, imageButtonHome, imageButtonChimpangee;
    LinearLayout linearLayoutChoiceGroup, linearLayoutResultGroup ,linearLayoutResultShowGroup, linearLayoutResultButtonGroup;
    Button buttonShowResult;
    TextView textViewBackToVotingFromResultButton, textViewBackToVotingFromResult, textViewResultChimapangee, textViewResultHome, textViewResultCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);

        linearLayoutChoiceGroup = (LinearLayout) findViewById(R.id.choiceGroup);
        linearLayoutResultGroup = (LinearLayout) findViewById(R.id.resultGroup);
        linearLayoutResultButtonGroup = (LinearLayout) findViewById(R.id.resultButtonGroup);
        linearLayoutResultShowGroup = (LinearLayout) findViewById(R.id.resultShowGroup);

        imageButtonCat = (ImageButton) findViewById(R.id.imageButtonCat);
        imageButtonHome = (ImageButton) findViewById(R.id.imageButtonHome);
        imageButtonChimpangee = (ImageButton) findViewById(R.id.imageButtonChimpangee);

        imageButtonCat.setOnClickListener(this);
        imageButtonHome.setOnClickListener(this);
        imageButtonChimpangee.setOnClickListener(this);

        buttonShowResult = (Button) findViewById(R.id.buttonShowResult);
        buttonShowResult.setOnClickListener(this);

        textViewBackToVotingFromResultButton = (TextView) findViewById(R.id.textViewBackToVotingFromResultButton);
        textViewBackToVotingFromResult = (TextView) findViewById(R.id.textViewBackToVotingFromResult);

        textViewBackToVotingFromResult.setOnClickListener(this);
        textViewBackToVotingFromResultButton.setOnClickListener(this);


        textViewResultCat = (TextView) findViewById(R.id.textViewResultCat);
        textViewResultHome = (TextView) findViewById(R.id.textViewResultHome);
        textViewResultChimapangee = (TextView) findViewById(R.id.textViewResultChimapangee);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_voting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void increaseCatVotingCount(){
        countCat++;
    }

    private void increaseHomeVotingCount(){
        countHome++;
    }

    private void increaseChimpangeeVotingCount(){
        countChimpangee++;
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id){
            case (R.id.imageButtonCat):

                increaseCatVotingCount();

                linearLayoutChoiceGroup.setVisibility(View.GONE);
                linearLayoutResultGroup.setVisibility(View.VISIBLE);
                linearLayoutResultButtonGroup.setVisibility(View.VISIBLE);
                linearLayoutResultShowGroup.setVisibility(View.GONE);

                textViewResultCat.setText(countCat.toString() + "%");
                textViewResultHome.setText(countHome.toString() + "%");
                textViewResultChimapangee.setText(countChimpangee.toString() + "%");

                break;
            case (R.id.imageButtonHome):

                increaseHomeVotingCount();

                linearLayoutChoiceGroup.setVisibility(View.GONE);
                linearLayoutResultGroup.setVisibility(View.VISIBLE);
                linearLayoutResultButtonGroup.setVisibility(View.VISIBLE);
                linearLayoutResultShowGroup.setVisibility(View.GONE);

                textViewResultCat.setText(countCat.toString() + "%");
                textViewResultHome.setText(countHome.toString() + "%");
                textViewResultChimapangee.setText(countChimpangee.toString() + "%");

                break;
            case (R.id.imageButtonChimpangee):

                increaseChimpangeeVotingCount();

                linearLayoutChoiceGroup.setVisibility(View.GONE);
                linearLayoutResultGroup.setVisibility(View.VISIBLE);
                linearLayoutResultButtonGroup.setVisibility(View.VISIBLE);
                linearLayoutResultShowGroup.setVisibility(View.GONE);

                textViewResultCat.setText(countCat.toString() + "%");
                textViewResultHome.setText(countHome.toString() + "%");
                textViewResultChimapangee.setText(countChimpangee.toString() + "%");
                break;
            case (R.id.buttonShowResult):

                linearLayoutChoiceGroup.setVisibility(View.GONE);
                linearLayoutResultGroup.setVisibility(View.VISIBLE);
                linearLayoutResultButtonGroup.setVisibility(View.GONE);
                linearLayoutResultShowGroup.setVisibility(View.VISIBLE);

                break;
            case (R.id.textViewBackToVotingFromResult):
            case (R.id.textViewBackToVotingFromResultButton):

                Intent intent = new Intent(this, VotingActivity.class);
                startActivity(intent);
                break;
        }

    }
}
