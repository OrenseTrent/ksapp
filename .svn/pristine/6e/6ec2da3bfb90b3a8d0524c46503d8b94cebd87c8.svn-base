package com.cloversoft.ks.android.fragment;

import android.widget.ListView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.adapter.DefaultListViewAdapter;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.SampleModel;
import com.cloversoft.ks.vendor.android.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import icepick.State;



public class SampleListViewFragment extends BaseFragment {
    public static final String TAG = SampleListViewFragment.class.getName().toString();

    private DefaultListViewAdapter defaultListViewAdapter;

    @BindView(R.id.defaultLV)       ListView defaultLV;

    @State String name;

    public static SampleListViewFragment newInstance() {
        SampleListViewFragment fragment = new SampleListViewFragment();
        return fragment;
    }

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_listview;
    }

    @Override
    public void onViewReady() {
        setUpListView();
    }

    private void setUpListView(){
        defaultListViewAdapter = new DefaultListViewAdapter(getContext());
        defaultListViewAdapter.setNewData(getDefaultData());
        defaultLV.setAdapter(defaultListViewAdapter);
    }

    private List<SampleModel> getDefaultData(){
        List<SampleModel> androidModels = new ArrayList<>();
        SampleModel defaultItem;
        for(int i = 0; i < 20; i++){
            defaultItem = new SampleModel();
            defaultItem.id = i;
//            defaultItem.name = "name " + i;
            androidModels.add(defaultItem);
        }
        return androidModels;
    }
}
