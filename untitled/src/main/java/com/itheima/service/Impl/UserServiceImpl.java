package com.itheima.service.Impl;

import com.itheima.entity.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean checkUser(User user){
        boolean flag = false;
        List<User> userList= userMapper.checkUser(user);
        flag=userList.isEmpty();
        return !flag;
    }
    public User find(User user){
       return userMapper.find(user);
    }
    public List<User> findAll(User user) {
        return userMapper.findAll(user);
    }
    public  void  addUser(User user){
        userMapper.addUser(user);
    }
    public  void  deleteUser(String userid){
       userMapper.deleteUser(userid);
    }
    public  List<User>  findByidUser(String userid){
        return userMapper.findByidUser(userid);
    }
    public  void  updateUser(User user){
         userMapper.updateUser(user);
    }
}
