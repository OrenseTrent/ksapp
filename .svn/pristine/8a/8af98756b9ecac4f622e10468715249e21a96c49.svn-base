package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

public class SpecificMsgModel extends AndroidModel {


    @SerializedName("message_title")
    public String messageTitle;
    @SerializedName("add_time")
    public String addTime;
    @SerializedName("message_content")
    public String messageContent;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public SpecificMsgModel convertFromJson(String json) {
        return convertFromJson(json, SpecificMsgModel.class);
    }
}
