package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BankHistoryModel extends AndroidModel {

        @SerializedName("num")
        public Integer num;
        @SerializedName("record")
        public List<RecordBean> record;

        public static class RecordBean {
            @SerializedName("id")
            public Integer idX;
            @SerializedName("amount")
            public String amount;
            @SerializedName("bank_name")
            public String bankName;
            @SerializedName("bank_no")
            public String bankNo;
            @SerializedName("debit_status")
            public String debitStatus;
            @SerializedName("add_time")
            public String addTime;
            @SerializedName("remark")
            public Object remark;
            @SerializedName("bank_info")
            public String bankInfo;
            @SerializedName("class_name")
            public String className;
            @SerializedName("debit")
            public Integer debit;
    }


}
