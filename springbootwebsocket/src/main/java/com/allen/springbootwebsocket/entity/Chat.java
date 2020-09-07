package com.allen.springbootwebsocket.entity;

/**
 * @Auther: 20190598
 * @Date: 2020/9/7 13:50
 * @Description:
 */
public class Chat {
    /**
     * 信息来自于who
     */
    private String from;

    /**
     * 信息TO
     */
    private String to;

    /**
     * 信息内容
     */
    private String content;

    public Chat() {
    }

    public Chat(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
