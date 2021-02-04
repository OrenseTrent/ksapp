package com.cloversoft.ks.android.fragment.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.data.model.api.MemberInfoModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;



public class SettingsFragment extends BaseFragment {
    public static final String TAG = SettingsFragment.class.getName().toString();

    public static final String MyPREFERENCES = "MyPrefs";

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

//    @BindView(R.id.logoutBTN)                   TextView logoutBTN;
    @BindView(R.id.nameTXT)     TextView nameTXT;
    @BindView(R.id.dateTXT)     TextView dateTXT;
    @BindView(R.id.cpTXT)     TextView cpTXT;
    @BindView(R.id.emailTXT)     TextView emailTXT;

    private MainActivity mainActivity;


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_settings;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        String pass = prefs.getString("pass_key", "none");
        Auth.getDefault().memberInfo(getContext(),user, pass, JavaUtils.md5());
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setTitle("Settings");
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onResponse(Auth.MemberInfoResponse homeInfoResponse){
            SingleTransformer<MemberInfoModel> singleTransformer = homeInfoResponse.getData(SingleTransformer.class);
            if (singleTransformer.status == 1){
                setData(singleTransformer.info);
            } else if (singleTransformer.status == 0){
            }
    }

    private void setData(MemberInfoModel data) {
        nameTXT.setText(data.memberName);
        dateTXT.setText(data.birthday);
        cpTXT.setText(data.phone);
        emailTXT.setText(data.email);

    }

}
