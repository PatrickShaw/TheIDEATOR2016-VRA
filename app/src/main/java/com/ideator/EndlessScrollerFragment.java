package com.ideator;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com), Rundl Pty. Ltd.
 * @since 25/01/2016
 */
public abstract class EndlessScrollerFragment<T, A extends EndlessScrollerAdapter> extends DialogFragment {
    protected List<T> mValues = new ArrayList<>();
    private String mNextPageUrl = null;
    private boolean mIsLoadingNextPage = false;
    private LinearLayout mLayoutEmptyState =null;
    private ImageView mTextEmptyStateIcon;
    private TextView mTextEmptyStateMessage;
    protected RecyclerView mRecyclerView = null;
    protected SwipeRefreshLayout mSwipeRefreshLayout = null;
    public A mRecyclerAdapter = null;
    protected Snackbar mSnackbarError = null;
    private boolean mNeedToRefreshItems = false;
    private boolean mRefreshDisabled = false;
    public void setRefreshDisabled(boolean refreshDisabled)
    {
        this.mRefreshDisabled = refreshDisabled;
    }
    public void clearItemsAndCancelLoading()
    {
        mValues.clear();
        mRecyclerAdapter.notifyDataSetChanged();
        setIsLoadingNextPage(false);
    }
    protected void initialiseViews(View view, ViewGroup container, Bundle savedInstanceState)
    {
        // Initialise first batch of activities if we don't have some already (since this might be called again on rotation)
        // OR if the activity that this fragment is attached to wanted to refresh the items but couldn't since onDestroyView was called
        if(mNextPageUrl == null || mNeedToRefreshItems) {
            L.d("EndlessScrollerFrgmt", "mNextPageUrl == null: " + Boolean.toString(mNextPageUrl == null) + " || needToRefreshItems: " + Boolean.toString(mNeedToRefreshItems));
            refreshItems(false);
        }
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems(false);
            }
        });
        // Set scroll to bottom listener
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager)mRecyclerView.getLayoutManager();
                // Start loading on the last three activities
                if (layoutManager.findLastCompletelyVisibleItemPosition() >=  mRecyclerAdapter.getListItemCount() - getLoadingThresholdIndex()) {
                    loadMoreItems();
                }
            }
        });
        mRecyclerView.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        mRecyclerAdapter.registerAdapterDataObserver(
                new RecyclerView.AdapterDataObserver() {
                    @Override
                    public void onChanged() {
                        super.onChanged();
                        checkIfEmpty();
                    }

                    @Override
                    public void onItemRangeChanged(int positionStart, int itemCount) {
                        super.onItemRangeChanged(positionStart, itemCount);
                        checkIfEmpty();
                    }

                    @Override
                    public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
                        super.onItemRangeChanged(positionStart, itemCount, payload);
                        checkIfEmpty();
                    }

                    @Override
                    public void onItemRangeInserted(int positionStart, int itemCount) {
                        super.onItemRangeInserted(positionStart, itemCount);
                        checkIfEmpty();
                    }

                    @Override
                    public void onItemRangeRemoved(int positionStart, int itemCount) {
                        super.onItemRangeRemoved(positionStart, itemCount);
                        checkIfEmpty();
                    }

                    @Override
                    public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
                        super.onItemRangeMoved(fromPosition, toPosition, itemCount);
                        checkIfEmpty();
                    }
                }

        );
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(),container, false);
        if(getParentFragment() == null)
            setRetainInstance(true);

        mRecyclerView = (RecyclerView)view.findViewById(getRecyclerViewId());
        mSwipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(getSwipeRefreshLayoutId());
        mLayoutEmptyState = (LinearLayout)view.findViewById(getEmptyStateId());
        mTextEmptyStateMessage = (TextView)view.findViewById(R.id.text_empty_statement);
        mTextEmptyStateMessage.setText(getEmptyStateMessage());
        mTextEmptyStateIcon = (ImageView) view.findViewById(R.id.text_empty_icon);
        mTextEmptyStateIcon.setImageDrawable(getEmptyStateIcon());

        mRecyclerAdapter = getRecyclerAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(createLayoutManager());
        onCreateRecyclerView(mRecyclerView);
        initialiseViews(view, container, savedInstanceState);
        return view;
    }
    protected void checkIfEmpty()
    {
        if(mRecyclerAdapter.getListItemCount() == 0) {
            if (mIsLoadingNextPage) {
                showEmptyState(false);
            }
            else
            {
                showEmptyState(true);
            }
        }
        else
        {
            showEmptyState(false);
        }
    }

    private void showEmptyState(boolean isEmptyState)
    {
        if(isEmptyState)
        {
            mLayoutEmptyState.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
        else
        {
            mLayoutEmptyState.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }
    protected void setIsLoadingNextPage(boolean isLoadingNextPage)
    {
        this.mIsLoadingNextPage = isLoadingNextPage;
        mRecyclerAdapter.setIsLoading(isLoadingNextPage);
        if(!isLoadingNextPage)
            mSwipeRefreshLayout.setRefreshing(false);
    }
    public boolean isInflated()
    {
        L.d("mRecyclerAdapter", mRecyclerAdapter == null ? "null" : "true" );
        L.d("mRecyclerView", mRecyclerView == null ? "null" : "true" );
        return mRecyclerView != null && mRecyclerAdapter != null;
    }
    public void refreshItems(boolean flushRecyclerView) {
        if(mRefreshDisabled){return;}
        if(!isInflated()) {
            L.d(getClass().getSimpleName(), "Fragment views have isInflated = false");
            L.d("EndlessScrollFrgmt", "Views for fragment has been destroyed. mNeedToRefreshItems = true");
            mIsLoadingNextPage = true;
            mNextPageUrl = null;
            mNeedToRefreshItems = true;
            return;
        }
        // Whenever something is loading, we should always assume that the the fragment isn't empty
        mNeedToRefreshItems = false;
        mSwipeRefreshLayout.setRefreshing(true);
        setNextPageUrl(null);
        setIsLoadingNextPage(true);
        L.d("EndlessScrollFrgmt", "Refreshing " + this.getClass().getSimpleName()+ ", flushRecyclerView = " + Boolean.toString(flushRecyclerView));
        if(flushRecyclerView){
            mValues.clear();
            mRecyclerAdapter.notifyDataSetChanged();
            L.d("EndlessScrollFrgmt", "Removed all data and notified the adapter.");
        }
        showEmptyState(false);
    }
    public void loadMoreItems()
    {
        if(mIsLoadingNextPage)
        {
            Log.d(getClass().getSimpleName(), "Prompted to load more activities, but already loading more activities.");
            return;
        }
        if(TextUtils.isEmpty(mNextPageUrl))
        {
            Log.i(getClass().getSimpleName(), "Next activity page was null; assuming that there are no more activities to retrieve.");
            return;
        }
        setIsLoadingNextPage(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void changeItem(int index, T item)
    {
        mRecyclerAdapter.updateItem(index,item);
    }

    public void insertItem(int index, T item)
    {
        mRecyclerAdapter.insertItem(index, item);
    }
    protected LinearLayoutManager createLayoutManager()
    {
        return new LinearLayoutManager(getContext());
    }
    protected int getEmptyStateId(){ return R.id.layout_empty_state;}
    protected abstract Drawable getEmptyStateIcon();
    protected abstract String getEmptyStateMessage();
    protected void setNextPageUrl(String nextPageUrl)
    {
        mNextPageUrl = nextPageUrl;
    }
    protected abstract A getRecyclerAdapter();
    protected abstract void onCreateRecyclerView(RecyclerView recyclerView);
    protected abstract int getLoadingThresholdIndex();
    protected int getLayoutId()
    {
        return R.layout.fragment_endless_scroller;
    }
    protected int getRecyclerViewId()
    {
        return R.id.list;
    }
    protected int getSwipeRefreshLayoutId()
    {
        return R.id.layout_swipe_refresh;
    };
    protected abstract String getLoadMoreItemsRequestTag();
    public abstract String[] onCancelRequests();
}
