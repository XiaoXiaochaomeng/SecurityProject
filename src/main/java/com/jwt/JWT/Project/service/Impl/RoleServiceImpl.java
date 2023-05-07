package com.jwt.JWT.Project.service.Impl;

import com.jwt.JWT.Project.entity.Role;
import com.jwt.JWT.Project.repository.RoleDAO;
import com.jwt.JWT.Project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO rdao;

	@Override
	public List<Role> findAll() {
		return rdao.findAll();
	}

}
