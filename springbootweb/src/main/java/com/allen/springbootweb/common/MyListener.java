package com.allen.springbootweb.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Auther: 20190598
 * @Date: 2020/6/24 14:14
 * @Description:
 */
@WebListener
public class MyListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyListener>>>>>>>>>>>requestDestroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyListener>>>>>>>>>>>requestInitialized");
    }
}
