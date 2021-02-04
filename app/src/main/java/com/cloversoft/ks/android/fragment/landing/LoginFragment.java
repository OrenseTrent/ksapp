package com.cloversoft.ks.android.fragment.landing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.LandingActivity;
import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.data.model.api.UserModel;
import com.cloversoft.ks.data.preference.UserData;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.android.java.ToastMessage;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;



public class LoginFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = LoginFragment.class.getName().toString();

    private LandingActivity landingActivity;
    private SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String account = "account_key";
    public static final String password = "pass_key";

    @BindView(R.id.loginTXT)                    TextView loginTXT;
    @BindView(R.id.registerTXT)                 TextView registerTXT;
    @BindView(R.id.loginUsernameET)             EditText loginUsernameET;
    @BindView(R.id.loginPasswordET)             EditText loginPasswordET;
    @BindView(R.id.loginBTN)                    TextView loginBTN;
    @BindView(R.id.shopBTN)                     TextView shopBTN;
    @BindView(R.id.usernameET)                  EditText usernameET;
    @BindView(R.id.passwordET)                  EditText passwordET;
    @BindView(R.id.confirmpassET)               EditText confirmpassET;
    @BindView(R.id.numberET)                    EditText numberET;
    @BindView(R.id.referralET)                  EditText referralET;
    @BindView(R.id.registerBTN)                 TextView registerBTN;
    @BindView(R.id.registerLayout)              View registerLayout;
    @BindView(R.id.loginLayout)                 View loginLayout;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewReady() {
        landingActivity = (LandingActivity) getContext();
        loginTXT.setOnClickListener(this);
        registerTXT.setOnClickListener(this);
        loginBTN.setOnClickListener(this);
        shopBTN.setOnClickListener(this);
        registerBTN.setOnClickListener(this);
        sharedPreferences = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onResponse(Auth.LoginResponse loginResponse){
        Log.e("Message", "ano");
        try{
            SingleTransformer<UserModel> singleTransformer = loginResponse.getData(SingleTransformer.class);
            if (singleTransformer.status == 1){
                UserData.insert(singleTransformer.info);
                ToastMessage.show(getContext(), "Login Success", ToastMessage.Status.SUCCESS);
                landingActivity.startMainActivity("home");
            } else if (singleTransformer.status == 0){
            }
        } catch(Exception e){
            ToastMessage.show(getContext(), "Verification failed", ToastMessage.Status.FAILED);

        }

    }

    @Subscribe
    public void onResponse(Auth.RegisterResponse registerResponse){
        BaseTransformer baseTransformer = registerResponse.getData(BaseTransformer.class);
        if (baseTransformer.status == 1){
            landingActivity.startMainActivity("home");
//            registerActivity.startLandingActivity("");
            ToastMessage.show(getContext(), "Register Success", ToastMessage.Status.SUCCESS);
        }else{
//            if(baseTransformer.hasRequirements()){
//                ErrorResponseManger.first(emailET, baseTransformer.errors.email);
//                ErrorResponseManger.first(passET, baseTransformer.errors.password);
//                ErrorResponseManger.first(confirmpassET, baseTransformer.errors.passwordConfirmation);
//                ErrorResponseManger.first(lnameET, baseTransformer.errors.lname);
//                ErrorResponseManger.first(fnameET, baseTransformer.errors.fname);
//                ErrorResponseManger.first(phoneET, baseTransformer.errors.contactNumber);
//            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBTN:
//                landingActivity.startMainActivity("home");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(account, loginUsernameET.getText().toString());
                editor.putString(password, loginPasswordET.getText().toString());
                editor.commit();
                Auth.getDefault().login(getContext(), Keys.SUBMIT_TYPE,loginUsernameET.getText().toString(), loginPasswordET.getText().toString(), JavaUtils.md5());
              break;
            case R.id.registerBTN:
                Auth.getDefault().register(getContext(),usernameET.getText().toString(), passwordET.getText().toString(),confirmpassET.getText().toString(),numberET.getText().toString(),JavaUtils.md5());
                break;
            case R.id.loginTXT:
                registerLayout.setVisibility(View.GONE);
                loginLayout.setVisibility(View.VISIBLE);
                registerBTN.setVisibility(View.GONE);
                loginBTN.setVisibility(View.VISIBLE);
                loginTXT.setBackgroundResource(R.drawable.circular_tv);
                registerTXT.setBackgroundResource(0);
                break;
            case R.id.registerTXT:
                loginLayout.setVisibility(View.GONE);
                registerLayout.setVisibility(View.VISIBLE);
                registerBTN.setVisibility(View.VISIBLE);
                loginBTN.setVisibility(View.GONE);
                loginTXT.setBackgroundResource(0);
                registerTXT.setBackgroundResource(R.drawable.circular_tv);
                break;


        }

    }
}
