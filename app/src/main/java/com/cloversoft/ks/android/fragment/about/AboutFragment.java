package com.cloversoft.ks.android.fragment.about;

import android.view.View;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.AboutActivity;
import com.cloversoft.ks.android.activity.JoinActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.widget.WrapContentWebView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;


public class AboutFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = AboutFragment.class.getName().toString();

    private AboutActivity aboutActivity;

    @BindView(R.id.aboutUsTXT)          WrapContentWebView aboutUsTXT;


    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_about;
    }

    @Override
    public void onViewReady() {
        aboutActivity = (AboutActivity) getContext();
        aboutUsTXT.loadDataWithBaseURL(null, getString(R.string.about_us), "text/html", "utf-8", null);
    }

    @Override
    public void onResume() {
        super.onResume();
        aboutActivity.setTitle("交易记录");
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
