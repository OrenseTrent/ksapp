package com.cloversoft.ks.data.model.api;

import com.cloversoft.ks.vendor.android.base.AndroidModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessageModel extends AndroidModel {


    @SerializedName("num")
    public Integer num;
    @SerializedName("have_read_num")
    public Integer haveReadNum;
    @SerializedName("unread_num")
    public Integer unreadNum;
    @SerializedName("record")
    public List<RecordBean> record;

    @Override
    public String toString() {
        return convertToString(this);
    }

    @Override
    public MessageModel convertFromJson(String json) {
        return convertFromJson(json, MessageModel.class);
    }


    public static class RecordBean {
        @SerializedName("id")
        public Integer idX;
        @SerializedName("message_title")
        public String messageTitle;
        @SerializedName("message_status")
        public Integer messageStatus;
        @SerializedName("add_time")
        public String addTime;
    }
}
