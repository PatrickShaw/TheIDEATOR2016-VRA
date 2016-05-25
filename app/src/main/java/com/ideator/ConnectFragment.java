package com.ideator;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.Calendar;
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
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 4,13);
        new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.ic_circle_default), calendar.getTime(), "The controlling dynamics at play in my relationship have left me without work for two years, and I'm doing my best to find work and get a feasible escape plan ...", "Getmeout", "");
        calendar.set(2016, 4,23);
        new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.a), calendar.getTime(), "I told Michael about it and he said not to worry about it, she was always saying things like that. I kept pressing it, but he insisted that it was nothing more than just a jealous comment. So I dropped it...", "Anon", "");
        calendar.set(2016, 5,3);
        new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.a), calendar.getTime(), "I'm in a severely awful situation. Before I begin, I know I shouldn't have dated someone from work, that was a bad move. Additionally, I should have seen the red flags alot earlier...", "Anon", "");
        calendar.set(2016, 5,13);
        new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.strawberry), calendar.getTime(), "I told Michael about it and he said not to worry about it, she was always saying things like that. I kept pressing it, but he insisted that it was nothing more than just a jealous comment. So I dropped it....", "Gwenth", "");
        calendar.set(2016, 5,24);
        new FakeData(null, ContextCompat.getDrawable(getContext(),R.drawable.golf), calendar.getTime(), "She took every opportunity to belittle me. When in a temper, she often hit me.\n", "Taylor", "S");

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
