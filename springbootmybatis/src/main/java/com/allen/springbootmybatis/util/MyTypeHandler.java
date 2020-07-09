package com.allen.springbootmybatis.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: 20190598
 * @Date: 2020/7/9 09:30
 * @Description:
 */
public class MyTypeHandler extends BaseTypeHandler<String> {

    private static final String SAN_GUO = "三国";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,parameter);
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return  filter(rs.getString(columnName)) ;
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return filter(rs.getString(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return filter(cs.getString(columnIndex));
    }

    private String filter(String s){
        String result;
        int index = s.indexOf(SAN_GUO);
        if ( s.indexOf(SAN_GUO) != -1 ){
            result = s.substring(index+2);
        } else {
            result = s;
        }

        return result;
    }
}
