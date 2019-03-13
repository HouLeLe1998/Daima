package com.example.wbean;

import java.util.List;

public class Beanaa {
    private List<Bean>  commodityList;

    public Beanaa(List<Bean> commodityList) {
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
        return "Beanaa{" +
                "commodityList=" + commodityList +
                '}';
    }
}
