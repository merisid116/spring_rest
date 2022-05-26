package com.example.spring_springboot.spring_rest.service;

import com.example.spring_springboot.spring_rest.dao.RoleDao;
import com.example.spring_springboot.spring_rest.entity.Role;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {this.roleDao = roleDao;}

    @Override
    public void add(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    public Set<Role> getRoles(long [] ides) {
        Set <Role> roles = new HashSet<>();
        for (int i = 0; i < ides.length; i++) {
            roles.add(roleDao.getById(ides[i]));
        }
        return roles;
    }
}