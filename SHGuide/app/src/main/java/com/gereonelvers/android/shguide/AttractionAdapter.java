package com.gereonelvers.android.shguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gereon on 2018-04-14.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(Context context, ArrayList<Attraction> attractions){
        super(context, 0, attractions);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Attraction currentAttraction = getItem(position);
        TextView title = listItemView.findViewById(R.id.title_tv);
        TextView location = listItemView.findViewById(R.id.location_tv);
        ImageView image = listItemView.findViewById(R.id.image_iv);
        title.setText(currentAttraction.getAttractionTitle());
        location.setText(currentAttraction.getAttractionLocation());
        image.setImageResource(currentAttraction.getImageResourceId());
        return listItemView;
    }
}

