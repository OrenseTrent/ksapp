package com.cloversoft.ks.android.fragment.register;

import android.util.Log;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.RegisterActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;


public class SignUpFragment extends BaseFragment {
    public static final String TAG = SignUpFragment.class.getName().toString();

    private RegisterActivity registerActivity;


    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        return fragment;
    }

    @BindView(R.id.signUpBTN)                       TextView signUpBTN;

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_signup;
    }

    @Override
    public void onViewReady() {
        registerActivity = (RegisterActivity) getContext();
    }

    @OnClick(R.id.signUpBTN)
    void onClick(){
        registerActivity.startMainActivity("home");
    }

    @Override
    public void onResume() {
        super.onResume();
        registerActivity.setTitle("Sign Up");
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
//        Log.e("Message", loginResponse.getData(BaseTransformer.class).msg);
    }

}
