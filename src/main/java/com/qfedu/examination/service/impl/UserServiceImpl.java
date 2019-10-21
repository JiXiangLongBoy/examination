package com.qfedu.examination.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examination.dao.UserDao;
import com.qfedu.examination.entity.Role;
import com.qfedu.examination.entity.User;
import com.qfedu.examination.service.UserService;
import com.qfedu.examination.vo.UserList;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        User user1 = userDao.findByName(user.getUsername());
        if (user1 != null){
            throw new RuntimeException("账号已存在");
        }
        //密码加密
        SimpleHash simpleHash = new SimpleHash("md5", user.getPassword(), "haha", 1);
        user.setPassword(simpleHash.toHex());
        userDao.addUser(user);
        //添加教师身份
        userDao.addTheRole(user.getUid());
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public List<String> findPermsByName(String username) {
        return userDao.findPermsByName(username);
    }

    @Override
    public List<UserList> findUserAll(Integer page, Integer limit,String username) {
        PageHelper.startPage(page,limit);
        return userDao.findUserAll(username);
    }

    @Override
    public List<String> findRolesById(int uid) {
        return userDao.findRolesById(uid);
    }

    @Override
    public UserList findRoleId(int uid) {
        return userDao.findRoleId(uid);
    }

    @Override
    public List<Integer> findRolesIdByUserId(Integer uid) {
        return userDao.findRolesIdByUserId(uid);
    }

    @Override
    public int addRole(Integer uid) {
        return userDao.addRole(uid);
    }

    @Override
    public int deleteRole(Integer uid) {
        return userDao.deleteRole(uid);
    }

    @Override
    public Integer findByTeaIdUserId(Integer uid) {
        return userDao.findByTeaIdUserId(uid);
    }

    @Override
    public List<Role> findRoleAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return userDao.findRoleAll();
    }
}
