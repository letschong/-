package com.itheima.mapper;



import com.itheima.entity.User;

import java.util.List;

public interface UserMapper {
    public User find(User user);
    public List<User> checkUser(User user);
    public List<User> findAll(User user);
    public  void  addUser(User user);
    public  void  deleteUser(String userid);
    public  List<User>findByidUser(String userid);
    public  void  updateUser(User user);
}
