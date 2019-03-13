package com.example.wbean;

import java.util.List;

public class Beanb {
    private List<Beana> rxxp;
    private List<Beanaa> pzsh;
    private List<Bean> mlss;

    public Beanb(List<Beana> rxxp, List<Beanaa> pzsh, List<Bean> mlss) {
        this.rxxp = rxxp;
        this.pzsh = pzsh;
        this.mlss = mlss;
    }

    public List<Beana> getRxxp() {
        return rxxp;
    }

    public void setRxxp(List<Beana> rxxp) {
        this.rxxp = rxxp;
    }

    public List<Beanaa> getPzsh() {
        return pzsh;
    }

    public void setPzsh(List<Beanaa> pzsh) {
        this.pzsh = pzsh;
    }

    public List<Bean> getMlss() {
        return mlss;
    }

    public void setMlss(List<Bean> mlss) {
        this.mlss = mlss;
    }

    @Override
    public String toString() {
        return "Beanb{" +
                "rxxp=" + rxxp +
                ", pzsh=" + pzsh +
                ", mlss=" + mlss +
                '}';
    }
}
