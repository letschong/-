package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.Instructor;
import com.itheima.entity.Instructortask;
import com.itheima.service.InstructorService;
import com.itheima.service.InstructortaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/instructortask")
public class InstructortaskController {
    @Autowired
    private InstructortaskService instructortaskService;

    /*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize) {
        Instructortask instructortask=new Instructortask();
        instructortask.setInsNo(query);
        PageHelper.startPage(pagenum, pagesize);
        List<Instructortask> instructortaskList= instructortaskService.findAll(instructortask);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(instructortaskList);
        result.setMessage("调用成功");
        return result;
    }


    @RequestMapping(value = "/addInstructortask")
    @ResponseBody
    public ApiResult addInstructor(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo,
                             @RequestParam(name = "clsId",required = false,defaultValue = "") String clsId,
                             @RequestParam(name = "startTime",required = false,defaultValue = "") String startTime,
                             @RequestParam(name = "startTerm",required = false,defaultValue = "") String startTerm

    ){
        Instructortask instructortask=new Instructortask(insNo,clsId,startTime,startTerm);
        instructortaskService.addInstructortask(instructortask);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/deleteInstructortask")
    @ResponseBody
    public ApiResult deleteInstructortask(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo){
        instructortaskService.deleteInstructortask(insNo);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/findByidInstructortask")
    @ResponseBody
    public ApiResult findByidInstructortask(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo){
        List<Instructortask> instructortaskList= instructortaskService.findByidInstructortask(insNo);
        ApiResult result=new ApiResult();
        result.setBody(instructortaskList);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/updateInstructortask")
    @ResponseBody
    public ApiResult updateInstructortask(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo,
                                          @RequestParam(name = "clsId",required = false,defaultValue = "") String clsId,
                                          @RequestParam(name = "startTime",required = false,defaultValue = "") String startTime,
                                          @RequestParam(name = "startTerm",required = false,defaultValue = "") String startTerm
    ){
        Instructortask instructortask=new Instructortask(insNo,clsId,startTime,startTerm);
        instructortaskService.updateIInstructortask(instructortask);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
}
