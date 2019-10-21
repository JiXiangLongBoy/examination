package com.qfedu.examination.controller;

import com.qfedu.examination.common.JsonResult;
import com.qfedu.examination.entity.User;

import com.qfedu.examination.service.MenuInfoService;
import com.qfedu.examination.service.UserService;
import com.qfedu.examination.vo.MenuList;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private UserService userService;

    //动态菜单
    @RequestMapping("/menuList")
    @ResponseBody
    public JsonResult menuList(){
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        User user = userService.findByName(username);
        List<MenuList> menuList = menuInfoService.findMenuInfo(user.getUid());
        return new JsonResult(0,menuList);
    }
}
