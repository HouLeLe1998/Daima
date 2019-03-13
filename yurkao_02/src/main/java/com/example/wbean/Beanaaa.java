package com.example.wbean;

import java.util.List;

public class Beanaaa {
    private List<Bean> commodityList;

    public Beanaaa(List<Bean> commodityList) {
        this.commodityList = commodityList;
    }

    public List<Bean> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Bean> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "Beanaaa{" +
                "commodityList=" + commodityList +
                '}';
    }
}
