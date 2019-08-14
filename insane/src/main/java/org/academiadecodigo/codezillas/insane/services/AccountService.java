package org.academiadecodigo.codezillas.insane.services;


import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService implements  UserService{

    Set<User> usersAccounts = new LinkedHashSet<User>();


    @Override
    public Set<User> getAll(){
        return usersAccounts;
    }

    public User findById(Integer id) {
        for (User user : usersAccounts){
            if (user.getId() == id){
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

    @Override
    public boolean authenticate(String email, String password) {
        //User user = null;

        for (User u :
                usersAccounts) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return true; //user = u;
            }
        }
        return false; //user;
    }
}
