package com.cloversoft.ks.android.activity;


import com.cloversoft.ks.R;
import com.cloversoft.ks.android.fragment.transfer.TransferFragment;
import com.cloversoft.ks.android.route.RouteActivity;

public class TransferActivity extends RouteActivity {
    public static final String TAG = TransferActivity.class.getName().toString();

    @Override
    public int onLayoutSet() {
        return R.layout.activity_transfer;
    }

    @Override
    public void onViewReady() {

    }

    @Override
    public void initialFragment(String activityName, String fragmentName) {
        switch (fragmentName){
            case "transfer":
                openTransferFragment();
                break;

        }
    }

    public void openTransferFragment(){ switchFragment(TransferFragment.newInstance()); }


}
