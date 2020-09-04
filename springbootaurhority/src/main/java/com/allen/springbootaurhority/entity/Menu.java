package com.allen.springbootaurhority.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2020-09-04 14:55:42
 */
public class Menu implements Serializable {
    private static final long serialVersionUID = -59084327735480476L;
    
    private Integer id;
    
    private String pattern;

    private List<Role> roles;
    
    private LocalDateTime createtime;
    
    private LocalDateTime updatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}