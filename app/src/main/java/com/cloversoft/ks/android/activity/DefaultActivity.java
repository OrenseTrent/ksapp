package com.cloversoft.ks.android.activity;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.DefaultFragment;
import com.cloversoft.ks.android.route.RouteActivity;



public class DefaultActivity extends RouteActivity {
    public static final String TAG = DefaultActivity.class.getName().toString();

    @Override
    public int onLayoutSet() {
        return R.layout.activity_default;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "login":

                break;
            default:
                openDefaultFragment();
                break;
        }
    }

    public void openDefaultFragment(){
        switchFragment(DefaultFragment.newInstance());
    }
}
