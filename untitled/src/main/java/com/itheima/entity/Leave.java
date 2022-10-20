package com.itheima.entity;

public class Leave {
    private String  leaveNo;
    private String  reason;
    private String  startTime;
    private String  endTime;
    private String  stuNo;
    private float  days;
    private String  insNo;
    private String  createTime;
    private String  flag;
    private String  types;

    private String  stuName;
    private String  stuSex;
    private String  clsId;
    private String  stuPwd;
    private String  insName;
    private String  insPwd;
    private String  depId;
    private String  telephone;

    public Leave(String leaveNo, String reason, String startTime, String endTime, String stuNo, float days, String insNo, String createTime, String flag, String types) {
        this.insNo = insNo;
        this.stuNo = stuNo;
        this.leaveNo = leaveNo;
        this.types = types;
        this.reason = reason;
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
        this.createTime = createTime;
        this.flag = flag;
    }

    public Leave(String insNo, String stuNo, String stuName, String stuSex, String clsId, String stuPwd, String leaveNo, String types, String reason, String startTime, String endTime, float days, String createTime, String flag, String insName, String insPwd, String depId, String telephone) {
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
    }

    public Leave() {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public float getDays() {
        return days;
    }

    public void setDays(float days) {
        this.days = days;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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

    @Override
    public String toString() {
        return "Leave{" +
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
                '}';
    }
}
