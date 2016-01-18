package com.sgulab.charity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sgulab.charity.R;
import com.sgulab.charity.adapter.NewFeedAdapter;
import com.sgulab.charity.object.Feed;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentA extends BaseFragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private NewFeedAdapter mAdapter;

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
        List<Feed> feeds = new ArrayList<>();
        mAdapter = new NewFeedAdapter(feeds);
        mRecyclerView.setAdapter(mAdapter);

        // fake data
        Random r = new Random();
        int l;
        for (int i = 0;i < 100; i++) {
            StringBuffer sb = new StringBuffer();
            l = r.nextInt(10) + 1;
            for (int j = 0; j < l; j++) {
                sb.append("CardView extends the FrameLayout class and lets you show information inside cards that have a consistent look across the platform");
            }
            feeds.add(new Feed(sb.toString()));
        }
        mAdapter.notifyDataSetChanged();
    }
}