package com.example.spring_springboot.spring_rest.service;

import com.example.spring_springboot.spring_rest.entity.Role;

import java.util.Set;

public interface RoleService {
    void add (Role role);
    Role getById (long id);
    Set<Role> getRoles(long [] ides);
}
