package com.company.my.splashactivity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 1084760 on 2015/06/04.
 */
public class BottomFragment extends android.support.v4.app.Fragment {

    public static TextView bottomFragmentTextTop;
    public static TextView bottomFragmentTextBottom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_fragment, container, false);

        bottomFragmentTextTop = (TextView) view.findViewById(R.id.bottom_fragment_text_top);
        bottomFragmentTextBottom = (TextView) view.findViewById(R.id.bottom_fragment_text_bottom);

        return view;
    }

    public void setTextToBottomFragment(String top, String bottom){
        bottomFragmentTextTop.setText(top);
        bottomFragmentTextBottom.setText(bottom);
    }
}
