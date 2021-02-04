package com.cloversoft.ks.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;


import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.BankListModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpinnerAdapters extends ArrayAdapter {
    private Context context;
    private List<BankListModel> data;
    private LayoutInflater layoutInflater;

    public SpinnerAdapters(Context context) {
        super(context, R.layout.adapter_spinner);
        this.context = context;
        this.data = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    public void setNewData(List<BankListModel> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.adapter_spinner, parent, false);

        TextView spinner = convertView.findViewById(R.id.spinnerTXT);
        spinner.setText(data.get(position).bankName);
        spinner.setTextSize(16);
        return spinner;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    public BankListModel getProduct(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.adapter_spinner, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.string = data.get(position).bankName;
        holder.spinnerTXT.setText(holder.string);
        holder.spinnerTXT.setTextColor(ActivityCompat.getColor(getContext(),R.color.black_txt));
        holder.spinnerTXT.setTextSize(16);
        return convertView;
    }

    public class ViewHolder{
        String string;

        @BindView(R.id.spinnerTXT)
        TextView spinnerTXT;
        View view;

        public ViewHolder(View view) {
            this.view = view;
            ButterKnife.bind(this, view);
        }
    }
}
