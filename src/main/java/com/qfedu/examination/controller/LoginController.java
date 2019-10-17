package com.qfedu.examination.controller;

import com.qfedu.examination.common.JsonResult;
import com.qfedu.examination.entity.User;
import com.qfedu.examination.service.UserService;
import com.qfedu.examination.utils.StrUtil;
import io.swagger.annotations.Api;
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

// 支持跨域
@CrossOrigin
@Controller
@Api(value = "登录接口",tags = "登录接口")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(String username, String password, HttpSession session){

        //根据用户输入的用户名和密码信息创建token对象，用于和合法认证信息进行比较
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //获取Subject主题对象
        Subject subject = SecurityUtils.getSubject();

        User user = userService.findByName(username);

        List<Integer> rolesIds = userService.findRolesIdByUserId(user.getUid());

        try {
            subject.login(token);
            session.setAttribute(StrUtil.LONGIN_USER, user);
            session.setAttribute("rids",rolesIds);
            return new JsonResult(0, null);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new JsonResult(1, null);
        }
    }
}
