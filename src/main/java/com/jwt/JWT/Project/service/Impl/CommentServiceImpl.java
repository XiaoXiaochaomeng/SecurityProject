package com.jwt.JWT.Project.service.Impl;

import com.jwt.JWT.Project.entity.Comment;
import com.jwt.JWT.Project.repository.CommentDAO;
import com.jwt.JWT.Project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDAO cdao;

	@Override
	public Page<Comment> findAll(Pageable pageable) {
		return cdao.findAll(pageable);
	}

	@Override
	public <S extends Comment> S save(S entity) {
		return cdao.save(entity);
	}

	@Override
	public Optional<Comment> findById(Long id) {
		return cdao.findById(id);
	}

	@Override
	public void delete(Comment entity) {
		cdao.delete(entity);
	}

	@Override
	public List<Comment> findAll() {
		return cdao.findAll();
	}

	@Override
	public Page<Comment> findByUsernameContaining(String username, Pageable pageable) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findByUsernameContaining'");
	}

	// @Override
	// public Page<Comment> findByUsernameContaining(String username, Pageable
	// pageable) {
	// return cdao.findByUsernameContaining(username, pageable);
	// }

}
