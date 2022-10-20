package com.itheima.service;

import com.itheima.entity.Classes;
import com.itheima.entity.Students;

import java.util.List;

public interface StudentsService {
    public boolean checkStudent(Students students);
    public Students find(Students students);

    public List<Students> findAll(Students students);
    public  void  addStudents(Students students);
    public  void  deleteStudents(String stuNo);
    public  List<Students>findByidStudents(String stuNo);
    public  void  updateStudents(Students students);

}
