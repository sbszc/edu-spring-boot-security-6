package com.sbszc.eduspringbootsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

//        auth.
//                inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
////                .roles("READ_ONLY")
//                .authorities("read")
//                .and()
//                .withUser("admin")
//                .password("password")
////                .roles("ADMIN")
//                .authorities("read", "write");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//required for post, solves: ("status": 403,"error": "Forbidden")
//                .headers().frameOptions().disable().and()//required for post using form login, solves: (type=Method Not Allowed, status=405)
                .httpBasic().and()
//                .formLogin().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/write").hasAnyAuthority("write")
                .antMatchers(HttpMethod.GET, "/read").hasAnyAuthority("read")
                .antMatchers(HttpMethod.GET, "/ping").permitAll();
//                .antMatchers(HttpMethod.POST, "/write").hasAnyRole("ADMIN")
//                .antMatchers(HttpMethod.GET, "/read").hasAnyRole("ADMIN", "READ_ONLY")
//                .antMatchers(HttpMethod.GET, "/ping").permitAll();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
