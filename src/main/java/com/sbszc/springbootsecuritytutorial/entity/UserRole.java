package com.sbszc.springbootsecuritytutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {

    @Id
    String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserPermission> permissions;
}
