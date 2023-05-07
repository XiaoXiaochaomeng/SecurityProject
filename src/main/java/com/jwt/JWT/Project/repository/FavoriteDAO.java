package com.jwt.JWT.Project.repository;

import com.jwt.JWT.Project.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteDAO extends JpaRepository<Favorite, Long> {


}
