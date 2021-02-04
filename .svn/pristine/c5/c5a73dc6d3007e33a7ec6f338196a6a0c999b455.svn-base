package com.cloversoft.ks.android.activity;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.DefaultFragment;
import com.cloversoft.ks.android.fragment.register.SignUpFragment;
import com.cloversoft.ks.android.route.RouteActivity;


public class RegisterActivity extends RouteActivity {
    public static final String TAG = RegisterActivity.class.getName().toString();

    @Override
    public int onLayoutSet() {
        return R.layout.activity_register;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "signup":
                openSignUpFragment();
                break;
            default:
                break;
        }
    }

    public void openDefaultFragment(){
        switchFragment(DefaultFragment.newInstance());
    }
    public void openSignUpFragment(){ switchFragment(SignUpFragment.newInstance()); }


}
