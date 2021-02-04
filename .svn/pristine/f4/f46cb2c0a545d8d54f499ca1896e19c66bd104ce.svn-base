package com.cloversoft.ks.android.fragment.speed;

import android.view.View;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.JoinActivity;
import com.cloversoft.ks.android.activity.SpeedActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class SpeedFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = SpeedFragment.class.getName().toString();

    private SpeedActivity speedActivity;


    public static SpeedFragment newInstance() {
        SpeedFragment fragment = new SpeedFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_speed;
    }

    @Override
    public void onViewReady() {
        speedActivity = (SpeedActivity) getContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        speedActivity.setTitle("交易记录");
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

    @Override
    public void onClick(View v) {

    }
}
