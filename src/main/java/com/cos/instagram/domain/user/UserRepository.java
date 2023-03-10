package com.cos.instagram.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // JPA Query Method
    User findByUsername(String username);

}
