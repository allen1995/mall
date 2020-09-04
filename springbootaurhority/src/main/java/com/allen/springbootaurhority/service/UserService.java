package com.allen.springbootaurhority.service;

import com.allen.springbootaurhority.dao.UserDao;
import com.allen.springbootaurhority.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: 20190598
 * @Date: 2020/9/3 15:44
 * @Description:
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userDao.loadUserByUsername(username);

        if( user == null ){
            throw new  UsernameNotFoundException("用户不存在！");
        }

        user.setRoles(userDao.getUserRoleByUid(user.getId()));

        return user;
    }
}
