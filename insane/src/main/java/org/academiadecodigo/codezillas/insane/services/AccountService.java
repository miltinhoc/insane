package org.academiadecodigo.codezillas.insane.services;

import org.academiadecodigo.codezillas.insane.persistence.model.User;

import java.util.*;

public class AccountService implements  UserService{

    Set<User> usersAccounts = new LinkedHashSet<User>();



    public User findById(Integer id) {
        for (User user : usersAccounts){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public void delete(User user) {
        if (!usersAccounts.isEmpty()){
           usersAccounts.remove(user);
        }
    }

    public void saveOrUpdate(User user) {

       usersAccounts.add(user);
    }

    public List<User> findBySkill(String skill) {
       List<User> usersFound = new ArrayList<User>();

       for (User user : usersAccounts){
           if (user.getMainSkill().equals(skill)){                       //todo TEST
               usersFound.add(user);
           }
       }

       return usersFound;
    }

}
