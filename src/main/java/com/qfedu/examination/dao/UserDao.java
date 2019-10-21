package com.qfedu.examination.dao;

import com.qfedu.examination.entity.Role;
import com.qfedu.examination.entity.User;
import com.qfedu.examination.vo.UserList;

import java.util.List;

public interface UserDao {

    //用户名查询用户
    public User findByName(String username);

    //团=添加用户
    public void addUser(User user);

    // 根据登陆用户的用户名获取权限信息
    public List<String> findPermsByName(String username);

    //查询所有用户
    public List<UserList> findUserAll(String username);

    //根据 uid 查询角色身份
    public List<String> findRolesById(int uid);

    //查询角色信息
    public UserList findRoleId(int uid);

    //通过用户ID查询角色ID
    public List<Integer> findRolesIdByUserId(Integer uid);

    //添加管理员
    public int addRole(Integer uid);

    //添加教师
    public int addTheRole(Integer uid);

    //删除管理员身份
    public int deleteRole(Integer uid);

    //所有角色
    public List<Role> findRoleAll();

    //查询教师id
    public Integer findByTeaIdUserId(Integer uid);


}
