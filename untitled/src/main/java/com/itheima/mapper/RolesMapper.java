package com.itheima.mapper;



import com.itheima.entity.Meun;
import com.itheima.entity.Meuns;
import com.itheima.entity.Role;


import java.util.List;

public interface RolesMapper {
    List<Role> role_information();
    List<Meun> meun_information(Meun meun);
    public void deletemenu(Meun meun);
    public List<Meuns> meuns();
    void addrele(Meun meun);
}
