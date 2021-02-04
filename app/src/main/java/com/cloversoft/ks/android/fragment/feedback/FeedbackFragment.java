package com.cloversoft.ks.android.fragment.feedback;

import android.view.View;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.FeedbackActivity;
import com.cloversoft.ks.android.activity.JoinActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class FeedbackFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = FeedbackFragment.class.getName().toString();

    private FeedbackActivity feedbackActivity;


    public static FeedbackFragment newInstance() {
        FeedbackFragment fragment = new FeedbackFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_feedback;
    }

    @Override
    public void onViewReady() {
        feedbackActivity = (FeedbackActivity) getContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        feedbackActivity.setTitle("交易记录");
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
