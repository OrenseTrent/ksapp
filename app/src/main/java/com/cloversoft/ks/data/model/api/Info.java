package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info extends AndroidModel {

    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("record")
    @Expose
    private List<Record> record = null;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public Info convertFromJson(String json) {
        return convertFromJson(json, Info.class);
    }
}
