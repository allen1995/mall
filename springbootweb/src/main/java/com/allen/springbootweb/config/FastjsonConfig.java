package com.allen.springbootweb.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import sun.reflect.generics.tree.Tree;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allen
 * @Date: 2020-06-07 10:05
 * @Description:
 */
@Configuration
public class FastjsonConfig {

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setCharset(Charset.forName("UTF-8"));
        config.setSerializerFeatures(
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );

        // 处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);

        converter.setFastJsonConfig(config);
        return converter;
    }
}
