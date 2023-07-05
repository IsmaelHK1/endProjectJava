package com.finalproject.sport.repository;

import com.finalproject.sport.mapper.UsersMapper;
import com.finalproject.sport.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
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
    public  String update(Document query, Document newValue){
        Document updateObject = new Document();
        updateObject.put("$set", newValue);

        MongoCollection<Document> collection = connect();
        UpdateResult result = collection.updateOne(query, updateObject);
        return Objects.requireNonNull(result.getUpsertedId()).toString();
    }

    @Override
    public User read(){
        MongoCollection<Document> collection = connect();
        return collection.find().map(UsersMapper::documentToUser).first();
    }
}
