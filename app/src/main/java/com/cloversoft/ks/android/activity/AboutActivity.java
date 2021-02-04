package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.about.AboutFragment;
import com.cloversoft.ks.android.fragment.join.JoinFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class AboutActivity extends RouteActivity {
    public static final String TAG = AboutActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_about;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {


        switch (fragmentName){
            case "about":
                openAboutFragment();
                break;

        }
    }

    public void openAboutFragment(){ switchFragment(AboutFragment.newInstance()); }


}
