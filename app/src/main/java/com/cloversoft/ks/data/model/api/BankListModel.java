package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

public class BankListModel extends AndroidModel {


    @SerializedName("bank_name")
    public String bankName;
    @SerializedName("bank_no")
    public String bankNo;
    @SerializedName("bank_addr")
    public String bankAddr;
    @SerializedName("member_name")
    public String memberName;
    @SerializedName("bank_province")
    public String bankProvince;
    @SerializedName("bank_city")
    public String bankCity;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public BankListModel convertFromJson(String json) {
        return convertFromJson(json, BankListModel.class);
    }
}
