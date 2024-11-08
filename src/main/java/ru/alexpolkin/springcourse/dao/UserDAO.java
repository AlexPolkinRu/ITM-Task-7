package ru.alexpolkin.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alexpolkin.springcourse.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int PEOPLE_COUNT = 0;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++PEOPLE_COUNT, "Aleksandr", "aleksandr@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Elena", "elena@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Maksim", "maksim@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Alexey", "alexey@mail.ru"));
    }

    public List<User> getAll() {
        return users;
    }

    public User get(int id) {
        for (User p : users) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    public void add(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    public void clear() {
        users.clear();
    }

    public void update(int id, User user) {
        User wantedUser = get(id);
        wantedUser.setName(user.getName());
        wantedUser.setEmail(user.getEmail());
    }

    public void delete(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
