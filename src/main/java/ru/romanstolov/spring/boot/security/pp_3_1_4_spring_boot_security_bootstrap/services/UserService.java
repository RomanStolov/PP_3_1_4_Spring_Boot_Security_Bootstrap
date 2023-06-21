package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services;

import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void update(User user);

    void delete(User deleteUser);

}

