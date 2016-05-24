package com.ideator;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */

public abstract class EndlessScrollerAdapter<T extends RecyclerView.ViewHolder,D> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected List<D> mValues;

    private static final int TYPE_FOOTER = -1239112;
    private static final int TYPE_HEADER = -1231;
    private boolean isLoading = false;
    public EndlessScrollerAdapter(List<D> items) {
        this.mValues = items;
    }
    public void setItems(List<D> items) {
        this.mValues = items;
        notifyDataSetChanged();
    }
    public final void setIsLoading(boolean isLoading)
    {
        if(this.isLoading == isLoading){return;}
        this.isLoading = isLoading;
        // Notify that the loading view holder was inserted/removed
        if (isLoading) {
            notifyItemInserted(getListItemCount());
        }
        else
        {
            notifyItemRemoved(getListItemCount());
        }
    }
    protected View inflateFooterView(ViewGroup parent)
    {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_item, parent, false);
    }
    protected RecyclerView.ViewHolder createFooterViewHolder(View view)
    {
        return new FooterViewHolder(view);
    }
    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("Activity Recycler", "Creating view...");
        View view;
        RecyclerView.ViewHolder holder;
        switch(viewType)
        {
            case TYPE_FOOTER:
                view = inflateFooterView(parent);
                holder = createFooterViewHolder(view);
                break;
            default:
                holder = onCreateNonFooterViewHolder(parent, viewType);
                break;
        }
        return holder;
    }
    public abstract T onCreateNonFooterViewHolder(ViewGroup parent, int viewType);

    public final void updateItem(int index, D item)
    {
        mValues.set(index, item);
        notifyItemChanged(index);
    }

    public final void insertItem(int index, D item)
    {
        mValues.add(index, item);
    }

    @Override
    public final void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {
        if(!isFooter(position)) {
            onBindNonFooterViewHolder((T)viewHolder, position);
        }
        else
        {
            FooterViewHolder footerViewHolder = (FooterViewHolder)viewHolder;
            footerViewHolder.bindData(isLoading);
        }
    }
    public abstract void onBindNonFooterViewHolder(final T viewHolder, int position);
    @Override
    public final int getItemViewType(int position)
    {
        //Log.d("Activity Recycler", "Activity Position: " + Integer.toString(position));
        if(isFooter(position))
        {
            return TYPE_FOOTER;
        }
        int viewType = getNonFooterItemViewType(position);
        if(viewType == TYPE_FOOTER){Log.w("EndlessScrollerAdapter", "WARNING: A viewType that was not the footer had the same value as the footer.");}
        return viewType;
    }
    public abstract int getNonFooterItemViewType(int position);
    public int getListItemCount()
    {
        return mValues.size();
    }
    @Override
    public final int getItemCount() {
        if (isLoading) {
            return getListItemCount() + 1;
        }
        else
        {
            return getListItemCount();
        }
    }

    private boolean isFooter(int position)
    {
        return position == getListItemCount();
    }
}
