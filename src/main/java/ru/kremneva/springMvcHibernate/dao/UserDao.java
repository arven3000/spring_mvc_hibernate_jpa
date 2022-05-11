package ru.kremneva.springMvcHibernate.dao;

import ru.kremneva.springMvcHibernate.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getUserById(long id);

    void updateUser(User user);

    void deleteUser(long id);
}
