package com.jetnix.my.simplepagesandfragments;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class BFragment extends Fragment {

    private static Integer countCat = 0, countHome = 0, countChimpangee = 0;
    TextView textViewResultCat, textViewResultHome, textViewResultChimapangee, textViewBackToVotingFromResult;

    public BFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textViewResultCat = (TextView) getActivity().findViewById(R.id.fragmentBTextViewResultCat);
        textViewResultHome = (TextView) getActivity().findViewById(R.id.fragmentBTextViewResultHome);
        textViewResultChimapangee = (TextView) getActivity().findViewById(R.id.fragmentBTextViewResultChimapangee);
        textViewBackToVotingFromResult = (TextView) getActivity().findViewById(R.id.fragmentBTextViewBackToVotingFromResult);

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

    public void changeResultData(boolean cat, boolean home, boolean chimpangee){

        Log.d("B", "hello i am here in B");
        if(cat){
            increaseCatVotingCount();
            textViewResultCat.setText(countCat.toString());
        }else if(home){
            increaseHomeVotingCount();
            textViewResultHome.setText(countHome.toString());
        }else if(chimpangee){
            increaseChimpangeeVotingCount();
            textViewResultChimapangee.setText(countChimpangee.toString());
        }

    }


}
