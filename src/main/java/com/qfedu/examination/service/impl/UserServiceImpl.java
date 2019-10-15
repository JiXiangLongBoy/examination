package com.qfedu.examination.service.impl;

import com.qfedu.examination.dao.UserDao;
import com.qfedu.examination.entity.User;
import com.qfedu.examination.service.UserService;
import com.qfedu.examination.vo.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }

    @Override
    public List<String> findPermsByName(String username) {
        return userDao.findPermsByName(username);
    }

    @Override
    public List<UserList> findRolesAll() {
        return userDao.findRolesAll();
    }

    @Override
    public String findRolesById(int uid) {
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
}
