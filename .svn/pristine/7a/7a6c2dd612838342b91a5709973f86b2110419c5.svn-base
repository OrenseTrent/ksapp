package com.cloversoft.ks.vendor.android.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.cloversoft.ks.R;
import com.cloversoft.ks.vendor.android.java.Log;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import icepick.Icepick;



public class BaseDialog extends DialogFragment {
	private Unbinder unbinder;
	private Context context;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Icepick.restoreInstanceState(this, savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(onLayoutSet(), container, false);
		bindView(view);
		context = getActivity();
		onViewReady();
		onViewReady(savedInstanceState);
		return view;
	}

	public Context getContext(){
		return context;
	}

	public int onLayoutSet(){
		return R.layout.dialog_default;
	}

	public void setDialogMatchParent(){
		Dialog dialog = getDialog();
		if (dialog != null) {
			dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		}
	}

	public void setDialogWrapContent(){
		Dialog dialog = getDialog();
		if (dialog != null) {
			dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		}
	}

	public void setDialogLayoutParam(int width, int height){
		Dialog dialog = getDialog();
		if (dialog != null) {
			dialog.getWindow().setLayout(width, height);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return dialog;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		Icepick.saveInstanceState(this, outState);
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onDestroyView() {
		unbindView();
		super.onDestroyView();
	}

	public void onViewReady(){

	}

	public void onViewReady(Bundle savedInstanceState){

	}

	private void bindView(View view){
		unbinder = ButterKnife.bind(this, view);
	}

	private void unbindView(){
		unbinder.unbind();
	}

	public BaseActivity getBaseActivity(){
		return (BaseActivity)getContext();
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		List<Fragment> fragments = getChildFragmentManager().getFragments();
		if (fragments != null) {
			for (Fragment fragment : fragments) {
				fragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
			}
		}
	}

	public void dd(String message){
		dd("Default", message);
	}

	public void dd(String tag, String message){
		Log.dd(tag, message);
	}

}
