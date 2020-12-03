package com.penguinjournals.laboratory.repository;

import com.penguinjournals.laboratory.dao.RoleDao;
import com.penguinjournals.laboratory.domain.Role;
import com.penguinjournals.laboratory.domain.RoleName;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepository {

    private RoleDao roleDao;

    public RoleRepository(final RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public Optional<Role> findByName(RoleName name) {
        return getRoleDao().getRoleByName(name);
    }

    public RoleDao getRoleDao() {
        return this.roleDao;
    }
}
