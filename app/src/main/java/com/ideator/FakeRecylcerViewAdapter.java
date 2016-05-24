package com.ideator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class FakeRecylcerViewAdapter extends EndlessScrollerAdapter<FakeRecylcerViewAdapter.ViewHolder, FakeData> {
    public FakeRecylcerViewAdapter(List<FakeData> items) {
        super(items);
    }

    @Override
    public ViewHolder onCreateNonFooterViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fake_item, parent, false);
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
        public FakeData mItem;
        private TextView mPostHeader;
        private TextView mTextDatePosted;
        private ImageView mImagePostContent;
        private ImageView mImageProfile;
        private TextView mTextPost;
        public ViewHolder(View view) {
            super(view);
            mPostHeader = (TextView)view.findViewById(R.id.text_header_post);
            mTextDatePosted = (TextView)view.findViewById(R.id.text_date);
            mImagePostContent = (ImageView)view.findViewById(R.id.image_post_content);
            mImageProfile = (ImageView)view.findViewById(R.id.image_profile);
            mTextPost = (TextView)view.findViewById(R.id.text_post_content);
        }
        public void bindData()
        {
            if(mItem.getPostPicture() == null) {
                mImagePostContent.setVisibility(View.GONE);
            }
            else {
                mImagePostContent.setVisibility(View.VISIBLE);
                mImagePostContent.setImageDrawable(mItem.getPostPicture());
            }
            mTextPost.setText(mItem.getPost());
            mImageProfile.setImageDrawable(mItem.getProfilePicture());
            mPostHeader.setText(mItem.getFirstName() + " " + mItem.getLastName());
            mTextDatePosted.setText(StringHelper.formatDate(itemView.getContext(), mItem.getDate()));
        }
    }
}
