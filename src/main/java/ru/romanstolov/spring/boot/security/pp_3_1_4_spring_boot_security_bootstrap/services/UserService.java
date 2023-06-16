package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services;

import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.Role;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.User;

import java.util.Collection;
import java.util.List;

public interface UserService {

    Collection<Role> getListRole();

    User findUserByUsername(String username);

    List<User> findAll();

    User findUserById(Long id);

    void save(User user);

    void update(User user);

    void delete(User deleteUser);

}

