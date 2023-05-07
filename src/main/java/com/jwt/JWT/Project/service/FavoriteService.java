package com.jwt.JWT.Project.service;

import com.websiteshop.entity.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {
	
	void delete(Favorite entity);

	Optional<Favorite> findById(Long id);

	List<Favorite> findAll();

	<S extends Favorite> S save(S entity);
}
