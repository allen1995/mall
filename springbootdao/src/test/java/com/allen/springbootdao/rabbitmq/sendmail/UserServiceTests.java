package com.allen.springbootdao.rabbitmq.sendmail;

import com.allen.springbootdao.component.rabbitmq.sendmail.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: allen
 * @Date: 2020-05-24 22:12
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testUserRegistry(){
        userService.userRegistry();
    }

    @Test
    public void testStomp(){
        userService.stomp();
    }
}
