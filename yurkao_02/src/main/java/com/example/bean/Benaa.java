package com.example.bean;

import java.util.List;

public class Benaa {
    private List<Bean> result;

    public Benaa(List<Bean> result) {
        this.result = result;
    }

    public List<Bean> getResult() {
        return result;
    }

    public void setResult(List<Bean> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Benaa{" +
                "result=" + result +
                '}';
    }
}
