package com.itheima.mapper;


import com.itheima.entity.Instructor;
import com.itheima.entity.Instructortask;

import java.util.List;

public interface InstructortaskMapper {
    public List<Instructortask> findAll(Instructortask instructortask);
    public  void  addInstructortask(Instructortask instructor);
    public  void  deleteInstructortask(String insNo);
    public  List<Instructortask>findByidInstructortask(String insNo);
    public  void  updateIInstructortask(Instructortask instructortask);
}
