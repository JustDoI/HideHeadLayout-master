package com.rxy.hideheadlayout_master.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rxy.hideheadlayout_master.R;

import java.util.List;

/**
 * Created by rxy on 15/7/2.
 * E－mail:rxywxsy@163.com
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<String> _itemList;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;

    public RecyclerViewAdapter(List<String> _itemList) {
        this._itemList = _itemList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(context).inflate(R.layout.header_list_recyclerview, viewGroup, false);
            return new RecyclerViewHolder(view);
        } else if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_list_recyclerview, viewGroup, false);
            return RecyclerViewHolder.getInstance(view);
        }
        throw new RuntimeException("There is no type that matches the type " + viewType + " ,make sure your using types correctly");
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int position) {
        if (!isPositionHeader(position)) {
            String item = _itemList.get(position - 1);
            recyclerViewHolder.setText(item);
        }
    }

    @Override
    public int getItemCount() {
        return getBaseItemCount() + 1;
    }

    public int getBaseItemCount() {
        return _itemList == null ? 0 : _itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    public boolean isPositionHeader(int position) {
        return position == 0;
    }
}
