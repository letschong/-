package com.itheima.entity;
/*List<meun> meun_information(String id);*/
public class Meun {
    private String psid;
    private String id;
    private String psName;
    private String psPid;
    private String path;
    private String psLevel;
    private String rolesname;
    private String rolesdescribe;

    public Meun(String psid, String id, String psName, String psPid, String path, String psLevel, String rolesname, String rolesdescribe) {
        this.psid = psid;
        this.id = id;
        this.psName = psName;
        this.psPid = psPid;
        this.path = path;
        this.psLevel = psLevel;
        this.rolesname = rolesname;
        this.rolesdescribe = rolesdescribe;
    }

    public Meun() {

    }

    public Meun(String psid, String psName, String psPid, String path, String psLevel) {
        this.psid = psid;
        this.psName = psName;
        this.psPid = psPid;
        this.path = path;
        this.psLevel = psLevel;
    }

    public String getPsid() {
        return psid;
    }

    public void setPsid(String psid) {
        this.psid = psid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return psLevel;
    }

    public void setPsLevel(String psLevel) {
        this.psLevel = psLevel;
    }

    public String getRolesname() {
        return rolesname;
    }

    public void setRolesname(String rolesname) {
        this.rolesname = rolesname;
    }

    public String getRolesdescribe() {
        return rolesdescribe;
    }

    public void setRolesdescribe(String rolesdescribe) {
        this.rolesdescribe = rolesdescribe;
    }

    @Override
    public String toString() {
        return "meun{" +
                "psid='" + psid + '\'' +
                ", id='" + id + '\'' +
                ", psName='" + psName + '\'' +
                ", psPid='" + psPid + '\'' +
                ", path='" + path + '\'' +
                ", psLevel='" + psLevel + '\'' +
                ", rolesname='" + rolesname + '\'' +
                ", rolesdescribe='" + rolesdescribe + '\'' +
                '}';
    }
}
