package com.itheima.service.Impl;

import com.itheima.entity.Meun;
import com.itheima.entity.Meuns;
import com.itheima.entity.Role;
import com.itheima.mapper.RolesMapper;
import com.itheima.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rolesService")
public class RolesServiceImpl implements RolesService {
    @Autowired
    private RolesMapper rolesMapper;


    public List<Role> role_information() {
        return rolesMapper.role_information();
    }

    public List<Meun> meun_information(Meun meun) {
        return rolesMapper.meun_information(meun);
    }

    public void deletemenu(Meun meun) {
       rolesMapper.deletemenu(meun);
    }

    public List<Meuns> meuns() {
        return rolesMapper.meuns();
    }

    public void addrele(Meun meun) {
      rolesMapper.addrele(meun);
    }
}
