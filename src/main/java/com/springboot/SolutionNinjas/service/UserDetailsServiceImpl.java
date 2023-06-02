package com.springboot.SolutionNinjas.service;

import com.springboot.SolutionNinjas.model.User;
import com.springboot.SolutionNinjas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= (User) userRepository.findAllByEmailid(email);
        return null;
    }
}
