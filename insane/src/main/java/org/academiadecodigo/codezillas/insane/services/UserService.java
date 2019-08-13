package org.academiadecodigo.codezillas.insane.services;

import org.academiadecodigo.codezillas.insane.persistence.model.User;

import java.util.List;

public interface UserService {

    void delete(User user);
    void saveOrUpdate(User user);
    List<User> findBySkill(String skill);
}
