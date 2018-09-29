package com.tavares.tablet.model;

import java.io.Serializable;


public class Steps implements Serializable {
    private int StepID;
    private String mShortDescription;
    private String mDescription;
    private String mVideoURL;
    private String mThumbURL;
    private String name;



    public Steps(int stepID, String mShortDescription, String mDescription, String mVideoURL, String mThumbURL, String name) {
        StepID = stepID;
        this.mShortDescription = mShortDescription;
        this.mDescription = mDescription;
        this.mVideoURL = mVideoURL;
        this.mThumbURL = mThumbURL;
        this.name = name;
    }

    public Steps(String mShortDescription, String mDescription, String mVideoURL, String mThumbURL) {
        this.mShortDescription = mShortDescription;
        this.mDescription = mDescription;
        this.mVideoURL = mVideoURL;
        this.mThumbURL = mThumbURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStepID() {
        return StepID;
    }

    public String getmShortDescription() {
        return mShortDescription;
    }


    public String getmDescription() {
        return mDescription;
    }


    public String getmVideoURL() {
        return mVideoURL;
    }


    public String getmThumbURL() {
        return mThumbURL;
    }

}
