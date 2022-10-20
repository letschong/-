package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.Leave;
import com.itheima.entity.Statistics;
import com.itheima.entity.User;
import com.itheima.service.LeaveService;
import com.itheima.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

/*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize,
                             @RequestParam(name = "userid",required = false,defaultValue = "") String userid) {
       String stuNo=query;
        PageHelper.startPage(pagenum, pagesize);
        List<Leave> leaveList=leaveService.leave_information(userid,stuNo);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(leaveList);
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/addleave")
    @ResponseBody
    public ApiResult addleave(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo,
                             @RequestParam(name = "types",required = false,defaultValue = "") String types,
                             @RequestParam(name = "reason",required = false,defaultValue = "") String reason,
                             @RequestParam(name = "startTime",required = false,defaultValue = "") String startTime1,
                              @RequestParam(name = "endTime",required = false,defaultValue = "") String endTime1,
                              @RequestParam(name = "insNo",required = false,defaultValue = "") String insNo){
        String leaveNo = UUID.randomUUID().toString().replace("-", "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        Date queueDate = new Date();
        String createTime=toForm(queueDate);
        Date date = null;
        try {
            date = simpleDateFormat.parse(startTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String startTime = toForm(date);
        Date date1 = null;
        try {
            date1 = simpleDateFormat.parse(endTime1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String endTime = toForm(date1);
        float days = Float.parseFloat(String.valueOf((date1.getTime() - date.getTime()) / (24 * 60 * 60 * 1000)));
        String flag= String.valueOf(0);
        ApiResult result=new ApiResult();
        Leave leave = new Leave(leaveNo,reason,startTime,endTime,stuNo,days,insNo,createTime,flag,types);
      leaveService.addleave(leave);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
    public static String getSysdateStr3() {

        Date sysdate = new Date();

        return String.format("%tF %tT", sysdate, sysdate);
    }
    public static String toForm(Date date) {


        return String.format("%tF %tT", date,date);   //yyyy-MM-dd HH:mm:ss String.format("%tF %tT", sysdate, sysdate);
    }

    @RequestMapping(value = "/updaleave")
    @ResponseBody
    public ApiResult updaleave(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo,
                              @RequestParam(name = "startTime",required = false,defaultValue = "") String startTime)
                              {
        ApiResult result=new ApiResult();
        String flag= String.valueOf(3);
        leaveService.updaleave(flag,stuNo,startTime);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/auditleave")
    @ResponseBody
    public ApiResult auditleave(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize)
    {
        String stuNo=query;
        PageHelper.startPage(pagenum, pagesize);
        List<Leave> leaveList=leaveService.auditleave_information(stuNo);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(leaveList);

        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/auditrefuseleave")
    @ResponseBody
    public ApiResult auditrefuseleave(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo,
                                @RequestParam(name = "startTime",required = false,defaultValue = "") String startTime)
    {


        ApiResult result=new ApiResult();
        String flag= String.valueOf(2);
        leaveService.updaleave(flag,stuNo,startTime);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/auditagreeleave")
    @ResponseBody
    public ApiResult auditagreeleave(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo,
                                      @RequestParam(name = "startTime",required = false,defaultValue = "") String startTime)
    {
        ApiResult result=new ApiResult();
        String flag= String.valueOf(1);
        leaveService.updaleave(flag,stuNo,startTime);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/statistics")
    @ResponseBody
    public ApiResult statistics(@RequestParam(name = "query",required = false,defaultValue = "") String clsName,
                                     @RequestParam(name = "startTime",required = false,defaultValue = "") String startTime1,
                                      @RequestParam(name = "endTime",required = false,defaultValue = "") String startTime2)
    {
        ApiResult result=new ApiResult();
        List<Statistics>statisticsList=leaveService.statistics_information(clsName,startTime1,startTime2);
        result.setCode("200");
        result.setBody(statisticsList);
        result.setMessage("调用成功");
        return result;
    }
    @RequestMapping(value = "/daoleave")
    @ResponseBody
    public ApiResult daoleave(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                                @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                                @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize)
    {
        String stuNo=query;
        PageHelper.startPage(pagenum, pagesize);
        List<Leave> leaveList=leaveService.daoleave_information(stuNo);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(leaveList);

        result.setMessage("调用成功");
        return result;
    }
}
