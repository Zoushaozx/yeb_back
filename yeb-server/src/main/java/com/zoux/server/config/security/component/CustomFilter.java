package com.zoux.server.config.security.component;

import com.zoux.server.pojo.Menu;
import com.zoux.server.pojo.Role;
import com.zoux.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 权限控制
 * 根据请求url分析请求所需的角色
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private IMenuService menuService;
    //引入AntPathMatcher 在做uri匹配规则发现这个类，根据源码对该类进行分析，它主要用来做类URLs字符串匹配；
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //获得menus
        List<Menu> menus = menuService.getMenusWithRole();
        //循环判断 我们当前的url与获取的url是否匹配
        for (Menu menu : menus) {
            //判断请求url与角色允许url是否匹配
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                //利用jdk8新特性stream流map一下
                String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                //能够匹配就将匹配的角色放入/list
                return SecurityConfig.createList(str);
            }
        }
        //如果url匹配不上就默认给一个登陆角色
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
