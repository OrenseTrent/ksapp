package com.cloversoft.ks.android.route;

import android.content.Intent;
import android.os.Bundle;

import com.cloversoft.ks.android.activity.AboutActivity;
import com.cloversoft.ks.android.activity.FeedbackActivity;
import com.cloversoft.ks.android.activity.GameActivity;
import com.cloversoft.ks.android.activity.JoinActivity;
import com.cloversoft.ks.android.activity.LandingActivity;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.android.activity.MessageActivity;
import com.cloversoft.ks.android.activity.ProfileActivity;
import com.cloversoft.ks.android.activity.RegisterActivity;
import com.cloversoft.ks.android.activity.RewardsActivity;
import com.cloversoft.ks.android.activity.SettingsActivity;
import com.cloversoft.ks.android.activity.SpeedActivity;
import com.cloversoft.ks.android.activity.TransactionActivity;
import com.cloversoft.ks.android.activity.TransferActivity;
import com.cloversoft.ks.android.activity.WithdrawActivity;
import com.cloversoft.ks.android.fragment.speed.SpeedFragment;
import com.cloversoft.ks.vendor.android.base.BaseActivity;
import com.cloversoft.ks.vendor.android.base.RouteManager;


public class RouteActivity extends BaseActivity {

    public void startMainActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(MainActivity.class)
                .addActivityTag("main")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    }


    public void startGameActivity(String fragmentTAG,String title,String content){
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("content", content);
        RouteManager.Route.with(this)
                .addActivityClass(GameActivity.class)
                .addActivityTag("game")
                .addFragmentTag(fragmentTAG)
                .addFragmentBundle(bundle)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP );
    }

    public void startTransactionActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(TransactionActivity.class)
                .addActivityTag("transaction")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startSettingsActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(SettingsActivity.class)
                .addActivityTag("settings")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
    public void startRewardsActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(RewardsActivity.class)
                .addActivityTag("rewards")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
    public void startAboutActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(AboutActivity.class)
                .addActivityTag("about")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startJoinActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(JoinActivity.class)
                .addActivityTag("join")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startSpeedActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(SpeedActivity.class)
                .addActivityTag("speed")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startFeedbackActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(FeedbackActivity.class)
                .addActivityTag("feedback")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startTransferActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(TransferActivity.class)
                .addActivityTag("transfer")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startMsgActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(MessageActivity.class)
                .addActivityTag("message")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startWithdrawActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(WithdrawActivity.class)
                .addActivityTag("withdraw")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void startRegisterActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(RegisterActivity.class)
                .addActivityTag("register")
                .addFragmentTag(fragmentTAG)
                .startActivity();
    }

    public void startLandingActivity(String fragmentTAG){
        RouteManager.Route.with(this)
                .addActivityClass(LandingActivity.class)
                .addActivityTag("landing")
                .addFragmentTag(fragmentTAG)
                .startActivity(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
    }

    public void startProfileActivity(String fragmentTAG){
        Bundle bundle = new Bundle();
        RouteManager.Route.with(this)
                .addActivityClass(ProfileActivity.class)
                .addActivityTag("cash_in")
                .addFragmentTag(fragmentTAG)
                .startActivity();
    }


//    @Subscribe
//    public void invalidToken(InvalidToken invalidToken){
//        Log.e("Token", "Expired");
//        EventBus.getDefault().unregister(this);
//        UserData.insert(new UserModel());
//        UserData.insert(UserData.TOKEN_EXPIRED, true);
//        startLandingActivity();
//    }
}
