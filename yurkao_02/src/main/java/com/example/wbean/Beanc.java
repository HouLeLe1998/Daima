package com.example.wbean;

public class Beanc {
    private Beanb result;

    public Beanc(Beanb result) {
        this.result = result;
    }

    public Beanb getResult() {
        return result;
    }

    public void setResult(Beanb result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Beanc{" +
                "result=" + result +
                '}';
    }
}
