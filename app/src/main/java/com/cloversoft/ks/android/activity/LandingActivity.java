package com.cloversoft.ks.android.activity;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.landing.LoginFragment;
import com.cloversoft.ks.android.fragment.landing.SplashFragment;
import com.cloversoft.ks.android.fragment.register.SignUpFragment;
import com.cloversoft.ks.android.route.RouteActivity;



public class LandingActivity extends RouteActivity {
    public static final String TAG = LandingActivity.class.getName().toString();

    @Override
    public int onLayoutSet() {
        return R.layout.activity_landing;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "login":
                openLoginFragment();
                break;
            default:
                openSplashFragment();
                break;
        }
    }

    public void openLoginFragment(){
        switchFragment(LoginFragment.newInstance());
    }
    public void openSignUpFragment(){ switchFragment(SignUpFragment.newInstance()); }
    public void openSplashFragment(){ switchFragment(SplashFragment.newInstance()); }

}
