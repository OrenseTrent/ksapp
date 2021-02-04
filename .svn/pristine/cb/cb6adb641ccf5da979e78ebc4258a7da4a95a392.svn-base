package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

public class PromotionModel extends AndroidModel {

    @SerializedName("title")
    public String title;
    @SerializedName("pro_type")
    public String proType;
    @SerializedName("promotions_content")
    public String promotionsContent;
    @SerializedName("promotions_show_status")
    public String promotionsShowStatus;
    @SerializedName("imgUrl")
    public String imgUrl;
    @SerializedName("smlIco")
    public String smlIco;
    @SerializedName("leftTime")
    public String leftTime;
    @SerializedName("contentUrl")
    public String contentUrl;
    @SerializedName("end_time")
    public String endTime;
    @SerializedName("start_time")
    public String startTime;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public PromotionModel convertFromJson(String json) {
        return convertFromJson(json, PromotionModel.class);
    }
}
