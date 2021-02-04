package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.profile.UpdateProfileFragment;
import com.cloversoft.ks.android.fragment.settings.SettingsFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class SettingsActivity extends RouteActivity {
    public static final String TAG = SettingsActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_settings;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "settings":
                openSettingsFragment();
                break;

        }
    }

    public void openSettingsFragment(){ switchFragment(SettingsFragment.newInstance()); }


}
