package com.jwt.JWT.Project.repository;

import com.jwt.JWT.Project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDAO extends JpaRepository<Comment, Long> {

	// Page<Comment> findByUsernameContaining(String username, Pageable pageable);

}
