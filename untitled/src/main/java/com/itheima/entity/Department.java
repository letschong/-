package com.itheima.entity;

public class Department {
    private String depId;
    private String depName;
    private String depaType;

    public Department(String depId, String depName, String depaType) {
        this.depId = depId;
        this.depName = depName;
        this.depaType = depaType;
    }

    public Department() {

    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepaType() {
        return depaType;
    }

    public void setDepaType(String depaType) {
        this.depaType = depaType;
    }

    @Override
    public String toString() {
        return "department{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", depaType='" + depaType + '\'' +
                '}';
    }
}
