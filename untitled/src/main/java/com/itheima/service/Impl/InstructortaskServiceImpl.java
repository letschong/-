package com.itheima.service.Impl;

import com.itheima.entity.Instructor;
import com.itheima.entity.Instructortask;
import com.itheima.mapper.InstructorMapper;
import com.itheima.mapper.InstructortaskMapper;
import com.itheima.service.InstructorService;
import com.itheima.service.InstructortaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("instructortaskService")
public class InstructortaskServiceImpl implements InstructortaskService {
    @Autowired
    private InstructortaskMapper instructortaskMapper;



    public List<Instructortask> findAll(Instructortask instructortask) {
        return instructortaskMapper.findAll(instructortask);
    }

    public void addInstructortask(Instructortask instructor) {
 instructortaskMapper.addInstructortask(instructor);
    }

    public void deleteInstructortask(String insNo) {
instructortaskMapper.deleteInstructortask(insNo);
    }

    public List<Instructortask> findByidInstructortask(String insNo) {
        return instructortaskMapper.findByidInstructortask(insNo);
    }

    public void updateIInstructortask(Instructortask instructortask) {
instructortaskMapper.updateIInstructortask(instructortask);
    }
}
