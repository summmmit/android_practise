package com.example.summmmit.fragmentflexibleui;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.summmmit.fragmentflexibleui.R.id.fragment_b_text_view;

public class FragmentB extends Fragment {

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(fragment_b_text_view);
    }

    public void changeData(int i) {

        Resources resource = getResources();
        String[] description = resource.getStringArray(R.array.description);
        textView.setText(description[i]);
    }
}
