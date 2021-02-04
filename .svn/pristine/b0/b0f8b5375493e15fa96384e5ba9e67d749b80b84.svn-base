package com.cloversoft.ks.data.model.api;


import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;


public class NavDrawerModel extends AndroidModel {

    @SerializedName("item")
    public String item;

    public boolean is_selected = false;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public NavDrawerModel convertFromJson(String json) {
        return convertFromJson(json, NavDrawerModel.class);
    }

}