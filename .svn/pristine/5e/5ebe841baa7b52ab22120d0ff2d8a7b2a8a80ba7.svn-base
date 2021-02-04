package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;




public class UserModel extends AndroidModel {


    @SerializedName("account")
    public String account;
    @SerializedName("agent_account")
    public String agentAccount;
    @SerializedName("member_type")
    public Integer memberType;
    @SerializedName("balance")
    public String balance;


    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public UserModel convertFromJson(String json) {
        return convertFromJson(json, UserModel.class);
    }
}
