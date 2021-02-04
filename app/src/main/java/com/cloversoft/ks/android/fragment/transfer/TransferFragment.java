package com.cloversoft.ks.android.fragment.transfer;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.SpeedActivity;
import com.cloversoft.ks.android.activity.TransferActivity;
import com.cloversoft.ks.android.adapter.HomeGameRecyclerViewAdapter;
import com.cloversoft.ks.android.adapter.TransferGameBalanceAdapter;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.Spinner1Model;
import com.cloversoft.ks.data.model.api.Spinner2Model;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.server.request.Game;
import com.cloversoft.ks.server.request.Transfer;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.JavaUtils;
import com.cloversoft.ks.vendor.android.java.Log;
import com.cloversoft.ks.vendor.android.widget.CustomOnItemSelectedListener;
import com.cloversoft.ks.vendor.server.transformer.CollectionTransformer;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.aakira.expandablelayout.ExpandableWeightLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


public class TransferFragment extends BaseFragment implements View.OnClickListener, TransferGameBalanceAdapter.ClickListener{
    public static final String TAG = TransferFragment.class.getName().toString();

    private TransferActivity transferActivity;
    public static final String MyPREFERENCES = "MyPrefs";
    private TransferGameBalanceAdapter transferGameBalanceAdapter;
    private LinearLayoutManager linearLayoutManager;
    private String gameBal;
    private int gameID;
    boolean flag = true;
    private ArrayAdapter<Spinner1Model> adapter;
    private ArrayAdapter<Spinner2Model> adapter2;

    @BindView(R.id.swapBTN)                         ImageView swapBTN;
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
    @BindView(R.id.spinner2)                        Spinner spinner2;
    @BindView(R.id.maxBTN)                          TextView maxBTN;
    @BindView(R.id.submitBTN)                       TextView submitBTN;
    @BindView(R.id.gameBalanceRV)                   RecyclerView gameBalanceRV;
    @BindView(R.id.expandableLayout)                ExpandableRelativeLayout expandableLayout;
    @BindView(R.id.toggleBTN)                       ImageView toggleBTN;
    @BindView(R.id.toggleBTNDown)                   ImageView toggleBTNDown;
    @BindView(R.id.toggleLayout)                    Button toggleLayout;
    @BindView(R.id.ammountET)                       EditText ammountET;
    @BindView(R.id.money100)                        TextView money100;
    @BindView(R.id.money500)                        TextView money500;
    @BindView(R.id.money2000)                        TextView money2000;
    @BindView(R.id.money3000)                        TextView money3000;
    @BindView(R.id.money5000)                        TextView money5000;


    public static TransferFragment newInstance() {
        TransferFragment fragment = new TransferFragment();
        return fragment;

    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_transfer;
    }

    @Override
    public void onViewReady() {
        transferActivity = (TransferActivity) getContext();
        swapBTN.setOnClickListener(this);
        maxBTN.setOnClickListener(this);
        toggleLayout.setOnClickListener(this);
        submitBTN.setOnClickListener(this);
        money100.setOnClickListener(this);
        money500.setOnClickListener(this);
        money2000.setOnClickListener(this);
        money3000.setOnClickListener(this);
        money5000.setOnClickListener(this);
        SharedPreferences prefs = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String user = prefs.getString("account_key", "none");
        String pass = prefs.getString("pass_key", "none");
        Auth.getDefault().userInfo(getContext(),user, pass, JavaUtils.md5());
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
//        setUpListView();
//        gameBalanceRV.setNestedScrollingEnabled(false);
        expandableLayout.collapse();
        setData();
        setDataSpinner1();



    }

    private void setData() {
        ArrayList<Spinner2Model> countryList = new ArrayList<>();
        //Add countries

        countryList.add(new Spinner2Model("102", "AG亚游"));
        countryList.add(new Spinner2Model("107", "欧博真人"));
        countryList.add(new Spinner2Model("108", "大游真人"));
        countryList.add(new Spinner2Model("0", "大游真人"));
        countryList.add(new Spinner2Model("501", "开元棋牌"));
        countryList.add(new Spinner2Model("604", "双赢棋牌"));
        countryList.add(new Spinner2Model("106", "EB真人"));
        countryList.add(new Spinner2Model("104", "OG真人"));
        countryList.add(new Spinner2Model("207", "PT电子"));
        countryList.add(new Spinner2Model("201", "欧洲PT"));
        countryList.add(new Spinner2Model("202", "MG电子"));
        countryList.add(new Spinner2Model("614", "QT电子"));
        countryList.add(new Spinner2Model("103", "IM平台"));
        countryList.add(new Spinner2Model("0", "沙巴平台"));
        countryList.add(new Spinner2Model("0", "BTI体育"));
        countryList.add(new Spinner2Model("613", "CQ电子"));
        countryList.add(new Spinner2Model("607", "泛亚电竞"));
        countryList.add(new Spinner2Model("610", "泛亚捕鱼"));
        countryList.add(new Spinner2Model("603", "TF电竞"));
        countryList.add(new Spinner2Model("602", "VR彩票"));
        countryList.add(new Spinner2Model("601", "IG彩票"));
        countryList.add(new Spinner2Model("609", "TCG彩票"));
        countryList.add(new Spinner2Model("606", "LB快乐彩"));
        countryList.add(new Spinner2Model("605", "双赢彩票"));

        //fill data in spinner
        adapter2 = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, countryList);
        spinner2.setAdapter(adapter2);
//        spinner2.setSelection(adapter.getPosition(myItem));//Optional to set the selected item.
    }

    private void setDataSpinner1(){
        ArrayList<Spinner1Model> countryList = new ArrayList<>();
        //Add countries

        countryList.add(new Spinner1Model("中心钱包"));

        //fill data in spinner
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, countryList);
        spinner1.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        transferActivity.setTitle("转账");
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
            case R.id.money100:
                ammountET.setText("100");
                break;
            case R.id.money500:
                ammountET.setText("500");
                break;
            case R.id.money2000:
                ammountET.setText("2000");
                break;
            case R.id.money3000:
                ammountET.setText("3000");
                break;
            case R.id.money5000:
                ammountET.setText("5000");
                break;
            case R.id.swapBTN:
                if(spinner1.getSelectedItem().toString().equalsIgnoreCase("中心钱包")){
                    spinner1.setAdapter(adapter2);
                    spinner2.setAdapter(adapter);
                }
                else{
                    spinner1.setAdapter(adapter);
                    spinner2.setAdapter(adapter2);
                }

                break;
            case R.id.submitBTN:
                int a = 0;
                int b = 2;
                int h = 1;
                if(spinner1.getSelectedItem().toString().equalsIgnoreCase("中心钱包")){
                    Spinner2Model country = (Spinner2Model) spinner2.getSelectedItem();
                    int j = Integer.valueOf(country.getId() + a + h);
                    Transfer.getDefault().transfer(getContext(),user,pass,JavaUtils.md5(),ammountET.getText().toString(),true,j);

                }
                else{
                    Spinner2Model country1 = (Spinner2Model) spinner1.getSelectedItem();
                    int k = Integer.valueOf(country1.getId() + a+b);
                    Transfer.getDefault().transfer(getContext(),user,pass,JavaUtils.md5(),ammountET.getText().toString(),false,k);
            }
                break;
            case R.id.maxBTN:
                ammountET.setText(balanceTXT.getText().toString().substring(1));
                break;
        }
    }

    @Override
    public void onItemClick(GameListModel gameListModel) {

    }
}
