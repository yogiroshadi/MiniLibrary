package com.technical.service;

import com.technical.entity.Role;
import com.technical.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAllRole() {
        List<Role> listAllRole = roleRepository.findAll();

        return listAllRole;
    }
}
