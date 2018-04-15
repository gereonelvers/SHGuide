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


public class EntertainmentFragment extends Fragment {

    public EntertainmentFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(getString(R.string.entertainment_item1_name), getString(R.string.entertainment_item1_address),getString(R.string.entertainment_item1_description) ,R.drawable.entertainmentitem1, getString(R.string.entertainment_item1_number), getString(R.string.entertainment_item1_website), getString(R.string.entertainment_item1_locationURL)));
        attractions.add(new Attraction(getString(R.string.entertainment_item2_name), getString(R.string.entertainment_item2_address),getString(R.string.entertainment_item2_description) ,R.drawable.entertainmentitem2, getString(R.string.entertainment_item2_number), getString(R.string.entertainment_item2_website), getString(R.string.entertainment_item2_locationURL)));
        attractions.add(new Attraction(getString(R.string.entertainment_item3_name), getString(R.string.entertainment_item3_address),getString(R.string.entertainment_item3_description) ,R.drawable.entertainment3, getString(R.string.entertainment_item3_number), getString(R.string.entertainment_item3_website), getString(R.string.entertainment_item3_locationURL)));
        attractions.add(new Attraction(getString(R.string.entertainment_item4_name), getString(R.string.entertainment_item4_address),getString(R.string.entertainment_item4_description) ,R.drawable.entertainmentitem4, getString(R.string.entertainment_item4_number), getString(R.string.entertainment_item4_website), getString(R.string.entertainment_item4_locationURL)));

        AttractionAdapter attraction_adapter = new AttractionAdapter(getActivity(), attractions);

        ListView listView = rootView.findViewById(R.id.attraction_list);
        listView.setDivider(null);
        listView.setAdapter(attraction_adapter);
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