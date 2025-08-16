package dev.sipho.dev.connect.service.repository;

import dev.sipho.dev.connect.service.model.DevConnectUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<DevConnectUser, Long> {
    Optional<DevConnectUser> findByUsername(String username);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
