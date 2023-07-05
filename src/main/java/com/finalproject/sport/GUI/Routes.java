package com.finalproject.sport.GUI;

import com.finalproject.sport.controller.ActivityControllerlmpl;
import com.finalproject.sport.controller.UserControllerImpl;
import com.finalproject.sport.repository.ActivitiesRepositorieslmpl;
import com.finalproject.sport.repository.UsersRepositorieslmpl;

import javax.swing.*;

public class Routes {
    private Window window;

    public Routes (Window window){
        this.window = window;
    }

    public void homePage() {
        UserControllerImpl userController = new UserControllerImpl(new UsersRepositorieslmpl());
        HomePage homePage = new HomePage(userController);
        window.add(homePage.panelHomePage(window));
        window.setVisible(true);
    }

    public void formActivity() {
        ActivityControllerlmpl activityController = new ActivityControllerlmpl(new ActivitiesRepositorieslmpl());
        FormActivity formActivity = new FormActivity(activityController);
        window.add(formActivity.panelFormActivity(window));
        window.setVisible(true);
    }
}
