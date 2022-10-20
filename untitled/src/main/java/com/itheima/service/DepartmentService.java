package com.itheima.service;

import com.itheima.entity.Department;
import com.itheima.entity.User;

import java.util.List;

public interface DepartmentService {
    public List<Department> findAll(Department department);
    public  void  addDepartment(Department department);
    public  void  deleteDepartment(String depId);
    public  List<Department>findByidDepartment(String depId);
    public  void  updateDepartment(Department department);
}
