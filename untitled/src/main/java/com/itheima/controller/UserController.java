package com.itheima.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

/*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public ApiResult findAll(@RequestParam(name = "query",required = false,defaultValue = "") String query,
                             @RequestParam(name = "pagenum",required = false,defaultValue = "") int pagenum,
                             @RequestParam(name = "pagesize",required = false,defaultValue = "") int pagesize) {
        User user=new User();
        user.setUserid(query);
        PageHelper.startPage(pagenum, pagesize);
        List<User> userList=userService.findAll(user);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setBody(userList);
        result.setMessage("调用成功");
        return result;
    }


    @RequestMapping(value = "/addUser")
    @ResponseBody
    public ApiResult addUser(@RequestParam(name = "userid",required = false,defaultValue = "") String userid,
                             @RequestParam(name = "fullname",required = false,defaultValue = "") String fullname,
                             @RequestParam(name = "password",required = false,defaultValue = "") String password,
                             @RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                             @RequestParam(name = "telephone",required = false,defaultValue = "") String telephone
                             ){
        User user=new User(userid,fullname,password,depId,telephone);
       userService.addUser(user);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public ApiResult deleteUser(@RequestParam(name = "userid",required = false,defaultValue = "") String userid){
        userService.deleteUser(userid);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/findByidUser")
    @ResponseBody
    public ApiResult findByidUser(@RequestParam(name = "userid",required = false,defaultValue = "") String userid){
        List<User> userList=userService.findByidUser(userid);
        ApiResult result=new ApiResult();
        result.setBody(userList);
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }

    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public ApiResult updateUser(@RequestParam(name = "userid",required = false,defaultValue = "") String userid,
                                @RequestParam(name = "fullname",required = false,defaultValue = "") String fullname,
                                @RequestParam(name = "password",required = false,defaultValue = "") String password,
                                @RequestParam(name = "depId",required = false,defaultValue = "") String depId,
                                @RequestParam(name = "telephone",required = false,defaultValue = "") String telephone
     ){
        User user=new User(userid,fullname,password,depId,telephone);

        userService.updateUser(user);
        ApiResult result=new ApiResult();
        result.setCode("200");
        result.setMessage("调用成功");
        return result;
    }
}
