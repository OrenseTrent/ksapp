package com.cloversoft.ks.android.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.activity.GameActivity;
import com.cloversoft.ks.android.activity.MainActivity;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.UserInfoModel;
import com.cloversoft.ks.data.preference.UserData;
import com.cloversoft.ks.server.request.Auth;
import com.cloversoft.ks.server.request.Game;
import com.cloversoft.ks.vendor.android.base.BaseDialog;
import com.cloversoft.ks.vendor.android.base.BaseFragment;
import com.cloversoft.ks.vendor.android.java.Formatter;
import com.cloversoft.ks.vendor.android.java.ToastMessage;
import com.cloversoft.ks.vendor.server.transformer.SingleTransformer;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import icepick.State;

public class WebViewDialog extends BaseFragment implements View.OnClickListener, PopupMenu.OnMenuItemClickListener{
	public static final String TAG = WebViewDialog.class.getName();

	private  Callback callback;
	private GameActivity gameActivity;

	@State String url;
	@State int id;
	@State String newURL;
	@State String title;

	@BindView(R.id.webView) 					WebView webView;
//	@BindView(R.id.toolbar) 					Toolbar toolbar;
	@BindView(R.id.titleBarTxt) 				TextView titleBarTxt;
//	@BindView(R.id.otherOptionBTN) 				View otherOptionBTN;
	@BindView(R.id.progressBar) 				ProgressBar progressBar;
	@BindView(R.id.closeBTN) 					View closeBTN;
	@BindView(R.id.refBTN) 						ImageView refBTN;
	@BindView(R.id.fullBTN) 						ImageView fullBTN;

	public static WebViewDialog newInstance(String title,String url) {
		WebViewDialog webViewDialog = new WebViewDialog();
//		webViewDialog.id = id;
		webViewDialog.title = title;
		webViewDialog.url = url;
		return webViewDialog;
	}

	@Override
	public int onLayoutSet() {
		return R.layout.dialog_web_view;
	}

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onViewReady() {
		gameActivity = (GameActivity) getContext();
        closeBTN.setOnClickListener(this);
		refBTN.setOnClickListener(this);
		fullBTN.setOnClickListener(this);
		progressBar.setMax(100);
		progressBar.setProgress(0);

		titleBarTxt.setText(title);

		WebSettings webSettings = webView.getSettings();
//		webSettings.setSupportZoom(true);
		webSettings.setSupportZoom(true);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
		webSettings.setPluginState(WebSettings.PluginState.ON);
		webSettings.setDomStorageEnabled(true);
		webView.loadUrl(url);
		webView.setWebViewClient(new WebViewClient());
		titleBarTxt.setText(title);
//		webView.setWebChromeClient(new WebChromeClient(){
//			@Override
//			public void onProgressChanged(WebView view, int newProgress) {
//
//				if(progressBar != null){
//					if(newProgress < 100){
//						progressBar.setVisibility(View.VISIBLE);
//						progressBar.setProgress(newProgress);
//					}else{
//						progressBar.setVisibility(View.GONE);
//						titleBarTxt.setText(view.getTitle());
////						titleBarURLTxt.setText(Formatter.getDomainFromURL(view.getOriginalUrl()));
//						newURL = view.getOriginalUrl();
//					}
//				}
//				super.onProgressChanged(view, newProgress);
//			}
//		});



	}


	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.closeBTN:
				gameActivity.onBackPressed();
				break;
			case R.id.refBTN:
				webView.reload();
				break;
			case R.id.fullBTN:
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
				webView.setLayoutParams(params);
				break;
		}
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		switch (item.getItemId()){

		}
		return false;
	}


	public  interface  Callback{
	    void onSuccess(String url);
    }

}
