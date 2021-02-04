package com.cloversoft.ks.android.activity;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.DefaultFragment;
import com.cloversoft.ks.android.fragment.customer.CustomerServiceFragment;
import com.cloversoft.ks.android.fragment.main.HomeFragment;
import com.cloversoft.ks.android.fragment.profile.UpdateProfileFragment;
import com.cloversoft.ks.android.fragment.promotions.PromotionsFragment;
import com.cloversoft.ks.android.route.RouteActivity;

import butterknife.BindView;


public class MainActivity extends RouteActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getName().toString();



    ColorStateList defaultColor;


    @BindView(R.id.homeCON)                     View homeCON;
    @BindView(R.id.discountCON)                 View discountCON;
    @BindView(R.id.customerCON)                 View customerCON;
    @BindView(R.id.profileCON)                  View profileCON;
    @BindView(R.id.homeIMG)                     ImageView homeIMG;
    @BindView(R.id.discountIMG)                 ImageView discountIMG;
    @BindView(R.id.customerIMG)                 ImageView customerIMG;
    @BindView(R.id.profileIMG)                  ImageView profileIMG;
    @BindView(R.id.homeTXT)                     TextView homeTXT;
    @BindView(R.id.discountTXT)                 TextView discountTXT;
    @BindView(R.id.customerTXT)                 TextView customerTXT;
    @BindView(R.id.profileTXT)                  TextView profileTXT;


    @Override
    public int onLayoutSet() {
        return R.layout.activity_main;
    }

    @Override
    public void onViewReady() {
        defaultColor = homeTXT.getTextColors();
        homeCON.setOnClickListener(this);
        discountCON.setOnClickListener(this);
        customerCON.setOnClickListener(this);
        profileCON.setOnClickListener(this);
    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "home":
                openHomeFragment();
                break;
                default:
                    openDefaultFragment();
                break;
        }
    }

    public void openDefaultFragment(){
        switchFragment(DefaultFragment.newInstance());
    }
    public void openHomeFragment(){ switchFragment(HomeFragment.newInstance()); }
    public void openProfileFragment(){switchFragment(UpdateProfileFragment.newInstance());}
    public void openCustomerServiceFragment(){switchFragment(CustomerServiceFragment.newInstance());}
    public void openPromotionsFragment(){switchFragment(PromotionsFragment.newInstance());}



    @Override
    public void onBackPressed() { super.onBackPressed();
    }


//    @OnClick(R.id.profileBTN)
//    void profileBTNClicked(){
//        startProfileActivity("update_profile");
//    }



    public void homeActive(){
        homeCON.setSelected(true);
        homeIMG.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        homeTXT.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        discountCON.setSelected(false);
        discountIMG.clearColorFilter();
        discountTXT.setTextColor(defaultColor);
        customerCON.setSelected(false);
        customerIMG.clearColorFilter();
        customerTXT.setTextColor(defaultColor);
        profileCON.setSelected(false);
        profileIMG.clearColorFilter();
        profileTXT.setTextColor(defaultColor);
    }

    public void discountActive(){
        homeCON.setSelected(false);
        homeIMG.clearColorFilter();
        homeTXT.setTextColor(defaultColor);
        discountCON.setSelected(true);
        discountIMG.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        discountTXT.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        customerCON.setSelected(false);
        customerIMG.clearColorFilter();
        customerTXT.setTextColor(defaultColor);
        profileCON.setSelected(false);
        profileIMG.clearColorFilter();
        profileTXT.setTextColor(defaultColor);
    }

    public void customerActive(){
        homeCON.setSelected(false);
        homeIMG.clearColorFilter();
        homeTXT.setTextColor(defaultColor);
        discountCON.setSelected(false);
        discountIMG.clearColorFilter();
        discountTXT.setTextColor(defaultColor);
        customerCON.setSelected(true);
        customerIMG.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        customerTXT.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        profileCON.setSelected(false);
        profileIMG.clearColorFilter();
        profileTXT.setTextColor(defaultColor);
    }

    public void profileActive(){
        homeCON.setSelected(false);
        homeIMG.clearColorFilter();
        homeTXT.setTextColor(defaultColor);
        discountCON.setSelected(false);
        discountIMG.clearColorFilter();
        discountTXT.setTextColor(defaultColor);
        customerCON.setSelected(false);
        customerIMG.clearColorFilter();
        customerTXT.setTextColor(defaultColor);
        profileCON.setSelected(true);
        profileIMG.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP);
        profileTXT.setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.homeCON:
                homeActive();
                openHomeFragment();
                break;
            case R.id.discountCON:
                discountActive();
                openPromotionsFragment();
                break;
            case R.id.customerCON:
                customerActive();
                openCustomerServiceFragment();
                break;
            case R.id.profileCON:
                profileActive();
                openProfileFragment();
                break;
        }

    }
}
