package ru.svetlanaagaeva.pp_3_1_1_spring_boot.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.svetlanaagaeva.pp_3_1_1_spring_boot.entity.User;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllPeople() {

        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User newUser) {
        User userToUpdate = entityManager.find(User.class, id);
        if (userToUpdate != null) {
            userToUpdate.setName(newUser.getName());
            userToUpdate.setSurName(newUser.getSurName());
            entityManager.merge(userToUpdate);
        }
    }

    @Override
    public void deleteUserById(int id) {
        User userToDelete = entityManager.find(User.class, id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }
}

