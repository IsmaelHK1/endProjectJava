package com.finalproject.sport.controller;

import com.finalproject.sport.model.Activity;
import org.bson.Document;

import java.util.List;

public interface ActivityController {
    String saveActivity(Activity activity);
    //List<Activity>
    void selectOneWeek();
    long deleteActivity(Document valueToDelete);
    String updateActivitiy(Document valueToUpdate);
}
