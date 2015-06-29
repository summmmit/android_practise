package com.jetnix.my.calculatorapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentDevide extends Fragment implements View.OnClickListener {

    EditText fragment_dev_editText_x, fragment_dev_editText_y;
    Button fragment_dev_button_calculate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devide, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fragment_dev_editText_x = (EditText) getActivity().findViewById(R.id.fragment_dev_editText_x);
        fragment_dev_editText_y = (EditText) getActivity().findViewById(R.id.fragment_dev_editText_y);

        fragment_dev_button_calculate = (Button) getActivity().findViewById(R.id.fragment_dev_button_calculate);
        fragment_dev_button_calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
    }
}
