package com.jetnix.my.calculatorapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentResult extends Fragment implements View.OnClickListener {

    TextView fragment_result_text_result;
    Button fragment_result_button_clear;

    ClearnText clearnText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        clearnText = (ClearnText) getActivity();

        fragment_result_text_result = (TextView) getActivity().findViewById(R.id.fragment_result_text_result);
        fragment_result_button_clear = (Button) getActivity().findViewById(R.id.fragment_result_button_clear);
        fragment_result_button_clear.setOnClickListener(this);

    }

    public void changeResultText(String result) {
        fragment_result_text_result.setText(result);
    }

    @Override
    public void onClick(View v) {
        fragment_result_text_result.setText("Result");
        clearnText.clear();
    }
}
