package com.ideator;

import android.support.v7.preference.EditTextPreference;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class FakeRecylcerViewAdapter extends RecyclerView.Adapter<FakeRecylcerViewAdapter.ViewHolder> {
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public ViewHolder(View view) {
            super(view);
        }
    }
}
