package org.academiadecodigo.codezillas.insane.services;

import org.academiadecodigo.codezillas.insane.converters.UserToUserDto;
import org.academiadecodigo.codezillas.insane.persistence.model.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    void delete(User user);
    void saveOrUpdate(User user);
    List<User> findBySkill(String skill);

}
