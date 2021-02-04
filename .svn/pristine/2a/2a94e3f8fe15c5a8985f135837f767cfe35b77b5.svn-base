package com.cloversoft.ks.android.fragment.promotions;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asksira.bsimagepicker.BSImagePicker;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.android.adapter.HomeGameRecyclerViewAdapter;
import com.cloversoft.ks.android.adapter.PromotionRecyclerViewAdapter;
import com.cloversoft.ks.android.dialog.WebViewDialog;
import com.cloversoft.ks.android.fragment.main.HomeFragment;
import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.data.model.api.PromotionModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.server.request.Promotions;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Evanson on 2019-10-02.
 */

public class PromotionsFragment extends BaseFragment implements PromotionRecyclerViewAdapter.ClickListener{
    public static final String TAG = PromotionsFragment.class.getName().toString();


    private MainActivity mainActivity;
    private PromotionRecyclerViewAdapter promotionRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    @BindView(R.id.promoRV)             RecyclerView promoRV;



    public static PromotionsFragment newInstance() {
        PromotionsFragment fragment = new PromotionsFragment();
        return fragment;
    }

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_promotions;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();
//        mainActivity.setTitle("Profile");
        setUpListView();
        SharedPreferences prefs = getContext().getSharedPreferences(HomeFragment.MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        Promotions.getDefault().promotions(getContext(),user,JavaUtils.md5());
    }

    private void setUpListView(){
        promotionRecyclerViewAdapter = new PromotionRecyclerViewAdapter(getContext());
//        promotionRecyclerViewAdapter.setNewData(getDefaultData());
        linearLayoutManager = new LinearLayoutManager(getContext());
        promoRV.setLayoutManager(linearLayoutManager);
        promoRV.setAdapter(promotionRecyclerViewAdapter);
        promotionRecyclerViewAdapter.setClickListener(this);
    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.discountActive();

    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void onResponse(Promotions.PromotionsResponse promotionsResponse){
//        Log.e("Message", loginResponse.getData(BaseTransformer.class).msg);
        try{
            CollectionTransformer<PromotionModel> collectionTransformer = promotionsResponse.getData(CollectionTransformer.class);
            if (collectionTransformer.status == 1){
                promotionRecyclerViewAdapter.addNewData(collectionTransformer.info);
            }
            else{
                promotionRecyclerViewAdapter.setNewData(collectionTransformer.info);
            }
        } catch(Exception e){

        }

    }


    @Override
    public void onItemClick(PromotionModel promotionModel) {
//        WebViewDialog.newInstance(promotionModel.id, promotionModel.contentUrl).show(getChildFragmentManager(), TAG);
        mainActivity.startGameActivity("game","促销活动",promotionModel.contentUrl);
    }
}