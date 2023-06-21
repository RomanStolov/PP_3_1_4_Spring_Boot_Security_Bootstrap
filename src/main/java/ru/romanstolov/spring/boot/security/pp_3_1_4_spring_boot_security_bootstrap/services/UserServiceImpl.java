package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.Role;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.User;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.repositories.RoleRepository;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.repositories.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllWithoutNPlusOneProblem();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        if (!user.getPassword().equals(findById(user.getId()).getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(User deleteUser) {
        userRepository.delete(deleteUser);
    }

}
