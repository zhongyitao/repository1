package com.cumt.enterprise.service.impl;

import com.cumt.enterprise.dao.UserDao;
import com.cumt.enterprise.domain.Role;
import com.cumt.enterprise.domain.UserInfo;
import com.cumt.enterprise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), getAuthorities(userInfo.getRoles()));

        return user;
    }
}
