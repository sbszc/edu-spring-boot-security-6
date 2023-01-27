package com.sbszc.eduspringbootsecurity.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor

@Entity
public class UserPermission {

    @Id
    private String permissionName;
}
