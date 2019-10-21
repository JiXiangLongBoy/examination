package com.qfedu.examination.controller;

import com.github.pagehelper.Page;
import com.qfedu.examination.common.JsonResult;
import com.qfedu.examination.dao.UserDao;
import com.qfedu.examination.entity.Role;
import com.qfedu.examination.entity.User;
import com.qfedu.examination.service.UserService;
import com.qfedu.examination.vo.UserList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    //获取用户名
    @RequestMapping("/username")
    @ResponseBody
    public JsonResult username(){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        System.err.println(username);
        return new JsonResult(0,username);
    }

    @RequiresPermissions("user:list")
    @RequestMapping("/adduser")
    public String addUser(){
        return "adduser";
    }

    //添加后台用户,默认教师角色
    @RequestMapping("/addUser")
    @ResponseBody
    @RequiresPermissions("user:list")
    public JsonResult addUser(User user){
        System.err.println(user.getUsername());
        userService.addUser(user);
        return new JsonResult(0,null);
    }

    @RequiresPermissions("perm:list")
    @RequestMapping("/permManage")
    public String permManage(){
        return "permissionManage";
    }

    //权限用户
    @RequestMapping("/permList")
    @ResponseBody
    @RequiresPermissions("perm:list")
    public Map<String,Object> userList(Integer page, Integer limit){
        List<UserList> users = userService.findUserAll(page,limit,"");
        for (UserList user : users) {
            if (user.getRole().size() > 1){
                user.setRdesc("管理员/教师");
            } else {
                List<Role> roles = user.getRole();
                for (Role role : roles) {
                    user.setRdesc(role.getRdesc());
                }
            }
        }
        long total = ((Page) users).getTotal();
        Map<String,Object> map = new HashMap();
        map.put("count",total);
        map.put("data",users);
        map.put("code",0);
        return map;
    }

    //设置教师管理员身份
    @RequestMapping("/addRole")
    @ResponseBody
    @RequiresPermissions("role:list")
    public JsonResult addRole(Integer uid){
        List<Integer> roleIds = userService.findRolesIdByUserId(uid);
        if (roleIds.size() > 1){
            return new JsonResult(1,null);
        } else {
            Integer teaId = userService.findByTeaIdUserId(uid);
            if (teaId != 2){
                return new JsonResult(1,null);
            }
        }
        userService.addRole(uid);
        return new JsonResult(0,null);
    }

    //删除教师管理员身份
    @RequestMapping("/deleteRole")
    @ResponseBody
    @RequiresPermissions("role:list")
    public JsonResult deleteRole(Integer uid){
        List<Integer> roleIds = userService.findRolesIdByUserId(uid);
        if (roleIds.size() > 1){
            userService.deleteRole(uid);
            return new JsonResult(0,null);
        }
        return new JsonResult(1,null);
    }

    @RequestMapping("/userManage")
    @RequiresPermissions("user:list")
    public String userlist(){
        return "userManage";
    }

    //所有用户
    @RequestMapping("/userList")
    @ResponseBody
    @RequiresPermissions("user:list")
    public Map<String,Object> userLists(Integer page, Integer limit,String username){
        ArrayList<UserList> list = new ArrayList<UserList>();
        List<UserList> users = userService.findUserAll(page,limit,username);
        for (UserList user : users) {
            List<Role> role = user.getRole();
            for (Role role1 : role) {
                UserList user1 = new UserList();
                user1.setRdesc(role1.getRdesc());
                user1.setUid(user.getUid());
                user1.setUsername(user.getUsername());
                user1.setPassword(user.getPassword());
                list.add(user1);
            }
        }
        long total = ((Page) users).getTotal();
        Map<String,Object> map = new HashMap();
        map.put("count",total);
        map.put("code",0);
        map.put("data",list);
        return map;
    }

    @RequestMapping("/roleManage")
    @RequiresPermissions("role:list")
    public String rolelist(){
        return "roleManage";
    }

    @RequestMapping("/roleList")
    @ResponseBody
    @RequiresPermissions("role:list")
    public Map<String,Object> roleList(Integer page, Integer limit){
        List<Role> roleList = userService.findRoleAll(page,limit);
        long total = ((Page) roleList).getTotal();
        Map<String,Object> map = new HashMap();
        map.put("code",0);
        map.put("data",roleList);
        map.put("count",total);
        return map;
    }

}
