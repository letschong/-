package com.itheima.entity;

public class Classes {
    private String clsId;
    private String clsName;
    private String clsMajor;
    private String depId;
    private String clsGrade;

    public Classes(String clsId, String clsName, String clsMajor, String depId, String clsGrade) {
        this.clsId = clsId;
        this.clsName = clsName;
        this.clsMajor = clsMajor;
        this.depId = depId;
        this.clsGrade = clsGrade;
    }
    public Classes() {

    }

    public String getClsId() {
        return clsId;
    }

    public void setClsId(String clsId) {
        this.clsId = clsId;
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

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getClsGrade() {
        return clsGrade;
    }

    public void setClsGrade(String clsGrade) {
        this.clsGrade = clsGrade;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "clsId='" + clsId + '\'' +
                ", clsName='" + clsName + '\'' +
                ", clsMajor='" + clsMajor + '\'' +
                ", depId='" + depId + '\'' +
                ", clsGrade='" + clsGrade + '\'' +
                '}';
    }
}
