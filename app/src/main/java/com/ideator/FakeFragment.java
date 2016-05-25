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
public class FakeFragment extends EndlessScrollerFragment<FakeData, FakeRecylcerViewAdapter> {
    public static FakeFragment newInstance()
    {
        FakeFragment fragment = new FakeFragment();

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


                    new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.aphro), new Date(3,2,2016), "Keith McBreif This puts him at a peak of rank 20 on the KR server " +
                            "http://www.op.gg/summoner/userName=%EB%A6%AD%20%ED%8F%AD%EC%8A%A4\n" +
                            "Edit: 1098 LP/Rank 9...", "Travis", "Peng"),

                    new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.patrickstar), new Date(15,5,2016), "Twinkle, twinkle, Patrick Star.\n" +
                            "I made myself a sandwich.\n" +
                            "My mommy named it Fred.\n" +
                            "It tastes like beans and bacon..."
                           , "Patrick", "Star"),

                    new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.ben), new Date(25,4,2016), "My Kitchen Rules grand final recap: no time for losers, who are the champions? ...",
                            "Ben", "Pobjie"),

                    new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.karenb), new Date(2,4,2016), "'Hell's Kitchen' Recap: Who Falls For The Sabotages? Previously on Hell's Kitchen, our chefs served up ...", "Karen", "Belz"),

                    new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.aja), new Date(1,3,2016), "Culinary goddess Nigella Lawson will join MasterChef for a week of divine decadence and indulgence. Here, Nigella shares her thoughts on this year’s contestants and what challenges she has in store\n" +
                            "Without giving too much away, how has your experience on MasterChef been so far? ...", "Aja", "Styles")

                    //new FakeData(null, ContextCompat.getDrawable(getContext(), R.drawable.ic_circle_default), new Date(), "rawr!", "Patrick", "Shaw")

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
