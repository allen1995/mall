//package com.allen.springbootweb.config;
//
//import com.google.gson.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.json.GsonHttpMessageConverter;
//
//import java.lang.reflect.Modifier;
//import java.lang.reflect.Type;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
///**
// * @Auther: allen
// * @Date: 2020-06-07 09:37
// * @Description:
// */
//@Configuration
//public class GsonConfig {
//
//    @Bean
//    public GsonHttpMessageConverter gsonHttpMessageConverter(){
//        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
//        GsonBuilder builder = new GsonBuilder();
//        builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
//        builder.registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
//            @Override
//            public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
//                return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            }
//        }).registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
//            @Override
//            public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
//                return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//            }
//        });
//        Gson gson = builder.create();
//
//        converter.setGson(gson);
//        return converter;
//    }
//}
