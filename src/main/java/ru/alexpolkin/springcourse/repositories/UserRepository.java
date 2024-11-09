package ru.alexpolkin.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexpolkin.springcourse.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
