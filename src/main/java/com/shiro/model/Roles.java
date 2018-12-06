package com.shiro.model;

public class Roles {
    private int rid;
    private String rname;
    private String rmark;

    @Override
    public String toString() {
        return "Roles{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rmark='" + rmark + '\'' +
                '}';
    }

    public Roles() {
    }

    public Roles(int rid, String rname, String rmark) {
        this.rid = rid;
        this.rname = rname;
        this.rmark = rmark;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRmark() {
        return rmark;
    }

    public void setRmark(String rmark) {
        this.rmark = rmark;
    }
}
