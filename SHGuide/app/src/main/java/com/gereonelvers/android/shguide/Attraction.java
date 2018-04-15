package com.gereonelvers.android.shguide;

/**
 * Created by Gereon on 2018-04-14.
 */

public class Attraction {
    private String mTitle;
    private String mLocation;
    private String mLocationURL;
    private String mDescription;
    private int mImageResourceId;
    private String mNumber;
    private String mWebsite;

    public Attraction(String title, String location, String description, int imageResourceId, String number, String website, String locationURL){
        mTitle = title;
        mLocation = location;
        mLocationURL = locationURL;
        mDescription = description;
        mImageResourceId = imageResourceId;
        mNumber = number;
        mWebsite = website;
    }

    public String getAttractionTitle(){
        return mTitle;
    }

    public String getAttractionLocation(){
        return mLocation;
    }

    public String getAttractionDescription(){
        return mDescription;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public String getPhoneNumber(){return mNumber;}

    public String getWebsite(){return mWebsite;}

    public String getLocationURL() {return mLocationURL;}



}
