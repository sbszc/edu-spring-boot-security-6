package com.sbszc.eduspringbootsecurity6.repository;

import com.sbszc.eduspringbootsecurity6.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, String> {
}
