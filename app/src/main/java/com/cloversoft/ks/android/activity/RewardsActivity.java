package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.profile.UpdateProfileFragment;
import com.cloversoft.ks.android.fragment.rewards.RewardsFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class RewardsActivity extends RouteActivity {
    public static final String TAG = RewardsActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_rewards;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {


        switch (fragmentName){
            case "rewards":
                openRewardsFragment();
                break;

        }
    }

    public void openRewardsFragment(){ switchFragment(RewardsFragment.newInstance()); }


}
