package com.jwt.JWT.Project.service;

import com.jwt.JWT.Project.entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {

	void delete(Feedback entity);

	Optional<Feedback> findById(Long id);

	List<Feedback> findAll();

	<S extends Feedback> S save(S entity);

	Page<Feedback> findAll(Pageable pageable);

	// Page<Feedback> findByUsernameContaining(Account account, Pageable pageable);
}
