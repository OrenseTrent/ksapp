package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.MessageModel;
import com.cloversoft.ks.data.model.api.SpecificMsgModel;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter;

import butterknife.BindView;


public class MessageSpecRecyclerViewAdapter extends BaseRecylerViewAdapter<MessageSpecRecyclerViewAdapter.ViewHolder, SpecificMsgModel>{

    private ClickListener clickListener;

    public MessageSpecRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_specmessage));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.adapterCON.setTag(holder.getItem());
        holder.adapterCON.setOnClickListener(this);
        holder.titleTXT.setText(holder.getItem().messageTitle);
        holder.timeTXT.setText(holder.getItem().addTime);
        holder.contentTXT.setVisibility(View.VISIBLE);
        holder.contentTXT.setText(holder.getItem().messageContent);
    }

    public class ViewHolder extends BaseRecylerViewAdapter.ViewHolder{

        @BindView(R.id.titleTXT)                TextView titleTXT;
        @BindView(R.id.timeTXT)                 TextView timeTXT;
        @BindView(R.id.contentTXT)                 TextView contentTXT;
        @BindView(R.id.adapterCON)              View adapterCON;

        public ViewHolder(View view) {
            super(view);
        }

        public SpecificMsgModel getItem() {
            return (SpecificMsgModel) super.getItem();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.adapterCON:
                if (clickListener != null){
                    clickListener.onItemClick((SpecificMsgModel) v.getTag());
                }
                break;
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(SpecificMsgModel specificMsgModel);
    }
} 
