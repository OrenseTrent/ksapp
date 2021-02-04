package com.cloversoft.ks.android.fragment.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MessageActivity;
import com.cloversoft.ks.android.activity.TransactionActivity;
import com.cloversoft.ks.android.adapter.HomeGameRecyclerViewAdapter;
import com.cloversoft.ks.android.adapter.MessageRecyclerViewAdapter;
import com.cloversoft.ks.android.adapter.MessageSpecRecyclerViewAdapter;
import com.cloversoft.ks.data.model.api.MessageModel;
import com.cloversoft.ks.data.model.api.PromotionModel;
import com.cloversoft.ks.data.model.api.SpecificMsgModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.server.request.Message;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;

import butterknife.BindView;


public class MessageFragment extends BaseFragment implements View.OnClickListener, MessageRecyclerViewAdapter.ClickListener,MessageSpecRecyclerViewAdapter.ClickListener{
    public static final String TAG = MessageFragment.class.getName().toString();

    private MessageActivity messageActivity;
    private MessageRecyclerViewAdapter messageRecyclerViewAdapter;
    private MessageSpecRecyclerViewAdapter messageSpecRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    public static final String MyPREFERENCES = "MyPrefs";
    private Runnable runnable;
    private Handler handler;

    @BindView(R.id.msgRV)           RecyclerView msgRV;
    @BindView(R.id.msgSpecRV)           RecyclerView msgSpecRV;
    @BindView(R.id.progress)
    ImageView progress;


    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_message;
    }

    @Override
    public void onViewReady() {
        messageActivity = (MessageActivity) getContext();
        setUpListView();
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        String pass = prefs.getString("pass_key", "none");
        Message.getDefault().message(getContext(),user,pass,JavaUtils.md5());

    }


    private void setUpListView(){
        msgSpecRV.setVisibility(View.GONE);
        msgRV.setVisibility(View.VISIBLE);
        messageRecyclerViewAdapter = new MessageRecyclerViewAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext());
        msgRV.setLayoutManager(linearLayoutManager);
        msgRV.setAdapter(messageRecyclerViewAdapter);
        messageRecyclerViewAdapter.setClickListener(this);
    }

    private void setupMessageSpecView(){
        msgRV.setVisibility(View.GONE);
        msgSpecRV.setVisibility(View.VISIBLE);
        messageSpecRecyclerViewAdapter = new MessageSpecRecyclerViewAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext());
        msgSpecRV.setLayoutManager(linearLayoutManager);
        msgSpecRV.setAdapter(messageSpecRecyclerViewAdapter);
        messageSpecRecyclerViewAdapter.setClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        messageActivity.setTitle("交易记录");
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
    public void onResponse(Message.MessageResponse messageResponse){
        try{
            SingleTransformer<MessageModel> collectionTransformer = messageResponse.getData(SingleTransformer.class);
            if (collectionTransformer.status == 1){
                messageRecyclerViewAdapter.addNewData(Collections.singletonList(collectionTransformer.info));
                Log.e("DATA", String.valueOf(collectionTransformer.info));
            }
            else{
                messageRecyclerViewAdapter.setNewData(Collections.singletonList(collectionTransformer.info));
            }
        } catch(Exception e){

        }
    }

    @Subscribe
    public void onResponse(Message.SpecificMessageResponse messageResponse){
            SingleTransformer<SpecificMsgModel> collectionTransformer = messageResponse.getData(SingleTransformer.class);
            if (collectionTransformer.status == 1){
                messageSpecRecyclerViewAdapter.addNewData(Collections.singletonList(collectionTransformer.info));
                Log.e("DATA1", String.valueOf(collectionTransformer.info));
            }
            else{
                messageSpecRecyclerViewAdapter.setNewData(Collections.singletonList(collectionTransformer.info));
            }

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(MessageModel messageModel) {
        Glide.with(getContext()).asGif().load(R.raw.loading).listener(new RequestListener<GifDrawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                progress.setVisibility(View.VISIBLE);
                resource.setLoopCount(1);
                resource.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        //do whatever after specified number of loops complete
                        progress.setVisibility(View.GONE);

                    }
                });
                return false;
            }
        }).into(progress);
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        String pass = prefs.getString("pass_key", "none");
        Message.getDefault().getSpecificMessage(getContext(),user, pass, JavaUtils.md5(),messageModel.record.get(0).idX);
        Log.e("ID MESSAGE", String.valueOf(messageModel.record.get(0).idX));
        setupMessageSpecView();

    }

    @Override
    public void onItemClick(SpecificMsgModel specificMsgModel) {
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        String pass = prefs.getString("pass_key", "none");
        Message.getDefault().message(getContext(),user,pass,JavaUtils.md5());
        setUpListView();

    }
}
