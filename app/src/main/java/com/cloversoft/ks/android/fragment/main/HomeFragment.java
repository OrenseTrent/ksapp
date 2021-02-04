package com.cloversoft.ks.android.fragment.main;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.android.adapter.DefaultRecyclerViewAdapter;
import com.cloversoft.ks.android.adapter.HomeGameRecyclerViewAdapter;
import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.PlayGameModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.data.model.api.UserModel;
import com.cloversoft.ks.data.preference.UserData;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.server.request.Game;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.android.java.ToastMessage;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;


public class HomeFragment extends BaseFragment implements View.OnClickListener,HomeGameRecyclerViewAdapter.ClickListener{
    public static final String TAG = HomeFragment.class.getName().toString();

    private MainActivity mainActivity;
    private HomeGameRecyclerViewAdapter homeGameRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;
    public static final String MyPREFERENCES = "MyPrefs";
    private GameListModel gameListModel;
    private String gameTitle;


    @BindView(R.id.sliderLayout)            SliderLayout sliderLayout;
    @BindView(R.id.gameRV)                  RecyclerView gameRV;
    @BindView(R.id.casinoLayout)            View casinoLayout;
    @BindView(R.id.sportsLayout)            View sportsLayout;
    @BindView(R.id.esportsLayout)           View esportsLayout;
    @BindView(R.id.pokerLayout)             View pokerLayout;
    @BindView(R.id.slotsLayout)             View slotsLayout;
    @BindView(R.id.lotteryLayout)           View lotteryLayout;
    @BindView(R.id.casinoIMG)               ImageView casinoIMG;
    @BindView(R.id.sportsIMG)               ImageView sportsIMG;
    @BindView(R.id.esportsIMG)               ImageView esportsIMG;
    @BindView(R.id.pokerIMG)               ImageView pokerIMG;
    @BindView(R.id.slotsIMG)               ImageView slotsIMG;
    @BindView(R.id.lotteryIMG)               ImageView lotteryIMG;
    @BindView(R.id.userTXT)                 TextView userTXT;
    @BindView(R.id.userBalanceTXT)                 TextView userBalanceTXT;
    @BindView(R.id.depositCON)              View depositCON;
    @BindView(R.id.transferCON)              View transferCON;
    @BindView(R.id.withdrawCON)              View withdrawCON;
    @BindView(R.id.msgCON)              View msgCON;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();
        setupSlider();
        casinoLayout.setOnClickListener(this);
        sportsLayout.setOnClickListener(this);
        esportsLayout.setOnClickListener(this);
        pokerLayout.setOnClickListener(this);
        slotsLayout.setOnClickListener(this);
        lotteryLayout.setOnClickListener(this);
        depositCON.setOnClickListener(this);
        transferCON.setOnClickListener(this);
        msgCON.setOnClickListener(this);
        withdrawCON.setOnClickListener(this);
        setUpListView();
        casinoActive();
        scrollHighlight();
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        String pass = prefs.getString("pass_key", "none");
        Auth.getDefault().userInfo(getContext(),user, pass, JavaUtils.md5());


        gameRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int itemPos = linearLayoutManager.findFirstVisibleItemPosition();
                if(itemPos == 0 ){
                    casinoActive();
                }
                else if(itemPos ==6){
                    sportsActive();
                }
                else if(itemPos == 9){
                    esportsActive();
                }
                else if (itemPos == 13){
                    pokerActive();
                }
                else if(itemPos == 15){
                    slotsActive();
                }
                else if (itemPos == 22){
                    lotteryActive();
                }
            }

        });



    }

    @Override
    public void onResume() {
        super.onResume();
        mainActivity.setTitle("Home");
        mainActivity.homeActive();
    }

    private void setupSlider(){
        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.FILL); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(3); //set scroll delay in seconds :
        for (int i = 0; i <= 2; i++) {

            SliderView sliderView = new SliderView(getContext());

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.banner_1);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.banner_2);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.banner_3);
                    break;

            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
