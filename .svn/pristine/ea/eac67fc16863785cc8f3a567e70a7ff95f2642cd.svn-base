package com.cloversoft.ks.server.request;

import android.content.Context;

import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.config.Url;
import com.cloversoft.ks.data.model.api.MessageModel;
import com.cloversoft.ks.data.model.api.SpecificMsgModel;
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

public class Message {

    public static Message getDefault(){
        return new Message();
    }


    public void message(Context context, String account, String password, String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer<MessageModel>>(context) {
            @Override
            public Call<SingleTransformer<MessageModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestMessage(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new MessageResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "get_messages")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.PAGE,1)
                .addParameter(Keys.PAGES, 999)
                .execute();
    }


    public void getSpecificMessage(Context context, String account, String password, String auth,int id) {
        APIRequest apiRequest = new APIRequest<SingleTransformer<SpecificMsgModel>>(context) {
            @Override
            public Call<SingleTransformer<SpecificMsgModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestSpecificMsg(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new SpecificMessageResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "get_specific_message")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .addParameter(Keys.ID, id)
                .execute();
    }

    public interface RequestService {
        @Multipart
        @POST("{p}")
        Call<SingleTransformer<MessageModel>> requestMessage(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("{p}")
        Call<SingleTransformer<SpecificMsgModel>> requestSpecificMsg(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

    }

    public class MessageResponse extends APIResponse<SingleTransformer<MessageModel>> {
        public MessageResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class SpecificMessageResponse extends APIResponse<SingleTransformer<SpecificMsgModel>> {
        public SpecificMessageResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }
}
