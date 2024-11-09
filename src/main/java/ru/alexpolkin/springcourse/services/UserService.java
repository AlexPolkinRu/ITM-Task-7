package ru.alexpolkin.springcourse.services;

import ru.alexpolkin.springcourse.models.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findOne(int id);

    public void update(int id, User user);

    public void save(User user);

    public void delete(int id);

    public void clear();
}
