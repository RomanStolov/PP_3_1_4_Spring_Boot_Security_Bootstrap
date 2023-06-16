package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
