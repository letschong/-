package com.itheima.entity;

public class Instructor {
    private String insNo;
    private String insName;
    private String insPwd;
    private String depId;
    private String telephone;

    public Instructor() {
    }

    public Instructor(String insNo, String insName, String depId, String telephone) {
        this.insNo = insNo;
        this.insName = insName;
        this.depId = depId;
        this.telephone = telephone;
    }

    public Instructor(String insNo, String insName, String insPwd, String depId, String telephone) {
        this.insNo = insNo;
        this.insName = insName;
        this.insPwd = insPwd;
        this.depId = depId;
        this.telephone = telephone;
    }

    public Instructor(String insNo, String insPwd) {
        this.insNo = insNo;
        this.insPwd = insPwd;
    }

    public String getInsNo() {
        return insNo;
    }

    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }

    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String getInsPwd() {
        return insPwd;
    }

    public void setInsPwd(String insPwd) {
        this.insPwd = insPwd;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "instructor{" +
                "insNo='" + insNo + '\'' +
                ", insName='" + insName + '\'' +
                ", insPwd='" + insPwd + '\'' +
                ", depId='" + depId + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
