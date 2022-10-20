package com.itheima.entity;

public class User {
    private String userid;
    private String fullname;
    private String password;
    private String depId;
    private String telephone;
    private String type;

    public User() {

    }

    public User(String userid, String fullname, String password, String depId, String telephone) {
        this.userid = userid;
        this.fullname = fullname;
        this.password = password;
        this.depId = depId;
        this.telephone = telephone;
    }


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", depId='" + depId + '\'' +
                ", telephone='" + telephone + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User(String userid, String fullname, String password, String depId, String telephone, String type) {
        this.userid = userid;
        this.fullname = fullname;
        this.password = password;
        this.depId = depId;
        this.telephone = telephone;
        this.type = type;
    }
}



