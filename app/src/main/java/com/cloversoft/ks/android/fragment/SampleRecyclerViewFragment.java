package com.cloversoft.ks.android.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.android.adapter.DefaultRecyclerViewAdapter;
import com.cloversoft.ks.vendor.android.base.BaseFragment;

import butterknife.BindView;



public class SampleRecyclerViewFragment extends BaseFragment {
    public static final String TAG = SampleRecyclerViewFragment.class.getName().toString();

    private DefaultRecyclerViewAdapter defaultRecyclerViewAdapter;
    private LinearLayoutManager linearLayoutManager;

    @BindView(R.id.defaultRV)  RecyclerView defaultRV;

    public static SampleRecyclerViewFragment newInstance() {
        SampleRecyclerViewFragment fragment = new SampleRecyclerViewFragment();
        return fragment;
    }

    @Override
    public int onLayoutSet() {
        return R.layout.fragment_recylerview;
    }

    @Override
    public void onViewReady() {
        setUpListView();
    }

    private void setUpListView(){
        defaultRecyclerViewAdapter = new DefaultRecyclerViewAdapter(getContext());
//        defaultRecyclerViewAdapter.setNewData(getDefaultData());
        linearLayoutManager = new LinearLayoutManager(getContext());
        defaultRV.setLayoutManager(linearLayoutManager);
        defaultRV.setAdapter(defaultRecyclerViewAdapter);
    }

//    private List<SampleModel> getDefaultData(){
//        List<SampleModel> androidModels = new ArrayList<>();
//        SampleModel defaultItem;
//        for(int i = 0; i < 20; i++){
//            defaultItem = new SampleModel();
//            defaultItem.id = i;
//            defaultItem.name = "name " + i;
//            androidModels.add(defaultItem);
//        }
//        return androidModels;
//    }
}
