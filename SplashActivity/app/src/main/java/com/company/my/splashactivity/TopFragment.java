package com.company.my.splashactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 1084760 on 2015/06/04.
 */
public class TopFragment extends Fragment {

    public static EditText topFragmentTextTop;
    public static EditText topFragmentTextBottom;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top, String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander = (TopSectionListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_fragment, container, false);

        topFragmentTextTop = (EditText) view.findViewById(R.id.top_fragment_text_top);
        topFragmentTextBottom = (EditText) view.findViewById(R.id.top_fragment_text_bottom);

        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        buttonClicked(v);
                    }
                }
        );
        return view;
    }

    public void buttonClicked(View view){
        activityCommander.createMeme(topFragmentTextTop.getText().toString(), topFragmentTextBottom.getText().toString());
    }
}
