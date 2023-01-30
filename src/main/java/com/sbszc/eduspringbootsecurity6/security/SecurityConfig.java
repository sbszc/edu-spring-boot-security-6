package com.sbszc.eduspringbootsecurity6.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig /*extends WebSecurityConfigurerAdapter CHANGES ON SECURITY 6*/ {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return auth;
    }

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails user = User.withUsername("user")
//                .password(passwordEncoder.encode("password"))
////                .roles("READ_ONLY")
//                .authorities("read")
//                .build();
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder.encode("password"))
////                .roles("ADMIN")
//                .authorities("read", "write")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .httpBasic().and()
//                .headers().frameOptions().disable().and()
//                .formLogin().and()
                /*.authorizeRequests()*/
                /*.antMatchers()*/
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/write").hasAnyAuthority("write")
                .requestMatchers(HttpMethod.GET, "/read").hasAnyAuthority("read")
                .requestMatchers(HttpMethod.GET, "/ping").permitAll()
//                .requestMatchers(HttpMethod.POST, "/write").hasAnyRole("ADMIN")
//                .requestMatchers(HttpMethod.GET, "/read").hasAnyRole("ADMIN", "READ_ONLY")
//                .requestMatchers(HttpMethod.GET, "/ping").permitAll()
                .and()
                .build();
    }
}
