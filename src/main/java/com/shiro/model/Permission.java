package com.shiro.model;

public class Permission {

    private int pid;
    private String pname;
    private String pmark;

    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pmark='" + pmark + '\'' +
                '}';
    }

    public Permission() {
    }

    public Permission(int pid, String pname, String pmark) {
        this.pid = pid;
        this.pname = pname;
        this.pmark = pmark;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPmark() {
        return pmark;
    }

    public void setPmark(String pmark) {
        this.pmark = pmark;
    }
}
