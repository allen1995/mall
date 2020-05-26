package com.allen.springbootdao.component.rabbitmq.sendmail;

import lombok.Getter;
import lombok.Setter;

/**
 * @Auther: allen
 * @Date: 2020-05-24 21:52
 * @Description:
 */
@Getter
@Setter
public class Mail {
    /**
     * 发件人
     */
    private String from;

    /**
     * 收件人
     */
    private String to;

    /**
     * 邮件标题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String content;

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
