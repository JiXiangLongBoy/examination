/*
package com.qfedu.examination.config;

import com.qfedu.examination.filter.MyLogoutFilter;
import com.qfedu.examination.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    // shiro资源过滤配置
    //设置哪些资源可以匿名访问，哪些资源需要经过认证才能访问，哪些资源需要指定的权限才能访问等等
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 未登陆情况下，访问需要登陆后才能访问资源时，跳转到指定资源（比如登陆页面）
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        // 当没有权限访问某些资源时，跳转到的资源
        shiroFilterFactoryBean.setUnauthorizedUrl("/notPermision");

        // 存放自定义的filter
        LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap();
        //配置自定义登出 覆盖 logout 之前默认的LogoutFilter
        filtersMap.put("logout", myLogoutFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
        // authc:必须认证通过才可以访问;
        // anon: 匿名访问
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/toLogin", "anon");
        filterChainDefinitionMap.put("/layui/**", "anon");

        filterChainDefinitionMap.put("/admin/**", "authc");
        filterChainDefinitionMap.put("/user/**", "authc");

        //perms：访问资源需要的权限 ,注意顺序
        //filterChainDefinitionMap.put("/user/list","perms[goods:list]");

        //退出时，指定logout过滤器
        filterChainDefinitionMap.put("/logout","logout");

        //必须放在所有权限设置的最后，匹配的是不满足前面匹配条件的资源
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    // 安全管理对象
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }

    // 自定义realm对象
    @Bean
    public MyRealm customRealm() {
        MyRealm customRealm = new MyRealm();
        // 设置密码匹配器
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
    }

    */
/* 注解配置 *//*

    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    //加密处理
    //hash匹配器
    @Bean(name = "credentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        // 散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(1);
        // storedCredentialsHexEncoded默认是true，此时用的是密码加密用的是Hex编码；false时用Base64编码
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    //退出
    private MyLogoutFilter myLogoutFilter(){
        MyLogoutFilter logoutFilter = new MyLogoutFilter();
        //
        logoutFilter.setRedirectUrl("/toLogin");
        return logoutFilter;
    }
}
*/
