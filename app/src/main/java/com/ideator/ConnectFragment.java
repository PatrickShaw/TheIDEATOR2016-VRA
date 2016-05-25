package com.ideator;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class ConnectFragment extends EndlessScrollerFragment<FakeData, FakeRecylcerViewAdapter> {
    public static ConnectFragment newInstance()
    {
        ConnectFragment fragment = new ConnectFragment();
        return fragment;
    }
    @Override
    protected Drawable getEmptyStateIcon() {
        return ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default);
    }

    @Override
    protected String getEmptyStateMessage() {
        return "Rawr";
    }

    @Override
    protected FakeRecylcerViewAdapter getRecyclerAdapter() {
        return new FakeRecylcerViewAdapter(mValues);
    }

    @Override
    protected void onCreateRecyclerView(RecyclerView recyclerView) {
        recyclerView.addItemDecoration(new VerticalSpacingItemDecoration(getContext(), R.dimen.layout_padding));
        mValues.addAll(
                Arrays.asList(
                        new FakeData(ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default), null, new Date(), "rawr!", "Patrick", "Shaw"),
                        new FakeData(ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default), null, new Date(), "Wot?!", "David", "Lei"),
                        new FakeData(ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default), null, new Date(), "rawr!", "Patrick", "Shaw"),
                        new FakeData(ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default), null, new Date(), "rawr!", "Patrick", "Shaw"),
                        new FakeData(ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default), null, new Date(), "rawr!", "Patrick", "Shaw")
                )
        );
    }

    @Override
    protected int getLoadingThresholdIndex() {
        return 5;
    }

    @Override
    protected String getLoadMoreItemsRequestTag() {
        return "";
    }

    @Override
    public String[] onCancelRequests() {
        return new String[0];
    }
}
