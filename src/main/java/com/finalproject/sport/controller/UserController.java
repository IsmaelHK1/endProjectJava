package com.finalproject.sport.controller;

import com.finalproject.sport.model.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

public interface UserController {
    String saveUser(User user);
   // MongoCollection<Document> getAll();

    User getUser();
}