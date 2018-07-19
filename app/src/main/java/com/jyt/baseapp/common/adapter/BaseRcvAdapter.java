package com.jyt.baseapp.common.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.jyt.baseapp.common.view.viewholder.BaseViewHolder;

import java.util.List;

/**
 * Created by chenweiqi on 2017/10/30.
 */

public abstract class BaseRcvAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    List dataList;
    BaseViewHolder.OnViewHolderClickListener onViewHolderClickListener;
    BaseViewHolder.OnViewHolderClickListener onViewHolderLongClickListener;

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public void setOnViewHolderClickListener(BaseViewHolder.OnViewHolderClickListener onViewHolderClickListener) {
        this.onViewHolderClickListener = onViewHolderClickListener;
    }

    public void setOnViewHolderLongClickListener(BaseViewHolder.OnViewHolderClickListener onViewHolderLongClickListener) {
        this.onViewHolderLongClickListener = onViewHolderLongClickListener;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder  = createCustomViewHolder(parent,viewType);
        holder.setOnViewHolderClickListener(onViewHolderClickListener);
        holder.setOnViewHolderLongClickListener(onViewHolderLongClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        if (dataList!=null){
            return dataList.size();
        }
        return 0;
    }
    abstract BaseViewHolder createCustomViewHolder(ViewGroup parent, int viewType);
}
