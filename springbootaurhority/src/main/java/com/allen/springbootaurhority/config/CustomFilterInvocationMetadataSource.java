package com.allen.springbootaurhority.config;

import com.allen.springbootaurhority.dao.MenuDao;
import com.allen.springbootaurhority.entity.Menu;
import com.allen.springbootaurhority.entity.Role;
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
 * @Auther: 20190598
 * @Date: 2020/9/4 15:10
 * @Description:
 */
public class CustomFilterInvocationMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    private MenuDao menuDao;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation)object).getRequestUrl();
        List<Menu> allMenus = menuDao.queryAll(new Menu());
        for( Menu menu : allMenus ){
            if( antPathMatcher.match(menu.getPattern(), requestUrl)) {
                List<Role> roles = menu.getRoles();

                String[] roleArr = new String[roles.size()];
                for ( int i = 0; i < roles.size(); i++ ){
                    roleArr[i] = roles.get(i).getName();
                }

                return SecurityConfig.createList(roleArr);
            }
        }

        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
