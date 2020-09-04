package com.allen.springbootaurhority.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Auther: 20190598
 * @Date: 2020/9/4 15:24
 * @Description:
 */
public class CustomAccessDecisionManager implements AccessDecisionManager {


    @Override
    public void decide(Authentication authentication, Object object,
           Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> auths = authentication.getAuthorities();

        for( ConfigAttribute configAttribute : configAttributes ){
            if( "ROLE_LOGIN".equals( configAttribute.getAttribute())  && authentication instanceof UsernamePasswordAuthenticationToken ){
                return;
            }

            for( GrantedAuthority grantedAuthority : auths ){
                if( configAttribute.getAttribute().equals(grantedAuthority.getAuthority())){
                    return;
                }
            }
        }

        throw new AccessDeniedException("权限不足！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
