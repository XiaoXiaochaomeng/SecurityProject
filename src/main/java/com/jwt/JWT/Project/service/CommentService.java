package com.jwt.JWT.Project.service;

import com.websiteshop.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CommentService {

	List<Comment> findAll();

	void delete(Comment entity);

	Optional<Comment> findById(Long id);

	<S extends Comment> S save(S entity);

	Page<Comment> findAll(Pageable pageable);

	Page<Comment> findByUsernameContaining(String username, Pageable pageable);

}
