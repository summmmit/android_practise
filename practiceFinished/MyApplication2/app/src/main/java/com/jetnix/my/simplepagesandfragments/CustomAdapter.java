package com.jetnix.my.simplepagesandfragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by 1084760 on 2015/07/24.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String[] resource) {
        super(context, R.layout.custom_list_row, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.custom_list_row, parent, false);

        String singleResorce = getItem(position);

        TextView customAdapterTextView = (TextView) customView.findViewById(R.id.customAdapterTextView);
        ImageView customAdapterImageView = (ImageView) customView.findViewById(R.id.customAdapterImageView);

        customAdapterTextView.setText(singleResorce);
        customAdapterImageView.setImageResource(R.drawable.ic_home);

        return customView;
    }
}
