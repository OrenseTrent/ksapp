package com.cloversoft.ks.android.fragment.join;

import android.view.View;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.JoinActivity;
import com.cloversoft.ks.android.activity.TransactionActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;


public class JoinFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = JoinFragment.class.getName().toString();

    private JoinActivity joinActivity;


    public static JoinFragment newInstance() {
        JoinFragment fragment = new JoinFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_join;
    }

    @Override
    public void onViewReady() {
        joinActivity = (JoinActivity) getContext();
    }

    @Override
    public void onResume() {
        super.onResume();
        joinActivity.setTitle("交易记录");
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
