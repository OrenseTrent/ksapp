package com.cloversoft.ks.server.request;

import android.content.Context;

import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.config.Url;
import com.cloversoft.ks.data.model.api.PromotionModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.data.model.api.UserModel;
import com.cloversoft.ks.vendor.server.request.APIRequest;
import com.cloversoft.ks.vendor.server.request.APIResponse;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class Promotions {

    public static Promotions getDefault(){
        return new Promotions();
    }

    public void promotions(Context context, String account,String auth ) {
        APIRequest apiRequest = new APIRequest<CollectionTransformer<PromotionModel>>(context) {
            @Override
            public Call<CollectionTransformer<PromotionModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestPromotion(Url.getCenterV2(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new PromotionsResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "get_promotion")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.TYPE,"list")
                .execute();
    }

    public interface RequestService {
        @Multipart
        @POST("{p}")
        Call<CollectionTransformer<PromotionModel>> requestPromotion(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

    }

    public class PromotionsResponse extends APIResponse<CollectionTransformer<PromotionModel>> {
        public PromotionsResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }
}
