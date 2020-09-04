package com.allen.springbootaurhority.config;

import com.allen.springbootaurhority.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Auther: 20190598
 * @Date: 2020/9/3 16:06
 * @Description:
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

                @Override
                public <O extends FilterSecurityInterceptor> O postProcess(O object) {

                    object.setSecurityMetadataSource(customFilterInvocationMetadataSource());
                    object.setAccessDecisionManager(customAccessDecisionManager());
                    return object;
                }
            })
            .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/hello")
            .permitAll()
            .and()
            .csrf().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_dba > ROLE_admin > ROLE_user";

        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }

    @Bean
    public CustomFilterInvocationMetadataSource customFilterInvocationMetadataSource(){
        return new CustomFilterInvocationMetadataSource();
    }

    @Bean
    public CustomAccessDecisionManager customAccessDecisionManager(){
        return new CustomAccessDecisionManager();
    }
}
