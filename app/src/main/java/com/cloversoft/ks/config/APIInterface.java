package com.cloversoft.ks.config;

import com.cloversoft.ks.data.model.api.BankHistoryMain;
import com.cloversoft.ks.data.model.api.BankHistoryModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("ajax_data.php")
    Call<List<BankHistoryMain>> getBankhistory(
            @Query("type") String type, @Query("account") String account, @Query("password") String password,
            @Query("auth") String auth,@Query("page") int page, @Query("pages") int pages, @Query("record_type") int record_type

    );

}
