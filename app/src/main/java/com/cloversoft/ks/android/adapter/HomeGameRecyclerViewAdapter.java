package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter;

import butterknife.BindView;


public class HomeGameRecyclerViewAdapter extends BaseRecylerViewAdapter<HomeGameRecyclerViewAdapter.ViewHolder, GameListModel> {

    private ClickListener clickListener;

    public HomeGameRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_home_gamer));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.adapterCON.setTag(holder.getItem());
        holder.adapterCON.setOnClickListener(this);

//        holder.nameTXT.setText("Position " + holder.getItem().id);
        holder.imageView.setImageResource(holder.getItem().image);
//        Glide.with(getContext()).load(R.drawable.cas1).centerCrop().into(holder.imageView);


    }

    public class ViewHolder extends BaseRecylerViewAdapter.ViewHolder{

        @BindView(R.id.imageView)       ImageView imageView;
        @BindView(R.id.adapterCON)  View adapterCON;

        public ViewHolder(View view) {
            super(view);
        }

        public GameListModel getItem() {
            return (GameListModel) super.getItem();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.adapterCON:
                if (clickListener != null){
                    clickListener.onItemClick((GameListModel) v.getTag());
                }
                break;
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(GameListModel gameListModel);
    }
} 
