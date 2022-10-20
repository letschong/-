package com.itheima.service.Impl;

import com.itheima.entity.Department;
import com.itheima.entity.User;
import com.itheima.mapper.DepartmentMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.service.DepartmentService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> findAll(Department department) {
        return departmentMapper.findAll(department);
    }

    public void addDepartment(Department department) {
       departmentMapper.addDepartment(department);
    }

    public void deleteDepartment(String depId) {
        departmentMapper.deleteDepartment(depId);
    }

    public List<Department> findByidDepartment(String depId) {
        return departmentMapper.findByidDepartment(depId);
    }

    public void updateDepartment(Department department) {
       departmentMapper.updateDepartment(department);
    }
}
