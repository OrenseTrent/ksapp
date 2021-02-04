package com.cloversoft.ks.android.fragment.customer;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.Formatter;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;


public class CustomerServiceFragment extends BaseFragment {
    public static final String TAG = CustomerServiceFragment.class.getName().toString();

    private MainActivity mainActivity;


    @BindView(R.id.webView)     WebView webView;
    @BindView(R.id.titleBarTxt) 	TextView titleBarTxt;
    @BindView(R.id.progressBar)         ProgressBar progressBar;
    @BindView(R.id.titleBarURLTxt) 	TextView titleBarURLTxt;


    public static CustomerServiceFragment newInstance() {
        CustomerServiceFragment fragment = new CustomerServiceFragment();
        return fragment;
    }


    @Override
    public int onLayoutSet() {
        return R.layout.fragment_customer_service;
    }

    @Override
    public void onViewReady() {
        mainActivity = (MainActivity) getContext();


        progressBar.setMax(100);
        progressBar.setProgress(0);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webView.loadUrl("https://sdfgsdgsg78dfdfec.chat66a.com/chat/text/chat_1txUgQ.html");
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {

                if(progressBar != null){
                    if(newProgress < 100){
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setProgress(newProgress);
                    }else{
                        progressBar.setVisibility(View.GONE);
                        titleBarTxt.setText(view.getTitle());
                        titleBarURLTxt.setText(Formatter.getDomainFromURL(view.getOriginalUrl()));
                    }
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
    }

    @Override
    public void onResume() {
        super.onResume();
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


}
