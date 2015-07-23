package com.jetnix.my.simplepagesandfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {

    Button buttonShowResult;
    TextView textViewBackToVotingFromResultButton;
    public CFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        buttonShowResult = (Button) getActivity().findViewById(R.id.buttonShowResult);
        textViewBackToVotingFromResultButton = (TextView) getActivity().findViewById(R.id.textViewBackToVotingFromResultButton);


    }
}
