package com.example.summmmit.fragmentspart1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentB extends Fragment {

    TextView fragment_b_textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        fragment_b_textView = (TextView) getActivity().findViewById(R.id.fragment_b_textView);
    }

    public void changeTextData(String data){
        fragment_b_textView.setText(data);
    }
}
