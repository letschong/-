package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.dto.ApiResult;
import com.itheima.entity.Instructor;
import com.itheima.entity.Students;
import com.itheima.entity.User;
import com.itheima.service.InstructorService;
import com.itheima.service.StudentsService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller

public class LoginController {
        @Autowired
        private UserService userService;

        @Autowired
        private StudentsService studentsService;

        @Autowired
        private InstructorService instructorService;
        /*    @RequestParam("query") String query,@RequestParam("pagenum") int pagenum,@RequestParam("pagesize") int pagesize*/
        @RequestMapping(value = "/login")
        @ResponseBody
        public ApiResult findAll(@RequestParam(name = "userid",required = false,defaultValue = "") String userid,
                                 @RequestParam(name = "password",required = false,defaultValue = "") String password){
            User user=new User();
            user.setUserid(userid);
            user.setPassword(password);

            Students students=new Students();
            students.setStuNo(userid);
            students.setStuPwd(password);

            Instructor instructor=new Instructor();
            instructor.setInsNo(userid);
            instructor.setInsPwd(password);

            ApiResult result=new ApiResult();
            boolean flag=userService.checkUser(user);
            boolean flag1 = studentsService.checkStudent(students);
            boolean flag2 = instructorService.checkinstructor(instructor);
            if(flag){
                result.setCode("200");
                User user1= userService.find(user);
                result.setToken(user1.getType());
                result.setBody(user1);
                result.setMessage("登录成功");
            } else if(flag1){
                result.setCode("200");
                result.setToken("5");
                Students students1 =studentsService.find(students);
                result.setBody(students1);
                result.setMessage("登录成功");
            }
            else if(flag2){
                result.setCode("200");
                result.setToken("4");
                Instructor instructor1=instructorService.find(instructor);
                result.setBody(instructor1);
                result.setMessage("登录成功");
            }
            else{
                result.setCode("404");
                result.setMessage("找不到userid["+userid+"]");
            }
            return result;
        }

    }
