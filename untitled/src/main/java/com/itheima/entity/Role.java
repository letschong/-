package com.itheima.entity;

public class Role {
    private String  id;
    private String  rolesname;
    private String  rolesdescribe;
    public Role(String id, String rolesname, String rolesdescribe) {
        this.id = id;
        this.rolesname = rolesname;
        this.rolesdescribe = rolesdescribe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "role{" +
                "id='" + id + '\'' +
                ", rolesname='" + rolesname + '\'' +
                ", rolesdescribe='" + rolesdescribe + '\'' +
                '}';
    }
}
