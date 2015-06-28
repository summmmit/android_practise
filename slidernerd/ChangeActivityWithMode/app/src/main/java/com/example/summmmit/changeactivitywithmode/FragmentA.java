package com.example.summmmit.changeactivitywithmode;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    Communicator comm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_a_listView);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.chapters, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView = (ListView) getActivity().findViewById(R.id.fragment_a_listView);
    }

    public void setCommunicator(Communicator comm) {
        this.comm = comm;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        comm.respond(position);
    }

    public interface Communicator{
        public void respond(int index);
    }
}
