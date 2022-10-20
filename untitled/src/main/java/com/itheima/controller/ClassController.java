package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.Classes;
import com.itheima.entity.User;
import com.itheima.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/classes")
public class ClassController {
    @Autowired
    private ClassesService classesService;

    /*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize) {
        Classes classes=new Classes();
        classes.setClsId(query);
        PageHelper.startPage(pagenum, pagesize);
        List<Classes> classesList= classesService.findAll(classes);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(classesList);
        result.setMessage("调用成功");
        return result;
    }


    @RequestMapping(value = "/addClasses")
    @ResponseBody
    public ApiResult addUser(@RequestParam(name = "clsId",required = false,defaultValue = "") String clsId,
                             @RequestParam(name = "clsName",required = false,defaultValue = "") String clsName,
                             @RequestParam(name = "clsMajor",required = false,defaultValue = "") String clsMajor,
                             @RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                             @RequestParam(name = "clsGrade",required = false,defaultValue = "") String clsGrade
    ){
        Classes classes=new Classes(clsId,clsName,clsMajor,depId,clsGrade);
        classesService.addClasses(classes);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/deleteClasses")
    @ResponseBody
    public ApiResult deleteUser(@RequestParam(name = "clsId",required = false,defaultValue = "") String clsId){
        classesService.deleteClasses(clsId);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/findByidClasses")
    @ResponseBody
    public ApiResult findByidUser(@RequestParam(name = "clsId",required = false,defaultValue = "") String clsId){
        List<Classes> classesList= classesService.findByidClasses(clsId);
        ApiResult result=new ApiResult();
        result.setBody(classesList);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/updateClasses")
    @ResponseBody
    public ApiResult updateUser(@RequestParam(name = "clsId",required = false,defaultValue = "") String clsId,
                                @RequestParam(name = "clsName",required = false,defaultValue = "") String clsName,
                                @RequestParam(name = "clsMajor",required = false,defaultValue = "") String clsMajor,
                                @RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                                @RequestParam(name = "clsGrade",required = false,defaultValue = "") String clsGrade
    ){
        Classes classes=new Classes(clsId,clsName,clsMajor,depId,clsGrade);
        classesService.updateClasses(classes);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
}
