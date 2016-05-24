package com.ideator;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class VerticalSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int mVerticalSpaceHeight;
    public VerticalSpacingItemDecoration(Context context, int heightResource)
    {
        this.mVerticalSpaceHeight = (int)context.getResources().getDimension(heightResource);
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        outRect.bottom = mVerticalSpaceHeight;
    }
}
