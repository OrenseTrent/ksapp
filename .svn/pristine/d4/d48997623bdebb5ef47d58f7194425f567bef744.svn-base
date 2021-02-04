package com.cloversoft.ks.server.request;

import android.content.Context;

import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.config.Url;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.MemberInfoModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.data.model.api.UserModel;
import com.cloversoft.ks.vendor.server.request.APIRequest;
import com.cloversoft.ks.vendor.server.request.APIResponse;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


public class Auth {

    public static Auth getDefault(){
        return new Auth();
    }

    public void login(Context context, String submit_type,String account, String password, String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer<UserModel>>(context) {
            @Override
            public Call<SingleTransformer<UserModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestLogin(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new LoginResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "login")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .showDefaultProgressDialog("Logging in...")
                .execute();
    }


    public void register(Context context,String username, String password, String passwordok,String telephone, String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer>(context) {
            @Override
            public Call<SingleTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestRegister(Url.getCenterV2(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new RegisterResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "regist")
                .addParameter(Keys.USERNAME, username)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.PASSWORDOK, passwordok)
                .addParameter(Keys.TELEPHONE, telephone)
                .addParameter(Keys.AUTH, auth)
                .showDefaultProgressDialog("Registering...")
                .execute();
    }



    public void userInfo(Context context,String account, String password, String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer<UserInfoModel>>(context) {
            @Override
            public Call<SingleTransformer<UserInfoModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestUserInfo(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new HomeInfoResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "get_info")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .execute();
    }

    public void memberInfo(Context context,String account, String password, String auth) {
        APIRequest apiRequest = new APIRequest<SingleTransformer<MemberInfoModel>>(context) {
            @Override
            public Call<SingleTransformer<MemberInfoModel>> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestMember(Url.getCenter(), getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new MemberInfoResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.SUBMIT_TYPE, "get_member_info")
                .addParameter(Keys.ACCOUNT, account)
                .addParameter(Keys.PASSWORD, password)
                .addParameter(Keys.AUTH, auth)
                .execute();
    }


    public interface RequestService {
        @Multipart
        @POST("{p}")
        Call<SingleTransformer<UserModel>> requestLogin(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("{p}")
        Call<SingleTransformer<UserInfoModel>> requestUserInfo(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("{p}")
        Call<SingleTransformer<MemberInfoModel>> requestMember(@Path(value = "p", encoded = true) String p, @Part List<MultipartBody.Part> parts);

        @Multipart
        @POST("{p}")
        Call<SingleTransformer> requestRegister(@Path(value = "p", encoded =  true) String p, @Part List<MultipartBody.Part> parts);

    }


    public class LoginResponse extends APIResponse<SingleTransformer<UserModel>> {
        public LoginResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }

    public class RegisterResponse extends APIResponse<SingleTransformer>{
        public RegisterResponse(APIRequest apiRequest){
            super(apiRequest);
        }
    }

    public class HomeInfoResponse extends APIResponse<SingleTransformer<UserInfoModel>>{
        public HomeInfoResponse(APIRequest apiRequest){
            super(apiRequest);
        }
    }

    public class MemberInfoResponse extends APIResponse<SingleTransformer<MemberInfoModel>>{
        public MemberInfoResponse(APIRequest apiRequest){
            super(apiRequest);
        }
    }
}