//                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }

    private void setUpListView(){
        homeGameRecyclerViewAdapter = new HomeGameRecyclerViewAdapter(getContext());
        homeGameRecyclerViewAdapter.setNewData(getDefaultData());
        linearLayoutManager = new LinearLayoutManager(getContext());
        gameRV.setLayoutManager(linearLayoutManager);
        gameRV.setAdapter(homeGameRecyclerViewAdapter);
        homeGameRecyclerViewAdapter.setClickListener(this);
    }

    private List<GameListModel> getDefaultData(){
        List<GameListModel> androidModels = new ArrayList<>();
        GameListModel defaultItem;
            defaultItem = new GameListModel();
            defaultItem.id = 102;
            defaultItem.image = R.drawable.cas1;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 107;
            defaultItem.image = R.drawable.cas2;
            defaultItem.title = "欧博真人";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 108;
            defaultItem.image = R.drawable.cas3;
            defaultItem.title = "大游真人";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 106;
            defaultItem.image = R.drawable.cas4;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 104;
            defaultItem.image = R.drawable.a_35;
            defaultItem.title = "OG真人";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 301;
            defaultItem.image = R.drawable.cas6;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 402;
            defaultItem.image = R.drawable.sports1;
            defaultItem.title = "IM平台";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 608;
            defaultItem.image = R.drawable.sports2;
            defaultItem.title = "IM平台";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 612;
            defaultItem.image = R.drawable.sports3;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 607;
            defaultItem.image = R.drawable.es1;
            defaultItem.title = "泛亚电竞";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 611;
            defaultItem.image = R.drawable.es2;
            defaultItem.title = "IM平台";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 603;
            defaultItem.image = R.drawable.e3;
            defaultItem.title = "TF电竞";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 6088;
            defaultItem.image = R.drawable.es4;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 501;
            defaultItem.image = R.drawable.poker1;
            defaultItem.title = "开元棋牌";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 604;
            defaultItem.image = R.drawable.poker2;
            defaultItem.title = "双赢棋牌";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 1022;
            defaultItem.image = R.drawable.slot1;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 610;
            defaultItem.image = R.drawable.slot2;
            defaultItem.title = "泛亚捕鱼";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 613;
            defaultItem.image = R.drawable.slot3;
            defaultItem.title = "CQ电子";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 202;
            defaultItem.image = R.drawable.slot4;
            defaultItem.title = "MG游戏大厅";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 207;
            defaultItem.image = R.drawable.slot5;
            defaultItem.title = "欧洲PT";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 201;
            defaultItem.image = R.drawable.slot6;
            defaultItem.title = "PT老虎机";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 614;
            defaultItem.image = R.drawable.slot7;
            defaultItem.title = "QT电子";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 601;
            defaultItem.image = R.drawable.lottery1;
            defaultItem.title = "IG彩票";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 606;
            defaultItem.image = R.drawable.lottery2;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 605;
            defaultItem.image = R.drawable.lottery3;
            defaultItem.title = "统计";
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 609;
            defaultItem.image = R.drawable.lottery4;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 602;
            defaultItem.image = R.drawable.lottery5;
            androidModels.add(defaultItem);

            defaultItem = new GameListModel();
            defaultItem.id = 3011;
            defaultItem.image = R.drawable.lottery6;
            androidModels.add(defaultItem);

        return androidModels;
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
    public void onResponse(Auth.HomeInfoResponse homeInfoResponse){
        try{
            SingleTransformer<UserInfoModel> singleTransformer = homeInfoResponse.getData(SingleTransformer.class);
            if (singleTransformer.status == 1){
                setData(singleTransformer.info);
            } else if (singleTransformer.status == 0){
            }
        } catch(Exception e){

        }
    }

    @Subscribe
    public void onResponse(Game.GamePlayResponse homeInfoResponse){
        SingleTransformer singleTransformer = homeInfoResponse.getData(SingleTransformer.class);
            if (singleTransformer.status == 1){
//                ToastMessage.show(getContext(), "Success", ToastMessage.Status.SUCCESS);
//                    Log.e("URLGAME107", String.valueOf(gameListModel.title));
                    Log.e("URL", String.valueOf(singleTransformer.info));
                    Log.e("URLTITLE", gameTitle);
                    mainActivity.startGameActivity("game",gameTitle,String.valueOf(singleTransformer.info));

            }

    }


    private void setData(UserInfoModel data) {
        userTXT.setText(data.account);
        userBalanceTXT.setText(String.format("中心: %s", data.balance));

    }


    private void scrollHighlight(){
        //rv animation
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
            case R.id.msgCON:
                mainActivity.startMsgActivity("message");
                break;
            case R.id.withdrawCON:
                mainActivity.startWithdrawActivity("withdraw");
                break;
            case R.id.casinoLayout:
                casinoActive();
                gameRV.smoothScrollToPosition(0);
                break;
            case R.id.sportsLayout:
                sportsActive();
                gameRV.smoothScrollToPosition(8);
                break;
            case R.id.esportsLayout:
                esportsActive();
                gameRV.smoothScrollToPosition(11);
                break;
            case R.id.pokerLayout:
                pokerActive();
                gameRV.smoothScrollToPosition(15);
                break;
            case R.id.slotsLayout:
                slotsActive();
                gameRV.smoothScrollToPosition(17);
                break;
            case R.id.lotteryLayout:
                lotteryActive();
                gameRV.smoothScrollToPosition(24);
                break;

        }

    }

    public void casinoActive(){
        casinoLayout.setSelected(true);
        casinoIMG.setImageResource(R.drawable.casinol);
        sportsLayout.setSelected(false);
        sportsIMG.setImageResource(R.drawable.sports_off);
        esportsLayout.setSelected(false);
        esportsIMG.setImageResource(R.drawable.casinol_off);
        pokerLayout.setSelected(false);
        pokerIMG.setImageResource(R.drawable.poker_off);
        slotsLayout.setSelected(false);
        slotsIMG.setImageResource(R.drawable.slots_off);
        lotteryLayout.setSelected(false);
        lotteryIMG.setImageResource(R.drawable.lottery_off);
    }

    public void sportsActive(){
        casinoLayout.setSelected(false);
        casinoIMG.setImageResource(R.drawable.casinol_off);
        sportsLayout.setSelected(true);
        sportsIMG.setImageResource(R.drawable.sports);
        esportsLayout.setSelected(false);
        esportsIMG.setImageResource(R.drawable.casinol_off);
        pokerLayout.setSelected(false);
        pokerIMG.setImageResource(R.drawable.poker_off);
        slotsLayout.setSelected(false);
        slotsIMG.setImageResource(R.drawable.slots_off);
        lotteryLayout.setSelected(false);
        lotteryIMG.setImageResource(R.drawable.lottery_off);
    }

    public void esportsActive(){
        casinoLayout.setSelected(false);
        casinoIMG.setImageResource(R.drawable.casinol_off);
        sportsLayout.setSelected(false);
        sportsIMG.setImageResource(R.drawable.sports_off);
        esportsLayout.setSelected(true);
        esportsIMG.setImageResource(R.drawable.casinol);
        pokerLayout.setSelected(false);
        pokerIMG.setImageResource(R.drawable.poker_off);
        slotsLayout.setSelected(false);
        slotsIMG.setImageResource(R.drawable.slots_off);
        lotteryLayout.setSelected(false);
        lotteryIMG.setImageResource(R.drawable.lottery_off);
    }

    public void pokerActive(){
        casinoLayout.setSelected(false);
        casinoIMG.setImageResource(R.drawable.casinol_off);
        sportsLayout.setSelected(false);
        sportsIMG.setImageResource(R.drawable.sports_off);
        esportsLayout.setSelected(false);
        esportsIMG.setImageResource(R.drawable.casinol_off);
        pokerLayout.setSelected(true);
        pokerIMG.setImageResource(R.drawable.poker);
        slotsLayout.setSelected(false);
        slotsIMG.setImageResource(R.drawable.slots_off);
        lotteryLayout.setSelected(false);
        lotteryIMG.setImageResource(R.drawable.lottery_off);
    }

    public void slotsActive(){
        casinoLayout.setSelected(false);
        casinoIMG.setImageResource(R.drawable.casinol_off);
        sportsLayout.setSelected(false);
        sportsIMG.setImageResource(R.drawable.sports_off);
        esportsLayout.setSelected(false);
        esportsIMG.setImageResource(R.drawable.casinol_off);
        pokerLayout.setSelected(false);
        pokerIMG.setImageResource(R.drawable.poker_off);
        slotsLayout.setSelected(true);
        slotsIMG.setImageResource(R.drawable.slots);
        lotteryLayout.setSelected(false);
        lotteryIMG.setImageResource(R.drawable.lottery_off);
    }

    public void lotteryActive(){
        casinoLayout.setSelected(false);
        casinoIMG.setImageResource(R.drawable.casinol_off);
        sportsLayout.setSelected(false);
        sportsIMG.setImageResource(R.drawable.sports_off);
        esportsLayout.setSelected(false);
        esportsIMG.setImageResource(R.drawable.casinol_off);
        pokerLayout.setSelected(false);
        pokerIMG.setImageResource(R.drawable.poker_off);
        slotsLayout.setSelected(true);
        slotsIMG.setImageResource(R.drawable.slots_off);
        lotteryLayout.setSelected(true);
        lotteryIMG.setImageResource(R.drawable.lottery);
    }

    @Override
    public void onItemClick(GameListModel gameListModel) {
            Dialog dialog = new Dialog(getContext());
            View btmDialog = getActivity().getLayoutInflater().inflate(R.layout.dialog_wap, null);
//            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
            dialog.setContentView(btmDialog);
            ImageView closeBTN = btmDialog.findViewById(R.id.closeBTN);
            TextView proceedBTN = btmDialog.findViewById(R.id.proceedBTN);
            closeBTN.setOnClickListener(v -> {
                dialog.dismiss();
            });
            proceedBTN.setOnClickListener(v -> {
                SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                String user = prefs.getString("account_key", "none"); // return "none" if user is not logged in
                String pass = prefs.getString("pass_key", "none");
                if(gameListModel.id == 102){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),102);

//                    mainActivity.startGameActivity("game",String.valueOf(gameListModel.info));
                }
                else if (gameListModel.id == 107){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),107);
                    Log.e("URLGAME107", String.valueOf(gameListModel.title));
                    this.gameTitle = gameListModel.title;

                }
                else if(gameListModel.id == 108){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),108);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 106){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),106);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 104){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),104);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 301){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),301);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 402){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),402);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 608){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),608);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 612){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),612);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 607){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),607);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 611){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),611);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 603){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),603);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 6088){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),608);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 501){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),501);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 604){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),604);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 1022){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),102);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 610){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),610);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 613){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),613);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 202){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),202);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 207){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),207);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 201){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),201);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 614){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),614);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 601){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),601);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 606){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),606);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 605){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),605);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 609){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),609);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 602){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),602);
                    this.gameTitle = gameListModel.title;
                }
                else if(gameListModel.id == 3011){
                    Game.getDefault().games(getContext(),user, pass, JavaUtils.md5(),301);
                    this.gameTitle = gameListModel.title;
                }
                dialog.dismiss();

            });
            dialog.show();

    }



}
