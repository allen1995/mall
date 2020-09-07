package com.allen.springbootwebsocket.entity;

/**
 * @Auther: 20190598
 * @Date: 2020/9/7 10:22
 * @Description:
 */
public class Message {

    private String name;
    private String content;

    public Message() {
    }

    public Message(String name, String content) {
        this.name = name;
        this.content = content;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
