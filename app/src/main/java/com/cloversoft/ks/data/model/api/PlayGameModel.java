package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

public class PlayGameModel extends AndroidModel {

    @SerializedName("status")
    public Integer status;
    @SerializedName("info")
    public String info;


    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public PlayGameModel convertFromJson(String json) {
        return convertFromJson(json, PlayGameModel.class);
    }

}
