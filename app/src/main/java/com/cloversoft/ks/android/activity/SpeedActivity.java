package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.about.AboutFragment;
import com.cloversoft.ks.android.fragment.speed.SpeedFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class SpeedActivity extends RouteActivity {
    public static final String TAG = SpeedActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_speed;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {


        switch (fragmentName){
            case "speed":
                openSpeedFragment();
                break;

        }
    }

    public void openSpeedFragment(){ switchFragment(SpeedFragment.newInstance()); }


}
