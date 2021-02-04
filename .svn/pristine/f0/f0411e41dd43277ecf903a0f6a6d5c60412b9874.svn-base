package com.cloversoft.ks.android.fragment;

import android.util.Log;

import com.cloversoft.ks.R;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;



public class DefaultFragment extends BaseFragment {
    public static final String TAG = DefaultFragment.class.getName().toString();

    public static DefaultFragment newInstance() {
        DefaultFragment fragment = new DefaultFragment();
        return fragment;
    }

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_default;
    }

    @Override
    public void onViewReady() {

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
