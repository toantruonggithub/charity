package com.sgulab.charity.object;

import java.util.List;

public class Feed {
    private String title;
    private String photo;
    private String content;
    private boolean isBookmarked;
    private List<String> sponsors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photo;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photo = photoUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setIsBookmarked(boolean isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    public List<String> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<String> sponsors) {
        this.sponsors = sponsors;
    }
}
