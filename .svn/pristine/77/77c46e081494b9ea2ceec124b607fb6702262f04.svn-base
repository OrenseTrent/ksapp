package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class GameListModel extends AndroidModel {

    @SerializedName("image")
    public int image;

    @SerializedName("title")
    public String title;

    @SerializedName("name")
    public String name;

    @SerializedName("info")
    public String info;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public GameListModel convertFromJson(String json) {
        return convertFromJson(json, GameListModel.class);
    }



}
