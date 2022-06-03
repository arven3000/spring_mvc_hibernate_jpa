package ru.kremneva.springMvcHibernate.dao;

import org.springframework.stereotype.Repository;
import ru.kremneva.springMvcHibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = entityManager.createQuery("select u from User u");
        return query.getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager
                .find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    @Override
    public void deleteUser(long id) {
        User updateUser = entityManager
                .find(User.class, id);
        entityManager.remove(updateUser);
    }
}
