package com.allen.springbootbase.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: 20190598
 * @Date: 2021/7/30 15:43
 * @Description:
 */
@Component
public class B {

    @Autowired
    private A a;
}
