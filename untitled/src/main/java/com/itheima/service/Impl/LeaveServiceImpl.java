package com.itheima.service.Impl;

import com.itheima.entity.Leave;
import com.itheima.entity.Statistics;

import com.itheima.mapper.LeaveMapper;

import com.itheima.service.LeaveService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;


    public List<Leave> leave_information(@Param("userid")String userid,@Param("stuNo") String stuNo) {
        return leaveMapper.leave_information(userid, stuNo);
    }

    public void addleave(Leave leave) {
         leaveMapper.addleave(leave);
    }

    public void updaleave(@Param("flag")String flag,@Param("stuNo")String stuNo,@Param("startTime")String startTime) {
leaveMapper.updaleave(flag, stuNo, startTime);
    }

    public List<Leave> auditleave_information(@Param("stuNo")String stuNo) {
        return leaveMapper.auditleave_information(stuNo);
    }

    public List<Statistics> statistics_information(@Param("clsName")String clsName,@Param("startTime1") String startTime1, @Param("startTime2")String startTime2) {
        return leaveMapper.statistics_information(clsName, startTime1, startTime2);
    }

    public List<Leave> daoleave_information(String stuNo) {
        return leaveMapper.daoleave_information(stuNo);
    }
}
