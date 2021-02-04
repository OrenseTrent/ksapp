package com.cloversoft.ks.android.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.GameListModel;
import com.cloversoft.ks.data.model.api.SampleModel;
import com.cloversoft.ks.vendor.android.base.BaseListViewAdapter;

import butterknife.BindView;


public class DefaultListViewAdapter extends BaseListViewAdapter<DefaultListViewAdapter.ViewHolder, SampleModel> {

    private ClickListener clickListener;

    public DefaultListViewAdapter(Context context) {
        super(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(getDefaultView(parent, R.layout.adapter_default));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.nameTXT.setText("Position " + holder.getItem().id);
    }

    public class ViewHolder extends BaseListViewAdapter.ViewHolder{

        @BindView(R.id.nameTXT)     TextView nameTXT;

        public ViewHolder(View view) {
            super(view);
        }

        public SampleModel getItem() {
            return (SampleModel) super.getItem();
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(SampleModel gameListModel);
    }
} 
