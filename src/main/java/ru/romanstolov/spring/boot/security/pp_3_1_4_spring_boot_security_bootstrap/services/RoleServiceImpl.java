package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.Role;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.repositories.RoleRepository;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Collection<Role> getListRole() {
        return roleRepository.findAll();
    }

}
