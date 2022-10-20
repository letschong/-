package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.Classes;
import com.itheima.entity.Students;
import com.itheima.service.ClassesService;
import com.itheima.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    /*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize) {
        Students students=new Students();
        students.setStuNo(query);
        PageHelper.startPage(pagenum, pagesize);
        List<Students> studentsList= studentsService.findAll(students);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(studentsList);
        result.setMessage("调用成功");
        return result;
    }


    @RequestMapping(value = "/addStudents")
    @ResponseBody
    public ApiResult addStudents(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo,
                             @RequestParam(name = "stuName",required = false,defaultValue = "") String stuName,
                             @RequestParam(name = "stuSex",required = false,defaultValue = "") String stuSex,
                             @RequestParam(name = "clsId",required = false,defaultValue = "") String clsId,
                             @RequestParam(name = "stuPwd",required = false,defaultValue = "") String stuPwd
    ){
        Students students=new Students(stuNo,stuName,stuSex,clsId,stuPwd);
        studentsService.addStudents(students);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/deleteStudents")
    @ResponseBody
    public ApiResult deleteStudents(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo){
        studentsService.deleteStudents(stuNo);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/findByidStudents")
    @ResponseBody
    public ApiResult findByidStudents(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo){
        List<Students> studentsList= studentsService.findByidStudents(stuNo);
        ApiResult result=new ApiResult();
        result.setBody(studentsList);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/updateStudents")
    @ResponseBody
    public ApiResult updateStudents(@RequestParam(name = "stuNo",required = false,defaultValue = "") String stuNo,
                                    @RequestParam(name = "stuName",required = false,defaultValue = "") String stuName,
                                    @RequestParam(name = "stuSex",required = false,defaultValue = "") String stuSex,
                                    @RequestParam(name = "clsId",required = false,defaultValue = "") String clsId,
                                    @RequestParam(name = "stuPwd",required = false,defaultValue = "") String stuPwd
    ){
        Students students=new Students(stuNo,stuName,stuSex,clsId,stuPwd);
        studentsService.updateStudents(students);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
}
