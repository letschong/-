package com.itheima.entity;

import java.util.Date;

public class Statistics {
    private String  insNo;
    private String  stuNo;
    private String  stuName;
    private String  stuSex;
    private String  clsId;
    private String  stuPwd;
    private String  leaveNo;
    private String  types;
    private String  reason;
    private Date startTime;
    private Date  endTime;
    private float  days;
    private Date  createTime;
    private String  flag;
    private String  insName;
    private String  insPwd;
    private String  depId;
    private String  telephone;
    private String  clsName;
    private String  clsMajor;
    private String  clsGrade;

    public Statistics(String clsId, String depId, String insNo, String stuNo, String stuName, String stuSex, String stuPwd, String leaveNo, String types, String reason, Date startTime, Date endTime, float days, Date createTime, String flag, String insName, String insPwd, String telephone, String clsName, String clsMajor, String clsGrade) {
        this.insNo = insNo;
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.clsId = clsId;
        this.stuPwd = stuPwd;
        this.leaveNo = leaveNo;
        this.types = types;
        this.reason = reason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
        this.createTime = createTime;
        this.flag = flag;
        this.insName = insName;
        this.insPwd = insPwd;
        this.depId = depId;
        this.telephone = telephone;
        this.clsName = clsName;
        this.clsMajor = clsMajor;
        this.clsGrade = clsGrade;
    }

    public String getInsNo() {
        return insNo;
    }

    public void setInsNo(String insNo) {
        this.insNo = insNo;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getClsId() {
        return clsId;
    }

    public void setClsId(String clsId) {
        this.clsId = clsId;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getLeaveNo() {
        return leaveNo;
    }

    public void setLeaveNo(String leaveNo) {
        this.leaveNo = leaveNo;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public float getDays() {
        return days;
    }

    public void setDays(float days) {
        this.days = days;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
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

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getClsMajor() {
        return clsMajor;
    }

    public void setClsMajor(String clsMajor) {
        this.clsMajor = clsMajor;
    }

    public String getClsGrade() {
        return clsGrade;
    }

    public void setClsGrade(String clsGrade) {
        this.clsGrade = clsGrade;
    }

    @Override
    public String toString() {
        return "statistics{" +
                "insNo='" + insNo + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", clsId='" + clsId + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", leaveNo='" + leaveNo + '\'' +
                ", types='" + types + '\'' +
                ", reason='" + reason + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", days=" + days +
                ", createTime='" + createTime + '\'' +
                ", flag='" + flag + '\'' +
                ", insName='" + insName + '\'' +
                ", insPwd='" + insPwd + '\'' +
                ", depId='" + depId + '\'' +
                ", telephone='" + telephone + '\'' +
                ", clsName='" + clsName + '\'' +
                ", clsMajor='" + clsMajor + '\'' +
                ", clsGrade='" + clsGrade + '\'' +
                '}';
    }
}
