package com.itheima.service.Impl;

import com.itheima.entity.Classes;
import com.itheima.entity.User;
import com.itheima.mapper.ClassesMapper;
import com.itheima.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("classesService")
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;
    public List<Classes> findAll(Classes classes) {
        return classesMapper.findAll(classes);
    }
    public  void  addClasses(Classes classes){
        classesMapper.addClasses(classes);
    }
    public  void  deleteClasses(String clsId){
        classesMapper.deleteClasses(clsId);
    }
    public  List<Classes>  findByidClasses(String clsId){
        return classesMapper.findByidClasses(clsId);
    }
    public  void  updateClasses(Classes classes){
        classesMapper.updateClasses(classes);
    }
}
