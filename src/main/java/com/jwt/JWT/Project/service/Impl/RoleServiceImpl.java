package com.jwt.JWT.Project.service.Impl;

import com.jwt.JWT.Project.entity.Role;
import com.jwt.JWT.Project.repository.RoleRepository;
import com.jwt.JWT.Project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    // Thong tin role dao
    @Autowired
    private RoleRepository roleRepository;

    /**
     * Tim kiem role theo id cua role
     *
     * @param thong tin id cua role
     * @return Role tim duoc
     */
    @Override
    public Role findRoleById(int roleId) {
        return roleRepository.findById(roleId).get();
    }

    /**
     * Tim ten vai tro dua vao user id
     *
     * @param thong tin user id
     * @return danh sach ten vai tro tim duoc
     */
    @Override
    public List<String> getRoleNames(int userId) {
        return roleRepository.getRoleNames(userId);
    }
}
