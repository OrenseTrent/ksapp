package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.join.JoinFragment;
import com.cloversoft.ks.android.fragment.transaction.TransactionFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class JoinActivity extends RouteActivity {
    public static final String TAG = JoinActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_join;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {


        switch (fragmentName){
            case "join":
                openJoinFragment();
                break;

        }
    }

    public void openJoinFragment(){ switchFragment(JoinFragment.newInstance()); }


}
