package com.jwt.JWT.Project.service.Impl;

import com.websiteshop.dao.FavoriteDAO;
import com.websiteshop.entity.Favorite;
import com.websiteshop.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	FavoriteDAO fdao;

	@Override
	public List<Favorite> findAll() {
		return fdao.findAll();
	}

	@Override
	public Optional<Favorite> findById(Long id) {
		return fdao.findById(id);
	}

	@Override
	public void delete(Favorite entity) {
		fdao.delete(entity);
	}

	@Override
	public <S extends Favorite> S save(S entity) {
		return fdao.save(entity);
	}
	
}
