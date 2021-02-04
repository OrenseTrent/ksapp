package com.cloversoft.ks.vendor.server.transformer;

import com.cloversoft.ks.data.model.api.BankHistoryMain;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class WithdrawTransformer extends BaseTransformer{

    @SerializedName("info")
    public List<BankHistoryMain> info;

}
