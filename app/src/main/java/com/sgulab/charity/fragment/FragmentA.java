package com.sgulab.charity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.sgulab.charity.R;
import com.sgulab.charity.adapter.NewFeedAdapter;
import com.sgulab.charity.object.Feed;
import com.sgulab.charity.result.FeedDataResult;
import com.sgulab.charity.util.FileUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class FragmentA extends BaseFragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private NewFeedAdapter mAdapter;
    private List<Feed> feeds;
    private boolean loading = true;
    private int pastVisiblesItems, visibleItemCount, totalItemCount;
    private int currentItemCount;
    private final int itemPerPage = 3;


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        feeds = new ArrayList<>();
        mAdapter = new NewFeedAdapter(getContext(), feeds);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0) //check for scroll down
                {
                    visibleItemCount = mLayoutManager.getChildCount();
                    totalItemCount = mLayoutManager.getItemCount();
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                    if (loading)
                    {
                        if ((visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                            loading = false;
                            Log.i("***", "Loading more data...");
                            loadData(currentItemCount, currentItemCount + itemPerPage);
                            currentItemCount += itemPerPage;
                        }
                    }
                }
            }
        });

        //TODO: Get feeds
        currentItemCount = itemPerPage;
        loadData(0, currentItemCount);
    }

    private void loadData(int from, int count) {
        String data = FileUtil.readTextFileFromAssets(getContext(), "feeds.json");
        Gson gson = new Gson();
        FeedDataResult result = gson.fromJson(data, FeedDataResult.class);
        if (result.getResponse() == 0) {
            feeds.addAll(getPageFeeds(result.getFeeds(), from, count));
            mAdapter.notifyDataSetChanged();
        }
        loading = true;
    }

    private List<Feed> getPageFeeds(List<Feed> feedList, int from, int count) {
        int last = from + count;
        if (last > feedList.size() - 1) {
            last = feedList.size() - 1;
        }
        List<Feed> newFeeds = new ArrayList<>();
        for (int i = from; i < last; i++) {
            newFeeds.add(feedList.get(i));
        }
        return newFeeds;
    }
}