package com.allen.springbootenterprisedevelopment.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @Auther: 20190598
 * @Date: 2020/9/8 17:25
 * @Description:
 */
@Configuration
public class ValidationConfig {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("utf-8");
        messageSource.setCacheMillis(-1);
        messageSource.setBasename("ValidationMessage");

        return messageSource;
    }

    //@Bean
    //public Validator validator(){
    //    LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
    //    MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
    //    localValidatorFactoryBean.setMessageInterpolator(interpolatorFactory.getObject());
    //    localValidatorFactoryBean.setValidationMessageSource(messageSource());
    //
    //}
}
