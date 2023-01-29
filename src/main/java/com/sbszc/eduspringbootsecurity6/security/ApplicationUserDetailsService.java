package com.sbszc.eduspringbootsecurity6.security;

import com.sbszc.eduspringbootsecurity6.repository.UserAuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;

    public ApplicationUserDetailsService(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAuthRepository.findById(username)
                .map(ApplicationUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("username:'%s' not found", username)));
    }
}
