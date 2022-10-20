package com.itheima.service;

import com.itheima.entity.Leave;
import com.itheima.entity.Statistics;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveService {
   public    List<Leave>leave_information(@Param("userid")String userid,@Param("stuNo") String stuNo);
    void addleave(Leave leave);
    void updaleave(@Param("flag")String flag,@Param("stuNo")String stuNo,@Param("startTime")String startTime);
    //审核请假条
    List<Leave> auditleave_information(@Param("stuNo")String stuNo);
    //统计
    List<Statistics> statistics_information(@Param("clsName")String clsName,@Param("startTime1") String startTime1, @Param("startTime2")String startTime2);

    //导出
    public List<Leave> daoleave_information(String stuNo);
}
