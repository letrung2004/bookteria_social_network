package com.bookteria.identity.identityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookteria.identity.identityservice.entity.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {}
