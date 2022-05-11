package ru.kremneva.springMvcHibernate.service;

import ru.kremneva.springMvcHibernate.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserById(long id);

    void updateUser(User user);

    void deleteUser(long id);
}
