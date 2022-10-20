package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.Department;
import com.itheima.entity.User;
import com.itheima.service.DepartmentService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

/*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize) {
        Department department=new Department();
        department.setDepId(query);
        PageHelper.startPage(pagenum, pagesize);
        List<Department> departmentList=departmentService.findAll(department);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(departmentList);
        result.setMessage("调用成功");
        return result;
    }


    @RequestMapping(value = "/addDepartment")
    @ResponseBody
    public ApiResult addDepartment(@RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                             @RequestParam(name = "depName",required = false,defaultValue = "") String depName,
                             @RequestParam(name = "depaType",required = false,defaultValue = "") String depaType){
        Department department=new Department(depId,depName,depaType);
        departmentService.addDepartment(department);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/deleteDepartment")
    @ResponseBody
    public ApiResult deleteDepartment(@RequestParam(name = "depId",required = false,defaultValue = "") String depId){
        departmentService.deleteDepartment(depId);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/findByidDepartment")
    @ResponseBody
    public ApiResult findByidDepartment(@RequestParam(name = "depId",required = false,defaultValue = "") String depId){
        List<Department> departmentList=departmentService.findByidDepartment(depId);
        ApiResult result=new ApiResult();
        result.setBody(departmentList);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/updateDepartment")
    @ResponseBody
    public ApiResult updateDepartment(@RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                                      @RequestParam(name = "depName",required = false,defaultValue = "") String depName,
                                      @RequestParam(name = "depaType",required = false,defaultValue = "") String depaType) {
        Department department=new Department(depId,depName,depaType);
        departmentService.updateDepartment(department);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
}
