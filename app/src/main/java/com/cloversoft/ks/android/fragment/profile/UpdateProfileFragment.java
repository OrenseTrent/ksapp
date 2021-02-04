package com.cloversoft.ks.android.fragment.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.android.activity.ProfileActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.asksira.bsimagepicker.BSImagePicker;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Evanson on 2019-10-02.
 */

public class UpdateProfileFragment extends BaseFragment implements BSImagePicker.OnSingleImageSelectedListener,View.OnClickListener {
    public static final String TAG = UpdateProfileFragment.class.getName().toString();

    private MainActivity mainActivity;
    private String gameTitle;
    public static final String MyPREFERENCES = "MyPrefs";

    @BindView(R.id.depositCON)                          View depositCON;
    @BindView(R.id.transferCON)                         View transferCON;
    @BindView(R.id.withdrawCON)                         View withdrawCON;
    @BindView(R.id.msgCON)                              View msgCON;
    @BindView(R.id.trasactHistoryBTN)                   View trasactHistoryBTN;
    @BindView(R.id.discountBTN)                         View discountBTN;
    @BindView(R.id.inviteRewardBTN)                     View inviteRewardBTN;
    @BindView(R.id.personalInfoBTN)                     View personalInfoBTN;
    @BindView(R.id.joinUsBTN)                           View joinUsBTN;
    @BindView(R.id.aboutUsBTN)                          View aboutUsBTN;
    @BindView(R.id.speedBTN)                            View speedBTN;
    @BindView(R.id.feedbackBTN)                         View feedbackBTN;
    @BindView(R.id.agentBTN)                            View agentBTN;
    @BindView(R.id.signOutBTN)                         View signOutBTN;


    public static UpdateProfileFragment newInstance() {
        UpdateProfileFragment fragment = new UpdateProfileFragment();
        return fragment;
    }

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_update_profile;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();
        mainActivity.setTitle("Profile");
        depositCON.setOnClickListener(this);
        transferCON.setOnClickListener(this);
        withdrawCON.setOnClickListener(this);
        msgCON.setOnClickListener(this);
        trasactHistoryBTN.setOnClickListener(this);
        discountBTN.setOnClickListener(this);
        inviteRewardBTN.setOnClickListener(this);
        personalInfoBTN.setOnClickListener(this);
        joinUsBTN.setOnClickListener(this);
        aboutUsBTN.setOnClickListener(this);
        speedBTN.setOnClickListener(this);
        feedbackBTN.setOnClickListener(this);
        agentBTN.setOnClickListener(this);
        signOutBTN.setOnClickListener(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.profileActive();

    }


    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onResponse(Auth.LoginResponse loginResponse){
//        Log.e("Message", loginResponse.getData(BaseTransformer.class).msg);
    }


    private void openFileChooser() {
        BSImagePicker pickerDialog = new BSImagePicker.Builder("com.cloversoft.ks.fileprovider").build();
        pickerDialog.show(getChildFragmentManager(), "picker");

    }


    @Override
    public void onSingleImageSelected(Uri uri, String tag) {
//
//        Glide.with(getContext())
//                .load(uri)
//                .thumbnail(0.1f)
//                .apply(new RequestOptions().placeholder(R.color.gray).error(R.color.gray))
//                .into(profileIMG);
    }


    @Override
    public void onClick(View v) {
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        switch (v.getId()){
           case R.id.depositCON:
               mainActivity.startGameActivity("game",gameTitle,"https://m.ks881000.com/kspwa/capital/index.php?account="+user+"&auth="+ JavaUtils.md5()+"&membertype=5");
            break;
            case R.id.transferCON:
                mainActivity.startTransferActivity("transfer");
                break;
            case R.id.withdrawCON:
                mainActivity.startWithdrawActivity("withdraw");
                break;
            case R.id.msgCON:
                mainActivity.startMsgActivity("message");
                break;
            case R.id.trasactHistoryBTN:
                mainActivity.startTransactionActivity("transaction");
                break;
            case R.id.discountBTN:
                break;
            case R.id.inviteRewardBTN:
                mainActivity.startRewardsActivity("rewards");
                break;
            case R.id.personalInfoBTN:
                mainActivity.startSettingsActivity("settings");
                break;
            case R.id.joinUsBTN:
                mainActivity.startJoinActivity("join");
                break;
            case R.id.aboutUsBTN:
                mainActivity.startAboutActivity("about");
                break;
            case R.id.speedBTN:
                mainActivity.startSpeedActivity("speed");
                break;
            case R.id.feedbackBTN:
                mainActivity.startFeedbackActivity("feedback");
                break;
            case R.id.agentBTN:

                break;
            case R.id.signOutBTN:
                SharedPreferences preferences = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();
                mainActivity.startLandingActivity("login");
                break;
        }

    }
}