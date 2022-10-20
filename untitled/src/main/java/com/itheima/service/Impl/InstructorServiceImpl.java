package com.itheima.service.Impl;

import com.itheima.entity.Instructor;
import com.itheima.entity.Students;
import com.itheima.entity.User;
import com.itheima.mapper.InstructorMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.service.InstructorService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("instructorService")
public class InstructorServiceImpl implements InstructorService {


    @Autowired
    private InstructorMapper instructorMapper;



    public boolean checkinstructor(Instructor instructor){
        boolean flag = false;
        List<Instructor> instructorList= instructorMapper.checkinstructor(instructor);
        flag=instructorList.isEmpty();
        return !flag;
    }
    public Instructor find(Instructor instructor){
        return instructorMapper.find(instructor);
    }
    public List<Instructor> findAll(Instructor instructor) {
        return instructorMapper.findAll(instructor);
    }

    public void addInstructor(Instructor instructor) {
   instructorMapper.addInstructor(instructor);
    }

    public void deleteInstructor(String insNo) {
     instructorMapper.deleteInstructor(insNo);
    }

    public List<Instructor> findByidInstructor(String insNo) {
        return instructorMapper.findByidInstructor(insNo);
    }

    public void updateInstructor(Instructor instructor) {
    instructorMapper.updateInstructor(instructor);
    }
}
