package com.itheima.service;

import com.itheima.entity.Instructor;
import com.itheima.entity.Students;
import com.itheima.entity.User;

import java.util.List;

public interface InstructorService {
    public boolean checkinstructor(Instructor instructor);
    public Instructor find(Instructor instructor);

    public List<Instructor> findAll(Instructor instructor);
    public  void  addInstructor(Instructor instructor);
    public  void  deleteInstructor(String insNo);
    public  List<Instructor>findByidInstructor(String insNo);
    public  void  updateInstructor(Instructor instructor);
}
