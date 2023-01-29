package com.sbszc.eduspringbootsecurity6.security;

import com.sbszc.eduspringbootsecurity6.entity.UserAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationUserDetails implements UserDetails {

    private final UserAuth userAuth;

    public ApplicationUserDetails(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> permissions = new HashSet<>();

        userAuth.getRoles().forEach(userRole -> {
            Set<GrantedAuthority> auxPermissions = userRole.getPermissions().stream()
                    .map(userPermission -> new SimpleGrantedAuthority(userPermission.getPermissionName()))
                    .collect(Collectors.toSet());

            permissions.addAll(auxPermissions);
        });

        return permissions;
//        return userAuth.getRoles().stream()
//                .map(userRole -> new SimpleGrantedAuthority("ROLE_" + userRole.getRoleName()))
//                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return userAuth.getPassword();
    }

    @Override
    public String getUsername() {
        return userAuth.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userAuth.getIsAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userAuth.getIsAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userAuth.getIsCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userAuth.getIsEnabled();
    }
}
