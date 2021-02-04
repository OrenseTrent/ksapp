package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;


public class SampleModel extends AndroidModel {

    @SerializedName("image")
    public int image;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public SampleModel convertFromJson(String json) {
        return convertFromJson(json, SampleModel.class);
    }
}
