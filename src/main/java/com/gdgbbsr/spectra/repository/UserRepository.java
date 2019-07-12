package com.gdgbbsr.spectra.repository;

import com.gdgbbsr.spectra.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findOneByUsername(String username);
}
