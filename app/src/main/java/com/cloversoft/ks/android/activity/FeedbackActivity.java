package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.feedback.FeedbackFragment;
import com.cloversoft.ks.android.fragment.join.JoinFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class FeedbackActivity extends RouteActivity {
    public static final String TAG = FeedbackActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_feedback;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {


        switch (fragmentName){
            case "feedback":
                openFeedbackFragment();
                break;

        }
    }

    public void openFeedbackFragment(){ switchFragment(FeedbackFragment.newInstance()); }


}
