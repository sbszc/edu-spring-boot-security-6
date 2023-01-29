package com.sbszc.eduspringbootsecurity6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

@Entity
public class UserRole {

    @Id
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserPermission> permissions;
}
