package com.sbszc.springbootsecuritytutorial.security;

import com.sbszc.springbootsecuritytutorial.entity.UserAuth;
import com.sbszc.springbootsecuritytutorial.repository.UserAuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userAuthRepository.findById(username).get();
        return new ApplicationUserDetails(userAuth);
    }
}
