package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Record extends AndroidModel {

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("bank_name")
    @Expose
    private String bankName;
    @SerializedName("bank_no")
    @Expose
    private String bankNo;
    @SerializedName("debit_status")
    @Expose
    private String debitStatus;
    @SerializedName("add_time")
    @Expose
    private String addTime;
    @SerializedName("remark")
    @Expose
    private Object remark;
    @SerializedName("bank_info")
    @Expose
    private String bankInfo;
    @SerializedName("class_name")
    @Expose
    private String className;
    @SerializedName("debit")
    @Expose
    private Integer debit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getDebitStatus() {
        return debitStatus;
    }

    public void setDebitStatus(String debitStatus) {
        this.debitStatus = debitStatus;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }

    public String getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(String bankInfo) {
        this.bankInfo = bankInfo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getDebit() {
        return debit;
    }

    public void setDebit(Integer debit) {
        this.debit = debit;
    }

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public Record convertFromJson(String json) {
        return convertFromJson(json, Record.class);
    }
}
