package com.finalproject.sport.controller;

import com.finalproject.sport.model.Activity;
import com.finalproject.sport.repository.ActivitiesRepository;
import org.bson.Document;

import java.util.List;

public class ActivityControllerlmpl implements ActivityController {

        private final ActivitiesRepository activitiesRepository;

        public ActivityControllerlmpl(ActivitiesRepository activitiesRepository){
                this.activitiesRepository = activitiesRepository;
        }
        @Override
        public String saveActivity(Activity activity) {
            return this.activitiesRepository.create(activity);
        }

        @Override
        public long deleteActivity(Document valueToDelete) {

            return this.activitiesRepository.delete(valueToDelete);
        }

        @Override
        public String updateActivitiy(Document valueToUpdate){
            return "";
        }

        @Override

        public void selectOneWeek(){

        }
}
