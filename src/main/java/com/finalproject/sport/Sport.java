package com.finalproject.sport;

import com.finalproject.sport.GUI.Routes;
import com.finalproject.sport.GUI.Window;
import com.finalproject.sport.model.Activity;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sport {
    private static final Logger logger = LoggerFactory.getLogger(Sport.class);
    public static void main(String[] arg) {
        Window window = new Window();
        Routes routes = new Routes(window);
        routes.homePage();
  }

}
