package ru.svetlanaagaeva.pp_3_1_1_spring_boot.DAO;



import ru.svetlanaagaeva.pp_3_1_1_spring_boot.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllPeople();

    User getUserById(int id);

    void save(User user);

    void updateUser(int id, User newUser);

    void deleteUserById(int id);


}



