package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

public class MemberInfoModel extends AndroidModel {


    @SerializedName("member_name")
    public String memberName;
    @SerializedName("sex")
    public Integer sex;
    @SerializedName("email")
    public String email;
    @SerializedName("qq")
    public String qq;
    @SerializedName("phone")
    public String phone;
    @SerializedName("birthday")
    public String birthday;
    @SerializedName("wechat")
    public Object wechat;
    @SerializedName("receive_addr")
    public Object receiveAddr;
    @SerializedName("reg_time")
    public String regTime;
    @SerializedName("login_time")
    public String loginTime;
    @SerializedName("login_ip")
    public String loginIp;
    @SerializedName("balance")
    public String balance;
    @SerializedName("mobile_verify_status")
    public String mobileVerifyStatus;
    @SerializedName("is_bind_bank_card")
    public String isBindBankCard;
    @SerializedName("debit_password_status")
    public String debitPasswordStatus;
    @SerializedName("total_safe_score")
    public Integer totalSafeScore;
    @SerializedName("account")
    public String account;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public MemberInfoModel convertFromJson(String json) {
        return convertFromJson(json, MemberInfoModel.class);
    }
}
