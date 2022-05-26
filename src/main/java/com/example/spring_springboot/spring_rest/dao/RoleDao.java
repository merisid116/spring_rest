package com.example.spring_springboot.spring_rest.dao;


import com.example.spring_springboot.spring_rest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleDao extends JpaRepository<Role,Long> {
}