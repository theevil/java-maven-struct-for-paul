package com.example.vetclinic.infrastructure.persistence;

import com.example.vetclinic.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleJpaRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
