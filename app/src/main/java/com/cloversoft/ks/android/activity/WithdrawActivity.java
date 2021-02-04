package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.transfer.TransferFragment;
import com.cloversoft.ks.android.fragment.withdraw.WithdrawFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class WithdrawActivity extends RouteActivity {
    public static final String TAG = WithdrawActivity.class.getName().toString();

    @Override
    public int onLayoutSet() {
        return R.layout.activity_transfer;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "withdraw":
                openWithdrawFragment();
                break;

        }
    }

    public void openWithdrawFragment(){ switchFragment(WithdrawFragment.newInstance()); }


}
