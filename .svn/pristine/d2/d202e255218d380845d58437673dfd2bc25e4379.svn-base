package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.MessageModel;
import com.cloversoft.ks.data.model.api.PlayGameModel;
import com.cloversoft.ks.data.model.api.PromotionModel;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter;

import butterknife.BindView;


public class MessageRecyclerViewAdapter extends BaseRecylerViewAdapter<MessageRecyclerViewAdapter.ViewHolder, MessageModel>{

    private ClickListener clickListener;

    public MessageRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_message));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.adapterCON.setTag(holder.getItem());
        holder.adapterCON.setOnClickListener(this);
        holder.titleTXT.setText(holder.getItem().record.get(0).messageTitle);
        holder.timeTXT.setText(holder.getItem().record.get(0).addTime);
    }

    public class ViewHolder extends BaseRecylerViewAdapter.ViewHolder{

        @BindView(R.id.titleTXT)                TextView titleTXT;
        @BindView(R.id.timeTXT)                 TextView timeTXT;
        @BindView(R.id.adapterCON)              View adapterCON;

        public ViewHolder(View view) {
            super(view);
        }

        public MessageModel getItem() {
            return (MessageModel) super.getItem();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.adapterCON:
                if (clickListener != null){
                    clickListener.onItemClick((MessageModel) v.getTag());

                }
                break;
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(MessageModel messageModel);
    }
} 
