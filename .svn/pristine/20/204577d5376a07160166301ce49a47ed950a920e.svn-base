package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.profile.UpdateProfileFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class DiscountActivity extends RouteActivity {
    public static final String TAG = DiscountActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_discount;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {


        switch (fragmentName){
            case "update_profile":
                openUpdateProfileFragment();
                break;

        }
    }

    public void openUpdateProfileFragment(){ switchFragment(UpdateProfileFragment.newInstance()); }


}
