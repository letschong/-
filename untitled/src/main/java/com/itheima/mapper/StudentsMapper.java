package com.itheima.mapper;


import com.itheima.entity.Students;
import com.itheima.entity.User;

import java.util.List;

public interface StudentsMapper {
    public List<Students> checkStudent(Students students);
    public Students find(Students students);

    public List<Students> findAll(Students students);
    public  void  addStudents(Students students);
    public  void  deleteStudents(String stuNo);
    public  List<Students>findByidStudents(String stuNo);
    public  void  updateStudents(Students students);

}
