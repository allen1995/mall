package com.allen.springbootenterprisedevelopment.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Auther: 20190598
 * @Date: 2020/9/8 14:49
 * @Description:
 */
@ApiModel(value = "用户实体类", description = "用户实体信息类")
public class User {

    private Integer id;

    @ApiModelProperty(value = "用户名")
    @Size(min = 5, max = 10, message = "{user.name.size}")
    private String username;
    @ApiModelProperty(value = "地址")
    @NotNull(message = "{user.address.notnull}")
    private String address;
    private String gender;


    public User() {
    }

    public User(Integer id, String username, String address, String gender) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
