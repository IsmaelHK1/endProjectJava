package com.finalproject.sport.repository;

import com.finalproject.sport.mapper.ActivitiesMapper;
import com.finalproject.sport.model.Activity;
import com.finalproject.sport.model.Stat;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


public class ActivitiesRepositorieslmpl implements ActivitiesRepository {
    private static final Logger logger = LoggerFactory.getLogger(ActivitiesRepository.class);
    private static final String urlDB = "mongodb+srv://Ismael:7j5McC04o01mFmBW@javaproject.buz1ibu.mongodb.net/?retryWrites=true&w=majority";
    private static final String dbName = "JavaProject";
    private static final String collectionName = "Activity";

    private MongoCollection<Document> connect() {
        MongoClient mongoClient = MongoClients.create(urlDB);
        MongoDatabase database = mongoClient.getDatabase(dbName);
        return database.getCollection(collectionName);

    }
@Override
public String create(Activity activity){
    MongoCollection<Document> collection = connect();
    InsertOneResult result = collection.insertOne(ActivitiesMapper.activityToDocument(activity));
    return Objects.requireNonNull(result.getInsertedId()).toString();
}

@Override
public String readAll(){
    MongoCollection<Document> collection = connect();
    return collection.find().toString();
}


    @Override
    public Stat readOneWeek() {
        MongoCollection<Document> collection = connect();
        LocalDate localendDate = LocalDate.now();
        ActivitiesMapper activitiesMapper = new ActivitiesMapper();
        Date startDate = java.sql.Date.valueOf(localendDate.minusDays(7));
        Date endDate = java.sql.Date.valueOf(localendDate);

        Bson filter = new Document("date", new Document("$gte", startDate).append("$lte", endDate));
        Iterable<Document> iterable = collection.find(filter);

        Iterable<Stat> stats;
        Stat stat;
        Activity activity;
        int totalLoad = 0;
        int monotony = 0;
        int strain = 0;
        int fitness = 0;
        int acuteChronic = 0;

        // Calculer tout le bordel en moyenne du debut a la fin de la semaine

        for (Document document : iterable) {
            activity = activitiesMapper.documentToActivity(document);
            totalLoad = totalLoad + activity.getLoad();

        }

        return null;
    }

    @Override
    public String readOne(Document query){
        MongoCollection<Document> collection = connect();
        return collection.find(query).toString();
    }

    @Override
    public String update(Document query, Document newValue ){
        Document updateObject = new Document();
        updateObject.put("$set", newValue);

        MongoCollection<Document> collection = connect();
        UpdateResult result = collection.updateOne(query, updateObject);
        return Objects.requireNonNull(result.getUpsertedId()).toString();
    }

    @Override
    public long delete(Document valueToDelete ){
        MongoCollection<Document> collection = connect();

        DeleteResult result = collection.deleteOne(valueToDelete);
        return  result.getDeletedCount();
    }
}


