package com.jetnix.my.fragmentbackstack;

import android.app.Activity;
import android.app.DialogFragment;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DialogueFragment extends DialogFragment implements View.OnClickListener {

    Button no, yes;
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        communicator = (Communicator) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialogue, null);

        no = (Button) view.findViewById(R.id.dialogue_no);
        yes = (Button) view.findViewById(R.id.dialogue_yes);
        setCancelable(false);


        no.setOnClickListener(this);
        yes.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.dialogue_no){
            dismiss();
            communicator.onDialogueMessage("No Was CLicked");
        }else if(v.getId() == R.id.dialogue_yes){
            dismiss();
            communicator.onDialogueMessage("Yes Was CLicked");
        }

    }

    interface Communicator{
        public void onDialogueMessage(String message);
    }
}
