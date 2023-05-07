package com.jwt.JWT.Project.repository;

import com.jwt.JWT.Project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, String> {
	
}
