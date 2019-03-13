package com.bwie.bean;

import java.util.List;

public class Beanc {
    private List<Beanb> data;

    public Beanc(List<Beanb> data) {
        this.data = data;
    }

    public List<Beanb> getData() {
        return data;
    }

    public void setData(List<Beanb> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Beanc{" +
                "data=" + data +
                '}';
    }
}
