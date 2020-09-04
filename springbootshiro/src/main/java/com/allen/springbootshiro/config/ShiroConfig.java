package com.allen.springbootshiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: 20190598
 * @Date: 2020/9/4 16:21
 * @Description:
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();

        realm.setUserDefinitions("allen=123,user \n admin=123,admin");
        realm.setRoleDefinitions("admin=read,write \n user=read");

        return realm;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        definition.addPathDefinition("/login", "anon");
        definition.addPathDefinition("/doLogin", "anon");
        definition.addPathDefinition("/logout", "logout");
        definition.addPathDefinition("/**", "authc");

        return definition;
    }

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
