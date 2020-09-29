package com.allen.springbootenterprisedevelopment.entity;

import java.io.UnsupportedEncodingException;

/**
 * @Auther: 20190598
 * @Date: 2020/9/9 09:40
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "ç¨æ·å°åä¸è½ä¸ºç©º";
        String s = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(s);
    }
}
