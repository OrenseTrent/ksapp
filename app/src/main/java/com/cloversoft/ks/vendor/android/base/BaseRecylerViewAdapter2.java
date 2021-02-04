package com.cloversoft.ks.vendor.android.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cloversoft.ks.data.model.api.BankHistoryMain;
import com.cloversoft.ks.data.model.api.Record;
import com.cloversoft.ks.vendor.android.java.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseRecylerViewAdapter2<VH extends RecyclerView.ViewHolder, BankHistoryMain extends AndroidModel>
        extends RecyclerView.Adapter<VH>
        implements View.OnClickListener, View.OnLongClickListener {

    private Context context;
    private List<BankHistoryMain> data;
    private LayoutInflater layoutInflater;

    public BaseRecylerViewAdapter2(Context context) {
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }


    public void setNewData(List<BankHistoryMain> data){
        this.data = data;
        notifyDataSetChanged();
    }

    public void addNewData(List<BankHistoryMain> data){
        int initialCount = this.data.size();
        int newCount = 0;
        for(BankHistoryMain defaultItem : data){
            if(isDataUnique(defaultItem)){
                this.data.add(defaultItem);
                newCount++;
            }
        }
        notifyItemRangeChanged(initialCount, newCount);
    }


    public void removeItem(BankHistoryMain item) {
        for (BankHistoryMain defaultItem : data) {
            if (item.id == defaultItem.id) {
                int pos = data.indexOf(defaultItem);
                data.remove(pos);
                notifyItemRemoved(pos);
                notifyItemRangeChanged(pos, data.size());
                break;
            }
        }
    }

    public void updateItem(BankHistoryMain item){
        for(BankHistoryMain defaultItem : data){
            if (item.id == defaultItem.id) {
                int pos = data.indexOf(defaultItem);
                data.set(pos, item);
                notifyItemChanged(pos);
                break;
            }
        }
    }

    private boolean isDataUnique(BankHistoryMain item){
        for(BankHistoryMain defaultItem : this.data){
            if(item.id == defaultItem.id){
                return false;
            }
        }
        return true;
    }

    public Context getContext() {
        return context;
    }

    public LayoutInflater getLayoutInflater() {
        return layoutInflater;
    }

    public List<BankHistoryMain> getData() {
        return data;
    }


    public BankHistoryMain getItem(int position){
        return getData().get(position);
    }

    public View getDefaultView(ViewGroup parent, int resLayout){
        return getLayoutInflater().inflate(resLayout, parent, false);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return getData().size();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {

        return false;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Object object;
        private View view;
        private AndroidModel androidModel;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            bind(this, view);
        }

        public ViewHolder(View view, boolean bind) {
            super(view);
            this.view = view;
            if(bind){
                bind(this, view);
            }
        }

        public Unbinder bind(Object target, View view){
            return ButterKnife.bind(target, view);
        }

        public View getBaseView() {
            return view;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public Object getObject() {
            return object;
        }

        public void setItem(AndroidModel androidModel) {
            this.androidModel = androidModel;
        }

        public AndroidModel getItem() {
            return androidModel;
        }
    }

    public void dd(String message){
        dd("Default", message);
    }

    public void dd(String tag, String message){
        Log.dd(tag, message);
    }
}
