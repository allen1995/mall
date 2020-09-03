package com.allen.springbootsecurity.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 20190598
 * @Date: 2020/9/2 19:31
 * @Description:
 */
@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("root").password("$2a$10$noVsPp6ngP8EPbpBtijWLu5ck/teVcqz329kNVFqLs1oq8eroddpy").roles("ADMIN","DBA")
                .and()
                .withUser("admin").password("$2a$10$noVsPp6ngP8EPbpBtijWLu5ck/teVcqz329kNVFqLs1oq8eroddpy").roles("ADMIN","USER")
                .and()
                .withUser("allen").password("$2a$10$noVsPp6ngP8EPbpBtijWLu5ck/teVcqz329kNVFqLs1oq8eroddpy").roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .antMatchers("/user/**")
                .access("hasAnyRole('ADMIN','USER')")
                .antMatchers("/db/**")
                .access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.loginPage("/login_page")
                //.defaultSuccessUrl("/hello")
                .loginProcessingUrl("/login")
                .usernameParameter("name")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                            HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        Object principal = authentication.getPrincipal();
                        httpServletResponse.setContentType("application/json;charset=utf-8");

                        PrintWriter writer = httpServletResponse.getWriter();
                        httpServletResponse.setStatus(200);

                        Map<String,Object> map = new HashMap<>();
                        map.put("status", 200);
                        map.put("msg", principal);

                        ObjectMapper objectMapper = new ObjectMapper();
                        writer.write(objectMapper.writeValueAsString(map));

                        writer.flush();
                        writer.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req,
                                HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        PrintWriter out = resp.getWriter();

                        resp.setContentType("application/json;charset=utf-8");
                        resp.setStatus(401);

                        Map<String,Object> map = new HashMap<>();
                        map.put("status", 401);
                        if( e instanceof LockedException ){
                            map.put("msg", "账户已被锁定,登陆失败！");
                        } else if( e instanceof BadCredentialsException ){
                            map.put("msg", "用户名或者密码错误，登陆失败！");
                        } else if( e instanceof DisabledException ){
                            map.put("msg", "账户被禁用，登陆失败！");
                        } else if( e instanceof AccountExpiredException ){
                            map.put("msg", "账户已过期， 登陆失败！");
                        } else if( e instanceof CredentialsExpiredException ){
                            map.put("msg", "密码已过期，登陆失败！");

                        } else {
                            map.put("msg", "登陆失败！");
                        }

                        ObjectMapper objectMapper = new ObjectMapper();
                        out.write(objectMapper.writeValueAsString(map));
                        out.flush();
                        out.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .addLogoutHandler(new LogoutHandler() {
                    @Override
                    public void logout(HttpServletRequest httpServletRequest,
                                       HttpServletResponse httpServletResponse, Authentication authentication) {

                    }
                })
                .logoutSuccessHandler( new LogoutSuccessHandler() {
                        @Override
                        public void onLogoutSuccess(HttpServletRequest httpServletRequest,
                            HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                            httpServletResponse.sendRedirect("/login");
                        }
                    }
                );


                //使用默认的登陆页面
                //.and()
                //.formLogin()
                //.loginProcessingUrl("/login")
                //.permitAll()
                //.and()
                //.csrf()
                //.disable();

    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    }
}
