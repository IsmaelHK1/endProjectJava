package com.finalproject.sport.repository;

import com.finalproject.sport.model.User;
import org.bson.Document;

public interface UsersRepository {
    String create(User user);

    String update(Document query, Document newValue);
    User read();
    // String delete();
}
