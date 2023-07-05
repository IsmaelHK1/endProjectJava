package com.finalproject.sport.repository;

import com.finalproject.sport.model.Activity;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Date;

public interface ActivitiesRepository {
     String create(Activity activity);
     String readAll();
     String readOne(Document document);
     String update(Document query, Document newValue );
     long delete(Document valueToDelete);
}
