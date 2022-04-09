package com.case_study.service.user_role.impl;

import com.case_study.model.Role;
import com.case_study.repository.user_role.RoleRepository;
import com.case_study.service.user_role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRoleId(long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }
}
