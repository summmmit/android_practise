package com.example.jetnixx.volleydependency.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jetnixx.volleydependency.R;

/**
 * Created by 1084760 on 2015/11/30.
 */
public class CustomAdapterListView extends ArrayAdapter<String> {

    private final Context context;
    private final String[] resource;

    public CustomAdapterListView(Context context, String[] resource) {
        super(context, -1, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.listview_custom_adapter_format, parent, false);

        String resourceItem = getItem(position);

        TextView textView = (TextView) customView.findViewById(R.id.name);
        ImageView imageView = (ImageView) customView.findViewById(R.id.icon);

        textView.setText(resourceItem);
        imageView.setImageResource(R.drawable.php);

        return customView;
    }
}
