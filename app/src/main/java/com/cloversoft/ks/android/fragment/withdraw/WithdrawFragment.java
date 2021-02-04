package com.cloversoft.ks.android.fragment.withdraw;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.WithdrawActivity;
import com.cloversoft.ks.android.adapter.BankHistoryRecyclerViewAdapter;
import com.cloversoft.ks.android.adapter.SpinnerAdapters;
import com.cloversoft.ks.android.adapter.TransferGameBalanceAdapter;
import com.cloversoft.ks.config.APIInterface;
import com.cloversoft.ks.config.Apiclient;
import com.cloversoft.ks.data.model.api.BankHistoryMain;
import com.cloversoft.ks.data.model.api.BankHistoryModel;
import com.cloversoft.ks.data.model.api.BankListModel;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.server.request.Bank;
import com.cloversoft.ks.server.request.Game;
import com.cloversoft.ks.server.request.Transfer;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.android.java.Log;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;
import com.cloversoft.ks.vendor.server.transformer.WithdrawTransformer;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WithdrawFragment extends BaseFragment implements View.OnClickListener, TransferGameBalanceAdapter.ClickListener{
    public static final String TAG = WithdrawFragment.class.getName().toString();

    private WithdrawActivity withdrawActivity;
    public static final String MyPREFERENCES = "MyPrefs";

    private LinearLayoutManager linearLayoutManager;
    private String gameBal;
    private int gameID;
    boolean flag = true;
    private SpinnerAdapters spinnerAdapters;
    private BankHistoryRecyclerViewAdapter bankHistoryRecyclerViewAdapter;
    private Apiclient apiclient;
    private List<BankHistoryMain> bankHistoryMains = new ArrayList<>();
    private List<BankHistoryModel> bankHistoryModels = new ArrayList<>();

    @BindView(R.id.balanceTXT)                      TextView balanceTXT;
    @BindView(R.id.balance1TXT)                      TextView balance1TXT;
    @BindView(R.id.balance2TXT)                      TextView balance2TXT;
    @BindView(R.id.balance3TXT)                      TextView balance3TXT;
    @BindView(R.id.balance4TXT)                      TextView balance4TXT;
    @BindView(R.id.balance5TXT)                      TextView balance5TXT;
    @BindView(R.id.balance6TXT)                      TextView balance6TXT;
    @BindView(R.id.balance7TXT)                      TextView balance7TXT;
    @BindView(R.id.balance8TXT)                      TextView balance8TXT;
    @BindView(R.id.balance9TXT)                      TextView balance9TXT;
    @BindView(R.id.balance10TXT)                      TextView balance10TXT;
    @BindView(R.id.balance11TXT)                      TextView balance11TXT;
    @BindView(R.id.balance12TXT)                      TextView balance12TXT;
    @BindView(R.id.balance13TXT)                      TextView balance13TXT;
    @BindView(R.id.balance14TXT)                      TextView balance14TXT;
    @BindView(R.id.balance15TXT)                      TextView balance15TXT;
    @BindView(R.id.balance16TXT)                      TextView balance16TXT;
    @BindView(R.id.balance17TXT)                      TextView balance17TXT;
    @BindView(R.id.balance18TXT)                      TextView balance18TXT;
    @BindView(R.id.balance19TXT)                      TextView balance19TXT;
    @BindView(R.id.balance20TXT)                      TextView balance20TXT;
    @BindView(R.id.balance21TXT)                      TextView balance21TXT;
    @BindView(R.id.balance22TXT)                      TextView balance22TXT;
    @BindView(R.id.balance23TXT)                      TextView balance23TXT;
    @BindView(R.id.balance25TXT)                      TextView balance25TXT;
    @BindView(R.id.spinner1)                        Spinner spinner1;
    @BindView(R.id.maxBTN)                          TextView maxBTN;
    @BindView(R.id.submitBTN)                       TextView submitBTN;
    @BindView(R.id.historyRV)                       RecyclerView historyRV;
    @BindView(R.id.expandableLayout)                ExpandableRelativeLayout expandableLayout;
    @BindView(R.id.toggleBTN)                       ImageView toggleBTN;
    @BindView(R.id.toggleBTNDown)                   ImageView toggleBTNDown;
    @BindView(R.id.toggleLayout)                    Button toggleLayout;
    @BindView(R.id.ammountET)                       EditText ammountET;
//    @BindView(R.id.refreshBTN)                      ImageView refreshBTN;


    public static WithdrawFragment newInstance() {
        WithdrawFragment fragment = new WithdrawFragment();
        return fragment;

    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_withdraw;
    }

    @Override
    public void onViewReady() {
        withdrawActivity = (WithdrawActivity) getContext();
        maxBTN.setOnClickListener(this);
        toggleLayout.setOnClickListener(this);
        submitBTN.setOnClickListener(this);
//        refreshBTN.setOnClickListener(this);
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        String pass = prefs.getString("pass_key", "none");
        Auth.getDefault().userInfo(getContext(),user, pass, JavaUtils.md5());
        Bank.getDefault().bankList(getContext(),user,pass,JavaUtils.md5());
        Bank.getDefault().historyList(getContext(),user,pass,JavaUtils.md5());
        Game.getDefault().gameBalance(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance1(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance2(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance3(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance4(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance5(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance6(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance7(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance8(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance9(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance10(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance11(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance12(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance13(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance14(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance15(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance16(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance17(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance18(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance19(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance20(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance21(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance22(getContext(),user, pass, JavaUtils.md5());
        Game.getDefault().gameBalance23(getContext(),user, pass, JavaUtils.md5());

        expandableLayout.collapse();
        truckSpinner();
        setUpListView();
    }

    public void truckSpinner(){
        spinnerAdapters = new SpinnerAdapters(getContext());
        spinner1.setAdapter(spinnerAdapters);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                typeTXT.setText(spinnerAdapters.getProduct(i).name);
//                feedType = spinnerAdapters.getProduct(i).code;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setUpListView(){
        bankHistoryRecyclerViewAdapter = new BankHistoryRecyclerViewAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        historyRV.setLayoutManager(linearLayoutManager);
        historyRV.setAdapter(bankHistoryRecyclerViewAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        withdrawActivity.setTitle("马上提款");
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

    private void setData(UserInfoModel data) {
        balanceTXT.setText("¥" +data.balance);

    }

    @Subscribe
    public void onResponse(Bank.BankListResponse bankListResponse ){
        CollectionTransformer<BankListModel> collectionTransformer = bankListResponse.getData(CollectionTransformer.class);
        if (collectionTransformer.status == 1){
            spinnerAdapters.setNewData(collectionTransformer.info);
        }
    }

    @Subscribe
    public void onResponse(Bank.HistoryResponse historyResponse){
        SingleTransformer<BankHistoryModel> collectionTransformer = historyResponse.getData(SingleTransformer.class);
            if (collectionTransformer.status == 1){
                Log.e("HISTORY", collectionTransformer.info);
                bankHistoryRecyclerViewAdapter.addNewData(Collections.singletonList(collectionTransformer.info));
            }
            else{
                bankHistoryRecyclerViewAdapter.setNewData(Collections.singletonList(collectionTransformer.info));
            }

    }


    @Subscribe
    public void onResponse(Game.GameBalanceResponse gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance1TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance1Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance2TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance2Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance3TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance3Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
//            balance4TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance4Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance5TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance5Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance6TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance6Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance7TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance7Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance8TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance8Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance9TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance9Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance10TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance10Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance11TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance11Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance12TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance12Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance13TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance13Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
//            balance14TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance14Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
//            balance15TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance15Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance16TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance16Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance17TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance17Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance18TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance18Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance19TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance19Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance20TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance20Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance21TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance21Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance22TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance22Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance23TXT.setText(String.valueOf(singleTransformer.info));
        }
    }

    @Subscribe
    public void onResponse(Game.GameBalance23Response gameBalanceResponse ){
        SingleTransformer singleTransformer = gameBalanceResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            balance25TXT.setText(String.valueOf(singleTransformer.info));
        }
    }


    @Subscribe
    public void onResponse(Transfer.TransferResponse transferResponse ){
        SingleTransformer singleTransformer = transferResponse.getData(SingleTransformer.class);
        if (singleTransformer.status == 1){
            Log.e("TRANSFER",  String.valueOf(singleTransformer.info));
        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none"); // return "none" if user is not logged in
        String pass = prefs.getString("pass_key", "none");
        switch (v.getId()){
            case R.id.toggleLayout:
                if(flag){
                    toggleBTN.setVisibility(View.VISIBLE);
                    toggleBTNDown.setVisibility(View.GONE);
                    expandableLayout.toggle();
                    flag=false;
                }
                else{
                    toggleBTN.setVisibility(View.GONE);
                    toggleBTNDown.setVisibility(View.VISIBLE);
                    expandableLayout.toggle();
                    flag=true;

                }
                break;
            case R.id.submitBTN:
                BankListModel bankListModel = (BankListModel) spinner1.getSelectedItem();
                Log.e("BANKLISTMODELSPINNER",bankListModel.id);
//                int a = Integer.valueOf(bankListModel.)
                if(Integer.parseInt(ammountET.getText().toString()) >= 1000){
                    Bank.getDefault().withdraw(getContext(),user,pass,JavaUtils.md5(),ammountET.getText().toString(), bankListModel.id,true);
                }
                else{
                    Bank.getDefault().withdraw(getContext(),user,pass,JavaUtils.md5(),ammountET.getText().toString(), bankListModel.id,false);
                }
                break;
            case R.id.maxBTN:
                ammountET.setText(balanceTXT.getText().toString().substring(1));
                break;
            case R.id.refreshBTN:
                Bank.getDefault().historyList(getContext(),user,pass,JavaUtils.md5());
                break;
        }
    }

    @Override
    public void onItemClick(GameListModel gameListModel) {

    }

}
