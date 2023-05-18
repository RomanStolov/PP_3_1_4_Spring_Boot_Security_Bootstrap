package ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.romanstolov.spring.boot.security.pp_3_1_4_spring_boot_security_bootstrap.models.User;

import java.util.Optional;

/**
 * Добавил в этом интерфейсе-репозитории метод поиска пользователя по имени-логину.
 * <p>
 * Прикольно, что тут можно самому написывать любые методы задавая параметры метода и тип возвращаемого значения
 * при совершенно произвольном наименовании самого метода!
 * Этот интерфейс расширяет интерфейс JpaRepository из Spring Data JPA. JpaRepository определяет стандартные
 * методы CRUD, а также операции, специфичные для JPA. Нам не нужно писать код реализации, потому что Spring
 * Data JPA сгенерирует необходимый код во время выполнения в виде прокси-экземпляров.
 * Цель написания интерфейса репозитория - сообщить Spring Data JPA о типе домена (User) и типе идентификатора
 * (Long) для работы.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
