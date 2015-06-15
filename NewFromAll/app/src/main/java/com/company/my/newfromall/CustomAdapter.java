package com.company.my.newfromall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 1084760 on 2015/06/09.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String[] movies) {
        super(context, R.layout.custom_row, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater movieInflator = LayoutInflater.from(getContext());

        View movieView = movieInflator.inflate(R.layout.custom_row, parent, false);

        String singleMovieItem = getItem(position);
        TextView customTextView = (TextView) movieView.findViewById(R.id.customTextView);
        ImageView customImageView = (ImageView) movieView.findViewById(R.id.customImageView);

        customTextView.setText(singleMovieItem);
        customImageView.setImageResource(R.drawable.image1);

        return movieView;
    }
}
