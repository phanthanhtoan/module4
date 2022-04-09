package com.case_study.service.user_role;

import com.case_study.model.Role;

import java.util.List;

public interface RoleService {
    Role findByRoleName(String roleName);
    List<Role> findAll();
    Role findByRoleId(long roleId);
}
