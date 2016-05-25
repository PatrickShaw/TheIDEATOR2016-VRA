package com.ideator;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */

public class SpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int mGridSpacingDimen;
    private int mSpanCount;

    private boolean mNeedLeftSpacing = false;

    public SpacingItemDecoration(Context context, int spacingdimenId, int spanCount) {
        mGridSpacingDimen = (int)context.getResources().getDimension(spacingdimenId);
        mSpanCount = spanCount;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int frameWidth = (int) ((parent.getWidth() - (float) mGridSpacingDimen * (mSpanCount - 1)) / mSpanCount);
        int padding = parent.getWidth() / mSpanCount - frameWidth;
        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
        if (itemPosition < mSpanCount) {
            outRect.top = 0;
        } else {
            outRect.top = mGridSpacingDimen;
        }
        if (itemPosition % mSpanCount == 0) {
            outRect.left = 0;
            outRect.right = padding;
            mNeedLeftSpacing = true;
        } else if ((itemPosition + 1) % mSpanCount == 0) {
            mNeedLeftSpacing = false;
            outRect.right = 0;
            outRect.left = padding;
        } else if (mNeedLeftSpacing) {
            mNeedLeftSpacing = false;
            outRect.left = mGridSpacingDimen - padding;
            if ((itemPosition + 2) % mSpanCount == 0) {
                outRect.right = mGridSpacingDimen - padding;
            } else {
                outRect.right = mGridSpacingDimen / 2;
            }
        } else if ((itemPosition + 2) % mSpanCount == 0) {
            mNeedLeftSpacing = false;
            outRect.left = mGridSpacingDimen / 2;
            outRect.right = mGridSpacingDimen - padding;
        } else {
            mNeedLeftSpacing = false;
            outRect.left = mGridSpacingDimen / 2;
            outRect.right = mGridSpacingDimen / 2;
        }
        outRect.bottom = 0;
    }
}

