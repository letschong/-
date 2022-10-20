package com.itheima.entity;

public class Meuns {
    private String psid;
    private String psName;
    private String psPid;
    private String path;
    private String PsLevel;

    public Meuns(String psid, String psName, String psPid, String path, String psLevel) {
        this.psid = psid;
        this.psName = psName;
        this.psPid = psPid;
        this.path = path;
        PsLevel = psLevel;
    }

    public String getPsid() {
        return psid;
    }

    public void setPsid(String psid) {
        this.psid = psid;
    }

    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }

    public String getPsPid() {
        return psPid;
    }

    public void setPsPid(String psPid) {
        this.psPid = psPid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPsLevel() {
        return PsLevel;
    }

    public void setPsLevel(String psLevel) {
        PsLevel = psLevel;
    }

    @Override
    public String toString() {
        return "meuns{" +
                "psid='" + psid + '\'' +
                ", psName='" + psName + '\'' +
                ", psPid='" + psPid + '\'' +
                ", path='" + path + '\'' +
                ", PsLevel='" + PsLevel + '\'' +
                '}';
    }
}
