package com.cloversoft.ks.server.request;

import android.content.Context;

import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.config.Url;
import com.cloversoft.ks.data.model.api.BankHistoryMain;
import com.cloversoft.ks.data.model.api.BankHistoryModel;
import com.cloversoft.ks.data.model.api.BankListModel;
import com.cloversoft.ks.vendor.server.request.APIRequest;
import com.cloversoft.ks.vendor.server.request.APIResponse;
import com.cloversoft.ks.vendor.server.request.PaybillsAPIRequest;
import com.cloversoft.ks.vendor.server.request.PaybillsAPIResponse;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;
import com.cloversoft.ks.vendor.server.transformer.WithdrawTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class Bank {

    public static Bank getDefault(){
        return new Bank();
    }

    public void bankList(Context context, String account, String password, String auth) {
        APIRequest apiRequest = new APIRequest<CollectionTransformer<BankListModel>>(context) {
            @Override
            public Call<CollectionTransformer<BankListModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestBankList(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new BankListResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE, "bank_list")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .execute();
    }

    public void withdraw(Context context, String account, String password, String auth,String amount, int debit_bank, boolean money_pwd) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestWithdraw(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new WithdrawResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "debit")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.AMOUNT, amount)
                .addParameter(Keys.DEBIT_BANK,debit_bank)
                .addParameter(Keys.MONEY_PWD, money_pwd)
                .execute();
    }
    public void historyList(Context context, String account, String password, String auth) {
        APIRequest apiRequest = new APIRequest(context) {
            @Override
            public Call<SingleTransformer<BankHistoryModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestHistory(Url.getAjax(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new HistoryResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.TYPE ,"record_list")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.PAGE, 1)
                .addParameter(Keys.PAGES, 999)
                .addParameter(Keys.RECORD_TYPE, 1002)
                .execute();
    }


    public interface RequestService {
        @Multipart
        @POST("{p}")
        Call<CollectionTransformer<BankListModel>> requestBankList(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("{p}")
        Call<SingleTransformer> requestWithdraw(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("{p}")
        Call<SingleTransformer<BankHistoryModel>> requestHistory(@Path(value = "p", encoded = true) String p, @Part java.util.List<MultipartBody.Part> part);

    }

    public class BankListResponse extends APIResponse<CollectionTransformer<BankListModel>> {
        public BankListResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class WithdrawResponse extends APIResponse<SingleTransformer> {
        public WithdrawResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class HistoryResponse extends APIResponse<SingleTransformer<BankHistoryModel>> {
        public HistoryResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

}
