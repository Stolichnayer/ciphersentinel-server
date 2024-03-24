package com.ciphersentinel.server.repository;

import com.ciphersentinel.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsernameAndPassword(String username, String password);
}