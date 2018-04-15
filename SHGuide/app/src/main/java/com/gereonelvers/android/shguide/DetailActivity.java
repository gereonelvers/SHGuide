package com.gereonelvers.android.shguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar actionbar = findViewById(R.id.actionbar);
        final String title = getIntent().getStringExtra("title");
        final String location = getIntent().getStringExtra("location");
        final String locationURL = getIntent().getStringExtra("locationURL");
        String description = getIntent().getStringExtra("description");
        final String phoneNumber = getIntent().getStringExtra("phoneNumber");
        final String website = getIntent().getStringExtra("website");
        int imageResourceId = getIntent().getIntExtra("image", 0);
        ImageView image_iv = findViewById(R.id.image_iv);
        TextView title_tv = findViewById(R.id.title);
        TextView description_tv = findViewById(R.id.description_tv);
        LinearLayout addressBox = findViewById(R.id.address_block_ll);
        TextView addressTV = findViewById(R.id.address_tv);
        addressTV.setText(location);
        addressBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(locationURL));
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);}
            }
        });
        description_tv.setText(description);
        title_tv.setText(title);
        image_iv.setImageResource(imageResourceId);
        actionbar.setTitle(title);
        setSupportActionBar(actionbar);
        actionbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        actionbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ImageView callAction = findViewById(R.id.call_action_iv);
        final ImageView shareAction = findViewById(R.id.share_action_iv);
        final ImageView webAction = findViewById(R.id.website_action_iv);
        callAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(phoneIntent);
            }
        });
        shareAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text, title));
                startActivity(Intent.createChooser(shareIntent, getString(R.string.share_hint, title)));
            }
        });
        webAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse("http:www." + website));
                startActivity(webIntent);
            }
        });
    }
}
