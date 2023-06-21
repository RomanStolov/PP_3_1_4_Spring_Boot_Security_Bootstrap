package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.User;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.repositories.UserRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь с таким именем не найден в БД!");
        }
        return new org.springframework.security.core.userdetails.User(optionalUser.get().getUsername(),
                optionalUser.get().getPassword(), optionalUser.get().getRoles());
    }

}
