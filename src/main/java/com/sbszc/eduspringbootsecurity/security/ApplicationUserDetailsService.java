package com.sbszc.eduspringbootsecurity.security;

import com.sbszc.eduspringbootsecurity.entity.UserAuth;
import com.sbszc.eduspringbootsecurity.repository.UserAuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;

    public ApplicationUserDetailsService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userAuthRepository.findById(username).get();
        return new ApplicationUserDetails(userAuth);
    }
}
