package com.jetnix.my.simplepagesandfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements View.OnClickListener {

    ImageButton imageButtonCat, imageButtonHome, imageButtonChimpangee;
    AtoCcommunicator atoCcommunicator;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        atoCcommunicator = (AtoCcommunicator) getActivity();

        imageButtonCat = (ImageButton) getActivity().findViewById(R.id.fragmentAImageButtonCat);
        imageButtonHome = (ImageButton) getActivity().findViewById(R.id.fragmentAImageButtonHome);
        imageButtonChimpangee = (ImageButton) getActivity().findViewById(R.id.fragmentAImageButtonChimpangee);

        imageButtonCat.setOnClickListener(this);
        imageButtonHome.setOnClickListener(this);
        imageButtonChimpangee.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       int id = v.getId();
        Log.d("A", "hello i am here in A"+id);
        switch (id){
            case R.id.fragmentAImageButtonCat:
                atoCcommunicator.sendData(true, false, false);
                break;
            case R.id.fragmentAImageButtonHome:
                atoCcommunicator.sendData(false, true, false);
                break;
            case R.id.fragmentAImageButtonChimpangee:
                atoCcommunicator.sendData(false, false, true);
                break;

        }

    }
}
