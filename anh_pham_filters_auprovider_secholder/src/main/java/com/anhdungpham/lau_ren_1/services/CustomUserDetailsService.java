package com.anhdungpham.lau_ren_1.services;

import com.anhdungpham.lau_ren_1.entities.UserEntity;
import com.anhdungpham.lau_ren_1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if(user == null) {
            throw  new UsernameNotFoundException("NOT FOUND");
        }
        return new CustomUserDetails(user);

    }
}
