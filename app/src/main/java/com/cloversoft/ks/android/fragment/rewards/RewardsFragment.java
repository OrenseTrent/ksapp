package com.cloversoft.ks.android.fragment.rewards;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatDelegate;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.RewardsActivity;
import com.cloversoft.ks.android.activity.SettingsActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;


public class RewardsFragment extends BaseFragment implements View.OnClickListener{
    public static final String TAG = RewardsFragment.class.getName().toString();

    private RewardsActivity rewardsActivity;

    @BindView(R.id.qrIV)            ImageView qrIV;


    public static RewardsFragment newInstance() {
        RewardsFragment fragment = new RewardsFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_rewards;
    }

    @Override
    public void onViewReady() {
        rewardsActivity = (RewardsActivity) getContext();
        qrCode();
    }


    @Override
    public void onResume() {
        super.onResume();
//        discountActivity.setTitle("Sign Up");
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
    public void onResponse(Auth.LoginResponse loginResponse){
//        Log.e("Message", loginResponse.getData(BaseTransformer.class).msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }

    }

    private void qrCode(){
        QRCodeWriter writer = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = writer.encode("https://sad-visvesvaraya-279b39.netlify.app", BarcodeFormat.QR_CODE, 512, 512);
            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();
            Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            qrIV.setImageBitmap(bmp);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
