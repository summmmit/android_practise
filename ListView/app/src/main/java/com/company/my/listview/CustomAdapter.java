package com.company.my.listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 1084760 on 2015/06/08.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater sumitInflator = LayoutInflater.from(getContext());

        View customView = sumitInflator.inflate(R.layout.custom_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView sumitText = (TextView) customView.findViewById(R.id.sumitTextView);
        ImageView sumitImageView = (ImageView) customView.findViewById(R.id.sumitImageView);

        sumitText.setText(singleFoodItem);
        sumitImageView.setImageResource(R.drawable.images);

        return customView;
    }
}
