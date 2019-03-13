package com.example.wbean;

import java.util.List;

public class Beana {
    private List<Bean> commodityList;

    public Beana(List<Bean> commodityList) {
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
        return "Beana{" +
                "commodityList=" + commodityList +
                '}';
    }
}
