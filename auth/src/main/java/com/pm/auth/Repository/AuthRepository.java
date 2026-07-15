package com.pm.auth.Repository;


import com.pm.auth.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuthRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByUsername(String username);
}
