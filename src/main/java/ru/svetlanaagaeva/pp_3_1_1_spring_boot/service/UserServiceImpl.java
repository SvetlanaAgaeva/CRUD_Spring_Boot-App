package ru.svetlanaagaeva.pp_3_1_1_spring_boot.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.svetlanaagaeva.pp_3_1_1_spring_boot.DAO.UserDao;
import ru.svetlanaagaeva.pp_3_1_1_spring_boot.entity.User;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {
    private final UserDao userDao;


    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllPeople();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User newUser) {
        userDao.updateUser(id, newUser);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);

    }
}
