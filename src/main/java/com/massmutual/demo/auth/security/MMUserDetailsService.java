package com.massmutual.demo.auth.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.massmutual.demo.entity.User;
import com.massmutual.demo.service.UserServiceImpl;

@Service(value = "MMUserDetailsService")
public class MMUserDetailsService implements UserDetailsService {


    private UserServiceImpl userService;

    @Autowired
    public MMUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not found in records");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),getAuthorities(user));
    }

    private Set<SimpleGrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    }

}
