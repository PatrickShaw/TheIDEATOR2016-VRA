package com.ideator;

import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class RecentUploadsFragment extends EndlessScrollerFragment<Date, VideoRecyclerView>{
    public static RecentUploadsFragment newInstance()
    {
        return new RecentUploadsFragment();
    }
    @Override
    protected Drawable getEmptyStateIcon() {
        return ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default);
    }

    @Override
    protected String getEmptyStateMessage() {
        return "rawr";
    }

    @Override
    protected VideoRecyclerView getRecyclerAdapter() {
        return new VideoRecyclerView(mValues);
    }

    @Override
    protected void onCreateRecyclerView(RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpacingItemDecoration(getContext(), R.dimen.layout_padding, 1));
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,4,23);
        mValues.add(calendar.getTime());
        calendar.set(2016,2,23);
        mValues.add(calendar.getTime());
        calendar.set(2016,2,10);
        mValues.add(calendar.getTime());
        calendar.set(2016,1,23);
        mValues.add(calendar.getTime());
    }

    @Override
    protected int getLoadingThresholdIndex() {
        return 0;
    }

    @Override
    protected String getLoadMoreItemsRequestTag() {
        return null;
    }

    @Override
    public String[] onCancelRequests() {
        return new String[0];
    }
}
