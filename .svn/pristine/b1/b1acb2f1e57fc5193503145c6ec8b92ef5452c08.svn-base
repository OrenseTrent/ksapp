package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.join.JoinFragment;
import com.cloversoft.ks.android.fragment.message.MessageFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class MessageActivity extends RouteActivity {
    public static final String TAG = MessageActivity.class.getName().toString();


    @Override
    public int onLayoutSet() {
        return R.layout.activity_message;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "message":
                openMsgFragment();
                break;

        }
    }

    public void openMsgFragment(){ switchFragment(MessageFragment.newInstance()); }


}
