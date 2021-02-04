package com.cloversoft.ks.android.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;


import com.cloversoft.ks.R;
import com.cloversoft.ks.data.model.api.NavDrawerModel;
import com.cloversoft.ks.vendor.android.base.BaseListViewAdapter;

import butterknife.BindView;

public class DrawerAdapter extends BaseListViewAdapter<DrawerAdapter.ViewHolder, NavDrawerModel> implements View.OnClickListener
{
    private ClickListener clickListener;

    public DrawerAdapter(Context context) {
        super(context);
    }

    private int[] IconList = new int[]{R.drawable.ic_home, R.drawable.ic_settings};

    public void setSelectedItem(String item){
        for(NavDrawerModel navDrawerModel1 : getData()){
            navDrawerModel1.is_selected = navDrawerModel1.item.equalsIgnoreCase(item);
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ViewHolder(getDefaultView (parent, R.layout.adapter_drawer_item));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setItem(getItem(position));
        holder.getBaseView().setOnClickListener(this);
        holder.drawerTXT.setText(holder.getItem().item);
        holder.navIconIV.setImageResource(IconList[position]);

        if (holder.getItem().is_selected| holder.getItem().is_selected) {
//            holder.navIconIV.setColorFilter(getContext().getResources().getColor(R.color.white));
            holder.drawerTXT.setTextColor(ActivityCompat.getColor(getContext(), R.color.white));
            holder.adapterCON.setBackground(ActivityCompat.getDrawable(getContext(), R.drawable.bg_color_accent));
        } else {
//            holder.navIconIV.setColorFilter(getContext().getResources().getColor(R.color.categoriesUnselected));
            holder.drawerTXT.setTextColor(ActivityCompat.getColor(getContext(), R.color.categoriesUnselected));
            holder.adapterCON.setBackground(ActivityCompat.getDrawable(getContext(), R.drawable.bg_ripple));
        }
    }

    public class ViewHolder extends BaseListViewAdapter.ViewHolder{

        @BindView(R.id.drawerTXT)       TextView drawerTXT;
        @BindView(R.id.navIconIV)       ImageView navIconIV;
        @BindView(R.id.adapterCON)      View adapterCON;


        public ViewHolder(View view) {
            super(view);
        }

        public NavDrawerModel getItem() {
            return (NavDrawerModel) super.getItem();
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(NavDrawerModel navDrawerModel);
    }

    @Override
    public void onClick(View v){
        ViewHolder viewHolder = (ViewHolder) v.getTag();
        if (clickListener != null){
            clickListener.onItemClick(viewHolder.getItem());
        }
    }
}
