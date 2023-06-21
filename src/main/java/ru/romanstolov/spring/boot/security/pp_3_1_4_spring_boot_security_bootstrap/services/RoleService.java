package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services;

import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.Role;

import java.util.Collection;

public interface RoleService {

    Collection<Role> getListRole();

}
