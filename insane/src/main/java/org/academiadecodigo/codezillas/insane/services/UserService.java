package org.academiadecodigo.codezillas.insane.services;

import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface UserService {

    public Set<User> getAll();
    User findById(Integer id);
    void delete(User user);
    void saveOrUpdate(User user);
    List<User> findBySkill(String skill);
}
