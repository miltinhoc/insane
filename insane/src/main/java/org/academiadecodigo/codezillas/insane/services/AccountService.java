package org.academiadecodigo.codezillas.insane.services;


import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService implements UserService{

    private int currentIndex = 0;
    private Set<User> usersAccounts = new LinkedHashSet<User>();

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
        user.setId(currentIndex+1);
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
    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
