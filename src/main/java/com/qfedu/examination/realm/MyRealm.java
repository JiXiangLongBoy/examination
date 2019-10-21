package com.qfedu.examination.realm;

import com.qfedu.examination.entity.User;
import com.qfedu.examination.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    // @Lazy //使用redis缓存shiro中数据时，需要使用该注解
    private UserService userService;

    //获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取合法登录的用户名
        String name = (String) principalCollection.getPrimaryPrincipal();

        //查询拥有的权限
        List<String> list = userService.findPermsByName(name);

        //授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(new HashSet(list));

        return info;
    }

    //获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用户的身份信息
        String name = (String) authenticationToken.getPrincipal();
        User user = userService.findByName(name);
        SimpleAuthenticationInfo info = null;
        if (user == null){
            info = new SimpleAuthenticationInfo("","",this.getName());
            throw new RuntimeException("用户名错误");
        } else {   //身份认证的信息对象
            //第一个参数: 用户的身份信息 用户名
            //第二个参数: 用户的凭证信息 密码
            //第三个参数: realm的名称
            //info = new SimpleAuthenticationInfo(name,user.getPassword(),this.getName());
            //如果MD5中使用了盐值，需要在认证信息对象设置盐值
            info = new SimpleAuthenticationInfo(name,user.getPassword(), ByteSource.Util.bytes("haha"),this.getName());
        }
        return info;
    }

    public static void main(String[] args) {
        SimpleHash simpleHash = new SimpleHash("md5", "111", "haha", 1);
        System.out.println(simpleHash.toHex());
    }
}
