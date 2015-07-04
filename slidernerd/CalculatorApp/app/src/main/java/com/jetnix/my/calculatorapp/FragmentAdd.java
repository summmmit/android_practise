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

public class FragmentAdd extends Fragment implements View.OnClickListener {

    EditText fragment_add_editText_x, fragment_add_editText_y;
    Button fragment_add_button_calculate;

    Communicator communicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        communicator = (Communicator) getActivity();

        fragment_add_editText_x = (EditText) getActivity().findViewById(R.id.fragment_add_editText_x);
        fragment_add_editText_y = (EditText) getActivity().findViewById(R.id.fragment_add_editText_y);

        fragment_add_button_calculate = (Button) getActivity().findViewById(R.id.fragment_add_button_calculate);
        fragment_add_button_calculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int x = Integer.parseInt(fragment_add_editText_x.getText().toString());
        int y = Integer.parseInt(fragment_add_editText_y.getText().toString());

        int z ;
        z = x + y;

        String result = String.valueOf(z);
        communicator.respond(result);
        //fragment_add_button_calculate.setText(result);

    }

    public void clearTexts(){
        fragment_add_editText_x.setText("");
        fragment_add_editText_y.setText("");
    }
}
