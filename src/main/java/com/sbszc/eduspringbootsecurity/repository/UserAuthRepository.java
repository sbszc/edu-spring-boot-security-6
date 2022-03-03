package com.sbszc.eduspringbootsecurity.repository;

import com.sbszc.eduspringbootsecurity.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, String> {
}
