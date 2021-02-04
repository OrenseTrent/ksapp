package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BankHistoryMain extends AndroidModel {

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public BankHistoryMain convertFromJson(String json) {
        return convertFromJson(json, BankHistoryMain.class);
    }

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("info")
    @Expose
    private Info info;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
