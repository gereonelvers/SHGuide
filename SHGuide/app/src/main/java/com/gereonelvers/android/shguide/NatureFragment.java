package com.gereonelvers.android.shguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class NatureFragment extends Fragment {

    public NatureFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);


        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.nature_item1_name), getString(R.string.nature_item1_address),getString(R.string.nature_item1_description) ,R.drawable.natureitem1, getString(R.string.nature_item1_number), getString(R.string.nature_item1_website), getString(R.string.nature_item1_locationURL)));
        attractions.add(new Attraction(getString(R.string.nature_item2_name), getString(R.string.nature_item2_address),getString(R.string.nature_item2_description) ,R.drawable.natureitem2, getString(R.string.nature_item2_number), getString(R.string.nature_item2_website), getString(R.string.nature_item2_locationURL)));
        attractions.add(new Attraction(getString(R.string.nature_item3_name), getString(R.string.nature_item3_address),getString(R.string.nature_item3_description) ,R.drawable.natureitem3, getString(R.string.nature_item3_number), getString(R.string.nature_item3_website), getString(R.string.nature_item3_locationURL)));
        attractions.add(new Attraction(getString(R.string.nature_item4_name), getString(R.string.nature_item4_address),getString(R.string.nature_item4_description) ,R.drawable.natureitem4, getString(R.string.nature_item4_number), getString(R.string.nature_item4_website), getString(R.string.nature_item4_locationURL)));
        final AttractionAdapter attraction_adapter = new AttractionAdapter(getActivity(), attractions);
        ListView listView = rootView.findViewById(R.id.attraction_list);
        listView.setAdapter(attraction_adapter);
        listView.setDivider(null);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction currentAttraction = attractions.get(position);
                Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
                detailIntent.putExtra("title", currentAttraction.getAttractionTitle());
                detailIntent.putExtra("location", currentAttraction.getAttractionLocation());
                detailIntent.putExtra("description", currentAttraction.getAttractionDescription());
                detailIntent.putExtra("image", currentAttraction.getImageResourceId());
                detailIntent.putExtra("phoneNumber", currentAttraction.getPhoneNumber());
                detailIntent.putExtra("website", currentAttraction.getWebsite());
                detailIntent.putExtra("locationURL", currentAttraction.getLocationURL());
                startActivity(detailIntent);
            }
        });
        return rootView;
    }
}