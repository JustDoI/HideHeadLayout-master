package com.rxy.hideheadlayout_master.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rxy.hideheadlayout_master.R;

/**
 * Created by rxy on 15/7/2.
 * E－mail:rxywxsy@163.com
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView _textView;
    public RecyclerViewHolder(View itemView,TextView mTextView) {
        super(itemView);
        _textView=mTextView;
    }

    public RecyclerViewHolder(View itemView) {
        super(itemView);
    }

    public static RecyclerViewHolder getInstance(View view){
        TextView pTextView= (TextView) view.findViewById(R.id.itemTextView);
       return new RecyclerViewHolder(view,pTextView);
    }

    public void setText(String item){
        _textView.setText(item);
    }
}
