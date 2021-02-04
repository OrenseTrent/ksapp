package com.cloversoft.ks.android.activity;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.dialog.WebViewDialog;
import com.cloversoft.ks.android.route.RouteActivity;


public class GameActivity extends RouteActivity  {
    public static final String TAG = GameActivity.class.getName().toString();

    @Override
    public int onLayoutSet() {
        return R.layout.activity_game;
    }

    @Override
    public void onViewReady() {
    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "game":
                openPromotionDetailsFragment(getFragmentBundle().getString("title"),getFragmentBundle().getString("content"));
                break;

        }
    }

    public void openPromotionDetailsFragment(String title,String content){switchFragment(WebViewDialog.newInstance(title,content));}



    @Override
    public void onBackPressed() { super.onBackPressed();
    }

}
