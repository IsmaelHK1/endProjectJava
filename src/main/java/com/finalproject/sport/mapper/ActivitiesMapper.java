package com.finalproject.sport.mapper;

import com.finalproject.sport.model.Activity;
import org.bson.Document;

import java.time.LocalDate;
import java.util.Date;

public class ActivitiesMapper {
    public static Document activityToDocument(Activity activity) {
        return new Document()
                .append("name", activity.getName())
                .append("duration", activity.getDuration())
                .append("date", activity.getDate())
                .append("RPE", activity.getRPE())
                .append("load", activity.getLoad());
    }

    private Activity documentToActivity(Document document) {
        String name = document.getString("name");
        int duration = document.getInteger("duration");
        Date date = document.getDate("date");
        int RPE = document.getInteger("RPE");
        int load = document.getInteger("load");

        return new Activity(name, duration, date, RPE, load);
    }
}
