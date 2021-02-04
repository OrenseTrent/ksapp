package com.cloversoft.ks.server.request;

import android.content.Context;

import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.config.Url;
import com.cloversoft.ks.vendor.server.request.APIRequest;
import com.cloversoft.ks.vendor.server.request.APIResponse;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class Transfer {

    public static Transfer getDefault(){
        return new Transfer();
    }

    public void transfer(Context context, String account, String password, String auth, String amount,boolean master_acc,int gameid) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestTransfer(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new TransferResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "transfer")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.AMOUNT, amount)
                .addParameter(Keys.IS_MASTER_ACC, master_acc)
                .addParameter(Keys.GAMEID,gameid)
                .showDefaultProgressDialog("Transfer Success")
                .execute();
    }

    public interface RequestService {
        @Multipart
        @POST("{p}")
        Call<SingleTransformer> requestTransfer(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);


    }

    public class TransferResponse extends APIResponse<SingleTransformer> {
        public TransferResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }
}
