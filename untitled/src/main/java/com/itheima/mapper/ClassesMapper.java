package com.itheima.mapper;


import com.itheima.entity.Classes;
import com.itheima.entity.User;

import java.util.List;

public interface ClassesMapper {
    public List<Classes> findAll(Classes classes);
    public  void  addClasses(Classes classes);
    public  void  deleteClasses(String clsId);
    public  List<Classes>findByidClasses(String clsId);
    public  void  updateClasses(Classes classes);

}
