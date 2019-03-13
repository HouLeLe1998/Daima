package com.bwie.bean;

public class Beanb {
    private Beana data;

    public Beanb(Beana data) {
        this.data = data;
    }

    public Beana getData() {
        return data;
    }

    public void setData(Beana data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Beanb{" +
                "data=" + data +
                '}';
    }
}
