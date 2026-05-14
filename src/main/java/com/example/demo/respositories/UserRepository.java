package com.example.demo.respositories;

import com.example.demo.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository(){
        users.add(new User(1,"John","john@gmail.com","ADMIN"));
        users.add(new User(2,"anna","anna@gmail.com","USER"));
        users.add(new User(3,"tom","tom@gmail.com","ADMIN"));
    }
    public List<User> findAll(){
        return users;
    }
}
