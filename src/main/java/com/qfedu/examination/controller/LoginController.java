package com.qfedu.examination.controller;

import com.qfedu.examination.common.JsonResult;
import com.qfedu.examination.entity.User;
import com.qfedu.examination.service.UserService;
import com.qfedu.examination.utils.StrUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/*后台登录*/
@CrossOrigin// 支持跨域
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toList")
    public String toUserList() {
        return "backstage";
    }

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String username, String password){

        //根据用户输入的用户名和密码信息创建token对象，用于和合法认证信息进行比较
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //获取Subject主题对象
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new JsonResult(1, null);
        }
        return new JsonResult(0, null);
    }
}
