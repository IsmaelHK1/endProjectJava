package com.finalproject.sport.GUI;

import com.finalproject.sport.controller.ActivityControllerlmpl;
import com.finalproject.sport.controller.UserControllerImpl;
import com.finalproject.sport.repository.ActivitiesRepositorieslmpl;
import com.finalproject.sport.repository.UsersRepositorieslmpl;
import com.finalproject.sport.repository.UsersRepository;


import javax.swing.*;

public class Window  extends JFrame {

    public Window() {
        super("Sport Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

