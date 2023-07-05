package com.finalproject.sport.controller;

import com.finalproject.sport.model.User;
import com.finalproject.sport.repository.UsersRepository;
import org.bson.Document;

public class UserControllerImpl implements UserController {
    UsersRepository usersRepository;

    public UserControllerImpl(UsersRepository userRepository) {
        this.usersRepository = userRepository;
    }

    @Override
    public String saveUser(User user) {
        return this.usersRepository.create(user);
    }

    @Override
    public void updateUser(Document query, Document newValue) {
        this.usersRepository.update( query, newValue);
    }

    @Override
    public User getUser() {
        return this.usersRepository.read();
         }

    // @Override
    // public MongoCollection<Document> getAll() {
    //    return this.userRepository.getAll();
    //}

}