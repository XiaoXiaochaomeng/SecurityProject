package com.jwt.JWT.Project.repository;

import com.jwt.JWT.Project.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryDAO extends JpaRepository<Category, Long> {

	Page<Category> findByNameContaining(String name, Pageable pageable);

	long countByNameContaining(String name);
}
