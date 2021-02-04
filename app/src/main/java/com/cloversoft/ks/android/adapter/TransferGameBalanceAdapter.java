package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import butterknife.BindView;


public class TransferGameBalanceAdapter extends BaseRecylerViewAdapter<TransferGameBalanceAdapter.ViewHolder, GameListModel> {

    private ClickListener clickListener;
    boolean flag = true;

    public TransferGameBalanceAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_transfer));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.adapterCON.setTag(holder.getItem());
        holder.adapterCON.setOnClickListener(this);
        holder.toggleLayout.setOnClickListener(this);
        holder.expandableLayout.expand();

        holder.nameTXT.setText(holder.getItem().name);
//        if(holder.getItem().info == null){
//            holder.balanceTXT.setText("0.00");
//        }
//        else{
            holder.balanceTXT.setText(holder.getItem().info);

//        }
//        holder.sampleTXT.setText(holder.getItem().name);
//        holder.sampleTXT.setText(holder.getItem().info);
//        holder.nameTXT.setText("Position " + holder.getItem().id);
//        Glide.with(getContext()).load(R.drawable.cas1).centerCrop().into(holder.imageView);

        if(flag){
            holder.toggleBTN.setVisibility(View.VISIBLE);
            holder.toggleBTNDown.setVisibility(View.GONE);
            holder.expandableLayout.toggle();
            flag=false;
        }
        else{
            holder.toggleBTN.setVisibility(View.GONE);
            holder.toggleBTNDown.setVisibility(View.VISIBLE);
            holder.expandableLayout.toggle();
            flag=true;

        }
    }

    public class ViewHolder extends BaseRecylerViewAdapter.ViewHolder{

        @BindView(R.id.adapterCON)                      View adapterCON;
        @BindView(R.id.toggleBTN)                       ImageView toggleBTN;
        @BindView(R.id.toggleBTNDown)                   ImageView toggleBTNDown;
        @BindView(R.id.toggleLayout)                    Button toggleLayout;
        @BindView(R.id.expandableLayout)                ExpandableRelativeLayout expandableLayout;
        @BindView(R.id.nameTXT)                         TextView nameTXT;
        @BindView(R.id.balanceTXT)                      TextView balanceTXT;
        @BindView(R.id.sampleTXT)                      TextView sampleTXT;
        @BindView(R.id.infoTXT)                      TextView infoTXT;



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
