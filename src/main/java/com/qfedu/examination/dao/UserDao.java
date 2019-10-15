package com.qfedu.examination.dao;

import com.qfedu.examination.entity.User;
import com.qfedu.examination.vo.UserList;

import java.util.List;

public interface UserDao {

    public User findByName(String username);

    // 根据登陆用户的用户名获取权限信息
    public List<String> findPermsByName(String username);

    //管理员权限的用户名获取登陆的角色信息和用户名和密码
    public List<UserList> findRolesAll();

    public String findRolesById(int uid);

    public UserList findRoleId(int uid);

    //通过用户ID查询角色ID
    public List<Integer> findRolesIdByUserId(Integer uid);

    //设置成管理员
    public int addRole(Integer uid);

    //删除管理员身份
    public int deleteRole(Integer uid);


}
