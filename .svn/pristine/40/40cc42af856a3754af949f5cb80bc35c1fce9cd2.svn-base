package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.profile.UpdateProfileFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class ProfileActivity extends RouteActivity {
    public static final String TAG = ProfileActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_profile;
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
