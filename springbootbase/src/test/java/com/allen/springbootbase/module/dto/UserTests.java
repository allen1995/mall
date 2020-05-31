package com.allen.springbootbase.module.dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: allen
 * @Date: 2020-05-30 09:52
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTests {

    @Autowired
    private User user;

    @Test
    public void initUser(){

        Assert.assertEquals("allen", user.getName());
        Assert.assertEquals("广州", user.getAddress());

        User allen = new User();
        allen.setName("allen");
        allen.setAddress("广州");
        List<String> favorites = new ArrayList<>();
        favorites.add("跑步");
        favorites.add("唱歌");
        allen.setFavorites(favorites);

        Assert.assertEquals(allen, user);
    }
}
