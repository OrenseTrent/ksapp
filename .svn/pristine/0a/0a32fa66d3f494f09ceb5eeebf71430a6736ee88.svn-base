package com.cloversoft.ks.android.fragment.discount;

import android.view.View;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.DiscountActivity;
import com.cloversoft.ks.android.activity.TransactionActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;


public class DiscountFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = DiscountFragment.class.getName().toString();

    private DiscountActivity discountActivity;


    public static DiscountFragment newInstance() {
        DiscountFragment fragment = new DiscountFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_discount;
    }

    @Override
    public void onViewReady() {
        discountActivity = (DiscountActivity) getContext();
    }


    @Override
    public void onResume() {
        super.onResume();
        discountActivity.setTitle("Sign Up");
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
