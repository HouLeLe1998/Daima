package com.example.bean;

public class Bean {
    private String followMovie;
    private String id;
    private String imageUrl;
    private String name;
    private String rank;
    private String summary;

    public Bean(String followMovie, String id, String imageUrl, String name, String rank, String summary) {
        this.followMovie = followMovie;
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.rank = rank;
        this.summary = summary;
    }

    public String getFollowMovie() {
        return followMovie;
    }

    public void setFollowMovie(String followMovie) {
        this.followMovie = followMovie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "followMovie='" + followMovie + '\'' +
                ", id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
