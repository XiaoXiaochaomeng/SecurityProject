package com.jwt.JWT.Project.service.Impl;

import com.websiteshop.dao.RoleDAO;
import com.websiteshop.entity.Role;
import com.websiteshop.service.RoleService;
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
