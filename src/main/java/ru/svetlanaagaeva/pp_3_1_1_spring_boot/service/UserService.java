package ru.svetlanaagaeva.pp_3_1_1_spring_boot.service;



import ru.svetlanaagaeva.pp_3_1_1_spring_boot.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void saveUser(User user);
    void updateUser(int id, User newUser);
    void deleteUserById(int id);
}
