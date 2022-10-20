package com.itheima.mapper;



import com.itheima.entity.Instructor;
import com.itheima.entity.Students;


import java.util.List;

public interface InstructorMapper {
    public List<Instructor> checkinstructor(Instructor instructor);
    public Instructor find(Instructor instructor);

    public List<Instructor> findAll(Instructor instructor);
    public  void  addInstructor(Instructor instructor);
    public  void  deleteInstructor(String insNo);
    public  List<Instructor>findByidInstructor(String insNo);
    public  void  updateInstructor(Instructor instructor);
}
