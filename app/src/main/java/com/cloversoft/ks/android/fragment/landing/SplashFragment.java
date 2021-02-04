package com.cloversoft.ks.android.fragment.landing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.LandingActivity;
import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.data.preference.UserData;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;

import org.greenrobot.eventbus.EventBus;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

public class SplashFragment extends BaseFragment {
    public static final String TAG = SplashFragment.class.getName();

    private LandingActivity landingActivity;
    public static final String MyPREFERENCES = "MyPrefs" ;
    private Runnable runnable;
    private Handler handler;

    public static SplashFragment newInstance() {
        SplashFragment fragment = new SplashFragment();
        return fragment;
    }

    @Override
    public void onViewReady() {
        landingActivity = (LandingActivity) getContext();

            runnable = () -> landingActivity.runOnUiThread(() -> {
                SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                String user = prefs.getString("account_key", "none"); // return "none" if user is not logged in
                String pass = prefs.getString("pass_key", "none");

                if (user.equalsIgnoreCase("none") || pass.equalsIgnoreCase("none")) {
                    // Show a log in dialog and/or other stuff to let user log in
                    landingActivity.openLoginFragment();

                } else {
                    // Launch your main interface
                    landingActivity.startMainActivity("home");
                }
//                            landingActivity.tutorial();
            });
            handler = new Handler();
            handler.postDelayed(runnable, 3000);
        System.out.println("Auth " + JavaUtils.md5());
    }



    @Override
    public int onLayoutSet() {
        return R.layout.fragment_splash;
    }


    @Override
    public void onResume() {
        super.onResume();
    }



}