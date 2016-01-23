package com.example.niyamat.photoviewer;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Niyamat on 1/17/2016.
 */
public abstract class CustomRecyclerViewAdapter extends RecyclerView.Adapter {
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener;

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        mOnItemLongClickListener = onItemLongClickListener;
    }

    private void onItemHolderClick(CustomRecycleViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null,itemHolder.itemView,
                    itemHolder.getAdapterPosition(),itemHolder.getItemId());
        }
    }

    private void onItemHolderLongClick(CustomRecycleViewHolder itemHolder) {
        if (mOnItemLongClickListener != null) {
            mOnItemLongClickListener.onItemLongClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }

    public class CustomRecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {

        public CustomRecycleViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemHolderClick(this);
        }

        @Override
        public boolean onLongClick(View v) {
            onItemHolderLongClick(this);
            return true;
        }
    }
}
