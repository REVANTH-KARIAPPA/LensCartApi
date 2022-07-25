package com.LensCart.repository;

import com.LensCart.entity.ERole;
import com.LensCart.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
