package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.Classes;
import com.itheima.entity.Instructor;
import com.itheima.service.ClassesService;
import com.itheima.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    /*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize) {
        Instructor instructor=new Instructor();
        instructor.setInsNo(query);
        PageHelper.startPage(pagenum, pagesize);
        List<Instructor> instructorList= instructorService.findAll(instructor);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(instructorList);
        result.setMessage("调用成功");
        return result;
    }


    @RequestMapping(value = "/addInstructor")
    @ResponseBody
    public ApiResult addInstructor(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo,
                             @RequestParam(name = "insName",required = false,defaultValue = "") String insName,
                             @RequestParam(name = "insPwd",required = false,defaultValue = "") String insPwd,
                             @RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                             @RequestParam(name = "telephone",required = false,defaultValue = "") String telephone
    ){
        Instructor instructor=new Instructor(insNo,insName,insPwd,depId,telephone);
        instructorService.addInstructor(instructor);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/deleteInstructor")
    @ResponseBody
    public ApiResult deleteInstructor(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo){
        instructorService.deleteInstructor(insNo);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/findByidInstructor")
    @ResponseBody
    public ApiResult findByidInstructor(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo){
        List<Instructor> instructorList= instructorService.findByidInstructor(insNo);
        ApiResult result=new ApiResult();
        result.setBody(instructorList);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/updateInstructor")
    @ResponseBody
    public ApiResult updateInstructor(@RequestParam(name = "insNo",required = false,defaultValue = "") String insNo,
                                @RequestParam(name = "insName",required = false,defaultValue = "") String insName,
                                @RequestParam(name = "insPwd",required = false,defaultValue = "") String insPwd,
                                @RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                                @RequestParam(name = "telephone",required = false,defaultValue = "") String telephone
    ){
        Instructor instructor=new Instructor(insNo,insName,insPwd,depId,telephone);
        instructorService.updateInstructor(instructor);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
}
