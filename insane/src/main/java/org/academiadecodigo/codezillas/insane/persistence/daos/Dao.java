package org.academiadecodigo.codezillas.insane.persistence.daos;

import org.academiadecodigo.codezillas.insane.persistence.model.User;

import java.util.List;

public interface Dao {

    User findById();
    void saveOrUpdate();
    void delete();
    List<User> findBySkill();
}
