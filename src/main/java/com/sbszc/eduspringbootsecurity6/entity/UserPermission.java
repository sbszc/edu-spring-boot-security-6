package com.sbszc.eduspringbootsecurity6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class UserPermission {

    @Id
    private String permissionName;
}
