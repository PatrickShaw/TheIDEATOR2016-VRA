package com.ideator;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;

import java.util.Date;
import java.util.List;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class VideoRecyclerView  extends EndlessScrollerAdapter<VideoRecyclerView.ViewHolder, Date>{
    public VideoRecyclerView(List<Date> items) {
        super(items);
    }

    @Override
    public ViewHolder onCreateNonFooterViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_youtube, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindNonFooterViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mItem = mValues.get(position);
        viewHolder.bindData();
    }

    @Override
    public int getNonFooterItemViewType(int position) {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public Date mItem;
        private TextView mTextDate;
        private ImageView mImageYoutube;
        public ViewHolder(View view) {
            super(view);
            mTextDate = (TextView)view.findViewById(R.id.text_date);
            mImageYoutube = (ImageView)view.findViewById(R.id.image_video);
        }
        public void bindData()
        {
            mImageYoutube.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.video_placeholder));
            mTextDate.setText(StringHelper.formatDate(itemView.getContext(), mItem));
        }

    }
}
