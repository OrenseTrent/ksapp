package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

public class UserInfoModel  extends AndroidModel {


    @SerializedName("account")
    public String account;
    @SerializedName("balance")
    public String balance;
    @SerializedName("sign_amount")
    public String signAmount;
    @SerializedName("credits")
    public Integer credits;
    @SerializedName("credits_use")
    public Integer creditsUse;
    @SerializedName("member_vip")
    public Integer memberVip;
    @SerializedName("sign")
    public Integer sign;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public UserInfoModel convertFromJson(String json) {
        return convertFromJson(json, UserInfoModel.class);
    }

}
