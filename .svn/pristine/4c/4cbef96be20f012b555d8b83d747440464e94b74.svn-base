package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.PromotionModel;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter;

import butterknife.BindView;


public class PromotionRecyclerViewAdapter extends BaseRecylerViewAdapter<PromotionRecyclerViewAdapter.ViewHolder, PromotionModel> {

    private ClickListener clickListener;

    public PromotionRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_promotions));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.adapterCON.setTag(holder.getItem());
        holder.adapterCON.setOnClickListener(this);
//        holder.nameTXT.setText("Position " + holder.getItem().id);
//        holder.imageView.setImageResource(holder.getItem().imgUrl);
        holder.promoNameTXT.setText(holder.getItem().title);
        Glide.with(getContext()).load(holder.getItem().imgUrl).fitCenter().into(holder.imageView);


    }

    public class ViewHolder extends BaseRecylerViewAdapter.ViewHolder{

        @BindView(R.id.imageView)               ImageView imageView;
        @BindView(R.id.promoNameTXT)            TextView promoNameTXT;
        @BindView(R.id.adapterCON)              View adapterCON;

        public ViewHolder(View view) {
            super(view);
        }

        public PromotionModel getItem() {
            return (PromotionModel) super.getItem();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.adapterCON:
                if (clickListener != null){
                    clickListener.onItemClick((PromotionModel) v.getTag());
                }
                break;
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(PromotionModel promotionModel);
    }
} 
