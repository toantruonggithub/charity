package com.sgulab.charity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.sgulab.charity.R;
import com.sgulab.charity.object.Feed;

import java.util.List;

public class NewFeedAdapter extends RecyclerView.Adapter<NewFeedAdapter.ViewHolder> {

    private final List<Feed> items;
    private final Context mContext;

    public NewFeedAdapter(Context ctx, List<Feed> items) {
        this.items = items;
        mContext = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feed_item, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTvTitle.setText(items.get(position).getTitle());
        holder.mTvContent.setText(Html.fromHtml(items.get(position).getContent()));
        holder.mToggleBbookmark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                items.get(position).setIsBookmarked(isChecked);
            }
        });
        holder.mToggleBbookmark.setChecked(items.get(position).isBookmarked());
        int size = (int) mContext.getResources().getDimension(R.dimen.feed_icon_size);
        Glide.with(mContext).load(items.get(position).getPhotoUrl()).override(size, size).centerCrop().placeholder(R.drawable.app_icon).crossFade().into(holder.mIvPhoto);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvTitle;
        public TextView mTvContent;
        public ImageView mIvPhoto;
        public ToggleButton mToggleBbookmark;
        public ViewHolder(View v) {
            super(v);
            mTvTitle = (TextView) v.findViewById(R.id.tv_title);
            mTvContent = (TextView) v.findViewById(R.id.tv_content);
            mIvPhoto = (ImageView) v.findViewById(R.id.iv_photo);
            mToggleBbookmark = (ToggleButton) v.findViewById(R.id.toggle_bookmark);
        }
    }
}
