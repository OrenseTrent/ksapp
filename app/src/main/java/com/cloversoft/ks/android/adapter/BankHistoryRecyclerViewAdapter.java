package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.BankHistoryMain;
import com.cloversoft.ks.data.model.api.BankHistoryModel;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter;
import com.cloversoft.ks.vendor.android.base.BaseRecylerViewAdapter2;
import com.cloversoft.ks.vendor.android.java.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class BankHistoryRecyclerViewAdapter extends BaseRecylerViewAdapter<BankHistoryRecyclerViewAdapter.ViewHolder, BankHistoryModel> {

    private ClickListener clickListener;

    public BankHistoryRecyclerViewAdapter(Context context) {
        super(context);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_bank_list));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.adapterCON.setTag(holder.getItem());
        holder.adapterCON.setOnClickListener(this);

//        String number = holder.getItem().getInfo().getRecord().get(position).getBankNo();
//        String mask = number.replaceAll("\\w(?=\\w{4})", "*");
//        holder.cardTXT.setText(mask);
//        holder.amountTXT.setText(holder.getItem().getInfo().getRecord().get(position).getAmount());
//        holder.dateTXT.setText(holder.getItem().getInfo().getRecord().get(position).getAddTime().substring(0,10));
//        holder.timeTXT.setText(holder.getItem().getInfo().getRecord().get(position).getAddTime().substring(holder.getItem().getInfo().getRecord().get(position).getAddTime().length()-8));

        String number = holder.getItem().record.get(position).bankNo;
        String mask = number.replaceAll("\\w(?=\\w{4})", "*");
        holder.cardTXT.setText(mask);
        holder.amountTXT.setText(holder.getItem().record.get(position).amount);
        holder.dateTXT.setText(holder.getItem().record.get(position).addTime.substring(0,10));
        holder.timeTXT.setText(holder.getItem().record.get(position).addTime.substring(holder.getItem().record.get(position).addTime.length()-8));
//        for (int i = 0; i < holder.getItem().getRecord().size(); i++) {
//            String number = holder.getItem().getRecord().get(position).getBankNo();
//            String mask = number.replaceAll("\\w(?=\\w{4})", "*");
//            holder.cardTXT.setText(mask);
//            holder.amountTXT.setText(holder.getItem().getRecord().get(position).getAmount());
//            holder.dateTXT.setText(holder.getItem().getRecord().get(position).getAddTime().substring(0,10));
//            holder.timeTXT.setText(holder.getItem().getRecord().get(position).getAddTime().substring(holder.getItem().getRecord().get(position).getAddTime().length()-8));
//            Log.e("FORLOOP",holder.getItem().getRecord());
//        }



    }

    public class ViewHolder extends BaseRecylerViewAdapter.ViewHolder{

        @BindView(R.id.adapterCON)      View adapterCON;
        @BindView(R.id.cardTXT)         TextView cardTXT;
        @BindView(R.id.dateTXT)         TextView dateTXT;
        @BindView(R.id.timeTXT)         TextView timeTXT;
        @BindView(R.id.amountTXT)         TextView amountTXT;

        public ViewHolder(View view) {
            super(view);
        }

        public BankHistoryModel getItem() {
            return (BankHistoryModel) super.getItem();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.adapterCON:
                if (clickListener != null){
                    clickListener.onItemClick((BankHistoryModel) v.getTag());
                }
                break;
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(BankHistoryModel bankHistoryModel);
    }
} 
