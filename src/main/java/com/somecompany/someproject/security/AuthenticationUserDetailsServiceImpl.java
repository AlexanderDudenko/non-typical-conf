package com.somecompany.someproject.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class AuthenticationUserDetailsServiceImpl implements AuthenticationUserDetailsService<Authentication> {

    @Override
    public UserDetails loadUserDetails(Authentication authentication) throws UsernameNotFoundException {
        System.out.println("Load user details...");
        return new User("user", "pass", new ArrayList<>());
    }
}
