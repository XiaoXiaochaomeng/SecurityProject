package com.jwt.JWT.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT u.role.name FROM UserRole u WHERE u.user.id = :uid")
    List<String> getRoleNames(@Param("uid") Integer id);

    @Query("SELECT u FROM UserRole u WHERE u.user.id = :uid")
    UserRole getRoleByUserId(@Param("uid") Integer id);
}
