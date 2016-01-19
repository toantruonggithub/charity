package com.sgulab.charity.result;

import com.sgulab.charity.object.Feed;

import java.util.List;

public class FeedDataResult {
    private List<Feed> feeds;
    private int response;

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
