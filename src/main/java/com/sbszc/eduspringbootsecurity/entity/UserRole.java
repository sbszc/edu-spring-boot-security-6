package com.sbszc.eduspringbootsecurity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
