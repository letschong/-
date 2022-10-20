package com.itheima.entity;

public class Instructortask {
    private String insNo;
    private String depId;
    private String clsId;
    private String startTime;
    private String startTerm;
    private String clsName;
    private String clsMajor;
    private String clsGrade;
    private String insName;
    private String insPwd;
    private String telephone;

    public Instructortask() {
    }

    public Instructortask(String insNo, String clsId, String startTime, String startTerm) {
        this.insNo = insNo;
        this.clsId = clsId;
        this.startTime = startTime;
        this.startTerm = startTerm;
    }

    public Instructortask(String insNo, String depId, String clsId, String startTime, String startTerm, String clsName, String clsMajor, String clsGrade, String insName, String insPwd, String telephone) {
        this.insNo = insNo;
        this.depId = depId;
        this.clsId = clsId;
        this.startTime = startTime;
        this.startTerm = startTerm;
        this.clsName = clsName;
        this.clsMajor = clsMajor;
        this.clsGrade = clsGrade;
        this.insName = insName;
        this.insPwd = insPwd;
        this.telephone = telephone;
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

    public String getClsId() {
        return clsId;
    }

    public void setClsId(String clsId) {
        this.clsId = clsId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTerm() {
        return startTerm;
    }

    public void setStartTerm(String startTerm) {
        this.startTerm = startTerm;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "instructortask{" +
                "insNo='" + insNo + '\'' +
                ", insName='" + insName + '\'' +
                ", clsId='" + clsId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", startTerm='" + startTerm + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
