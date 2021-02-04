package com.cloversoft.ks.android.dialog;

import com.cloversoft.ks.R;
import com.cloversoft.ks.vendor.android.base.BaseDialog;



public class DefaultDialog extends BaseDialog {
	public static final String TAG = DefaultDialog.class.getName().toString();

	public static DefaultDialog newInstance() {
		DefaultDialog dialog = new DefaultDialog();
		return dialog;
	}

	@Override
	public int onLayoutSet() {
		return R.layout.dialog_default;
	}

	@Override
	public void onViewReady() {

	}

	@Override
	public void onStart() {
		super.onStart();
		setDialogMatchParent();
	}
}
