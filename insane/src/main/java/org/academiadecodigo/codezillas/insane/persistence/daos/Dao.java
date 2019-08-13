package org.academiadecodigo.codezillas.insane.persistence.daos;

import org.academiadecodigo.codezillas.insane.persistence.model.User;

import java.util.List;

public interface Dao<T> {

    T findById(Integer id);
    List<T> findAll();
    T saveOrUpdate(T accountModel);
    void delete(Integer id);
}
