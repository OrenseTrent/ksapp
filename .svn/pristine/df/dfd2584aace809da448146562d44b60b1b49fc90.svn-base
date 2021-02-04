package com.cloversoft.ks.android.fragment.transaction;

import android.view.View;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.RegisterActivity;
import com.cloversoft.ks.android.activity.TransactionActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;


public class TransactionFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = TransactionFragment.class.getName().toString();

    private TransactionActivity transactionActivity;


    public static TransactionFragment newInstance() {
        TransactionFragment fragment = new TransactionFragment();
        return fragment;
    }

    @BindView(R.id.depositBTN)                      View depositBTN;
    @BindView(R.id.withdrawBTN)                     View withdrawBTN;
    @BindView(R.id.transferBTN)                     View transferBTN;
    @BindView(R.id.promoBTN)                        View promoBTN;

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_transaction;
    }

    @Override
    public void onViewReady() {
        transactionActivity = (TransactionActivity) getContext();
        depositBTN.setOnClickListener(this);
        withdrawBTN.setOnClickListener(this);
        transferBTN.setOnClickListener(this);
        promoBTN.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        transactionActivity.setTitle("交易记录");
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
