package com.bwie.bean;

import java.util.List;

public class Beana {
    private String title;
    private List<String> pics;

    public Beana(String title, List<String> pics) {
        this.title = title;
        this.pics = pics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPics() {
        return pics;
    }

    public void setPics(List<String> pics) {
        this.pics = pics;
    }

    @Override
    public String toString() {
        return "Beana{" +
                "title='" + title + '\'' +
                ", pics=" + pics +
                '}';
    }
}
