package com.finalproject.sport.repository;

import com.finalproject.sport.mapper.UsersMapper;
import com.finalproject.sport.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import java.util.Objects;

public class UsersRepositorieslmpl implements UsersRepository{
    private static final String urlDB = "mongodb+srv://Ismael:7j5McC04o01mFmBW@javaproject.buz1ibu.mongodb.net/?retryWrites=true&w=majority";
    private static final String dbName = "JavaProject";
    private static final String collectionName = "User";

    private MongoCollection<Document> connect() {
        MongoClient mongoClient = MongoClients.create(urlDB);
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database.getCollection(collectionName);
    }


    @Override
    public String create(User user){
        MongoCollection<Document> collection = connect();
        InsertOneResult result = collection.insertOne(UsersMapper.userToDocument(user));
        return Objects.requireNonNull(result.getInsertedId()).toString();
    }

    @Override
    public void update(Document query, Document newValue){

        MongoCollection<Document> collection = connect();
        collection.replaceOne(query, newValue);
    }

    @Override
    public User read(){
        MongoCollection<Document> collection = connect();
        return collection.find().map(UsersMapper::documentToUser).first();
    }
}
