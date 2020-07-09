package com.allen.springbootmybatis.util;

import com.allen.springbootmybatis.entity.Book;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: 20190598
 * @Date: 2020/7/9 10:31
 * @Description:
 */
public class MyObjectFactory extends DefaultObjectFactory {

    private static Map<String,String> aliaseMap = new HashMap<>();

    static {
        aliaseMap.put("三国演义","新三国演义");
    }

    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T result = super.create(type, constructorArgTypes, constructorArgs);
        if( Book.class.isAssignableFrom(type) ){
            Book entity = (Book) result;
            if ( aliaseMap.containsKey(entity.getName())){
                entity.setAliaseName(aliaseMap.get(entity.getName()));
            }
        }

        return result;
    }

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
