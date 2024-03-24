package com.ciphersentinel.server.repository;

import com.ciphersentinel.server.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VaultRepository extends JpaRepository<Credential, Long>
{
    List<Credential> findByUserId(int userId);
}