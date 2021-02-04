package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.profile.UpdateProfileFragment;
import com.cloversoft.ks.android.fragment.transaction.TransactionFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class TransactionActivity extends RouteActivity {
    public static final String TAG = TransactionActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_transaction;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {


        switch (fragmentName){
            case "transaction":
                openTransactionFargment();
                break;

        }
    }

    public void openTransactionFargment(){ switchFragment(TransactionFragment.newInstance()); }


}
