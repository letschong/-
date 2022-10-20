package com.itheima.service.Impl;

import com.itheima.entity.Classes;
import com.itheima.entity.Students;
import com.itheima.entity.User;
import com.itheima.mapper.ClassesMapper;
import com.itheima.mapper.StudentsMapper;
import com.itheima.service.ClassesService;
import com.itheima.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("studentsService")
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsMapper studentsMapper;

    public boolean checkStudent(Students students){
        boolean flag = false;
        List<Students> studentsList= studentsMapper.checkStudent(students);
        flag=studentsList.isEmpty();
        return !flag;
    }
    public Students find(Students students){
        return studentsMapper.find(students);
    }
    public List<Students> findAll(Students students){
        return studentsMapper.findAll(students);
    }
    public  void  addStudents(Students students){
        studentsMapper.addStudents(students);
    }
    public  void  deleteStudents(String stuNo){
        studentsMapper.deleteStudents(stuNo);
    }

    public List<Students> findByidStudents(String stuNo) {
        return studentsMapper.findByidStudents(stuNo);
    }
    public  void  updateStudents(Students students){
        studentsMapper.updateStudents(students);
    }

}
