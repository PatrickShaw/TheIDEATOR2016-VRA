package com.ideator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class FooterViewHolder extends RecyclerView.ViewHolder {
    private FrameLayout mLayoutFooter;
    public FooterViewHolder(View itemView) {
        super(itemView);
        mLayoutFooter = (FrameLayout)itemView.findViewById(R.id.layout_footer);
    }
    public void bindData(boolean isLoading) {
        itemView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }
}
