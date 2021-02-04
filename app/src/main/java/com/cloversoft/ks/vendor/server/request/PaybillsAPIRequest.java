package com.cloversoft.ks.vendor.server.request;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.cloversoft.ks.R;
import com.cloversoft.ks.config.Url;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PaybillsAPIRequest<List> implements Callback<List> {

    private final String DEVICE_PLATFORM = "android";

    private Context context;
    private java.util.List<MultipartBody.Part> multipartBody;
    private HashMap<String, String> params;
    private Retrofit retrofit;
    private Retrofit retrofit2;
    private ProgressDialog progressDialog;
    private SwipeRefreshLayout swipeRefreshLayout;

    private int page = 1;
    private int perPage = 5;
    private boolean hasMorePage = false;
    private boolean showNoInternetConnection = true;
    private String authorization = "xxxxxx";
    private String authorization2 = "Z2FiYXlndXJvOkFOTUIxRGpRb09pZlJvajQ4NWV1M1kxbFFHbk9EY1F0bUxiUkN1Zl9xNng3Vno0bE9BMUJRR0dOVnc2RUFoUWwtSUNaTXVIZ29fQ2YxeEl3aW1LZnRyYw==";
    private String RequestRef = "9da16957-020d-41c6-873a-763e2f8c31ce";
    private DataResponseType dataResponseType = DataResponseType.DEFAULT;
    public boolean checkToken = true;
    public boolean isCanceled = false;

    public enum DataResponseType {
        DEFAULT,
        NEXT,
        PREV,
        FIRST
    }

    public PaybillsAPIRequest(Context context){
        this.context = context;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .addHeader("Content-Type", "application/json").build();
                        return chain.proceed(request);
                    }
                })
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Url.APP)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }


    public PaybillsAPIRequest addParameter(String key, Object object) {

        if (multipartBody == null) {
            multipartBody = new ArrayList<>();
        }

        if(object instanceof File){
            File file = (File) object;
            multipartBody.add(MultipartBody.Part.createFormData(key, file.getName(), RequestBody.create(MediaType.parse("image/*"), file)));
        }else{
            multipartBody.add(MultipartBody.Part.createFormData(key, String.valueOf(object)));
        }

        if (params == null) {
            params = new HashMap<>();
        }

        params.put(key, String.valueOf(object));
        return this;
    }

    public Call<List> onCreateCall() {

        return null;
    }

    public interface Service{

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Retrofit getRetrofit2() {
        return retrofit2;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getAuthorization2(){
        return authorization2;
    }

    public String getRequestRef(){
        return RequestRef;
    }



    public String getDeviceName() {
        return DEVICE_PLATFORM;
    }

    public String getDeviceModel() {
        String deviceName = Build.MODEL;
        return deviceName;
    }

    public String getDeviceBrand() {
        String deviceManufacturer = Build.MANUFACTURER; // returns manufacturer
        return deviceManufacturer;
    }


    public String getDeviceID() {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getAndroidVersion() {
        String versionName = "";

        try {
            versionName = String.valueOf(Build.VERSION.RELEASE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    public DataResponseType getDataResponseType() {
        return dataResponseType;
    }

    public java.util.List<MultipartBody.Part> getMultipartBody(){
        if (multipartBody == null) {
            multipartBody = new ArrayList<>();
        }

        java.util.List<MultipartBody.Part> parts = multipartBody;



        return parts;
    }

    public HashMap<String, String> getParameter(){
        if (params == null) {
            params = new HashMap<>();
        }

        HashMap<String, String> parts = params;


        return parts;
    }

    public PaybillsAPIRequest addAuthorization(String authorization) {
        this.authorization = "Bearer " + authorization;
        return this;
    }


    public PaybillsAPIRequest addVersionAuth(String authorization) {
        this.authorization = authorization;
        return this;
    }

    public void onResponse(){

    }

    public void broadcast(Object event){
        EventBus.getDefault().post(event);
    }

    /** for pagination */
    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public PaybillsAPIRequest setPage(int page) {
        this.page = page;
        return this;
    }

    public PaybillsAPIRequest setPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    private void setDataResponseType(DataResponseType dataResponseType) {
        this.dataResponseType = dataResponseType;
    }


    public PaybillsAPIRequest setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
        return this;
    }

    public PaybillsAPIRequest showDefaultProgressDialog(String message) {
        this.progressDialog = new ProgressDialog(context).show(context, "", message, false, false);
        return this;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public PaybillsAPIRequest setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
        return this;
    }

    public PaybillsAPIRequest showSwipeRefreshLayout(boolean b) {
        if (getSwipeRefreshLayout() != null) {
            getSwipeRefreshLayout().setRefreshing(b);
        }
        return this;
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return swipeRefreshLayout;
    }


    /** Commands */
    public void execute() {
        setDataResponseType(DataResponseType.DEFAULT);
        run();
    }

    public void nextPage() {
        setDataResponseType(DataResponseType.NEXT);
//        if (hasMorePage) {
//            setPage(getPage() + 1);
//        }
        run();
    }

    public void previousPage() {
        setDataResponseType(DataResponseType.PREV);
        if (getPage() > 1) {
            setPage(getPage() - 1);
        }
        run();
    }

    public void first() {
        setDataResponseType(DataResponseType.FIRST);
        setPage(1);
        run();
    }

    public void run() {
        isCanceled = false;
        onCreateCall().enqueue(this);
    }

    public void cancelRequest() {
        isCanceled = true;
        onCreateCall().cancel();
    }

    @Override
    public void onResponse(Call<List> call, Response<List> response) {
//        Log.e("APIRequest", response.code());
//        Log.e("APIRequest","URL: "+response.raw().request().url());
//        Log.e("APIRequest","BODY: " + response.raw().toString());

        dismissLoading();
        if(!isCanceled){
            this.response = response;
            onResponse();
        }
    }

    private Response<List> response;
    public Response<List> getResponse(){
        return response;
    }

    @Override
    public void onFailure(Call<List> call, Throwable t) {
        dismissLoading();
        if(!isCanceled){
            onResponse();
        }
    }

    private void dismissLoading(){
        if (getProgressDialog() != null) {
            getProgressDialog().dismiss();
        }
        if (getSwipeRefreshLayout() != null) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    public class OnFailedResponse{

    }
}

