package com.finalproject.sport.GUI;

import com.finalproject.sport.controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class HomePage extends JFrame {

    private UserController userController;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;

    private JLabel genderLabel;

    private JLabel BirthdayLabel;
    private JButton nextPageButton;


    public HomePage(UserController userController){
         this.userController = userController;
     }

    public JPanel panelHomePage(Window window) {
        lastNameLabel = new JLabel( "Nom: " + userController.getUser().getLastName());
        firstNameLabel = new JLabel( "Prénom: " + userController.getUser().getFirstName());
        genderLabel = new JLabel("Sexe: " + userController.getUser().getGender());
        BirthdayLabel = new JLabel( "Date de naissance: "+ convertToLocalDateViaInstant(userController.getUser().getBirthday()));
        nextPageButton = new JButton("Suivant");

        JPanel homePagePanel = new JPanel();
        homePagePanel.setLayout(new BoxLayout(homePagePanel, BoxLayout.Y_AXIS));
        homePagePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        nextPageButton.setFont(new Font("Arial", Font.PLAIN, 14));
        nextPageButton.setBackground(new Color(60, 179, 113));
        nextPageButton.setForeground(Color.white);
        nextPageButton.addActionListener(e -> {
            homePagePanel.removeAll();
            homePagePanel.revalidate();
            Routes routes = new Routes(window);
            routes.formActivity();
        });

        homePagePanel.add(lastNameLabel);
        homePagePanel.add(Box.createVerticalStrut(10));
        homePagePanel.add(firstNameLabel);
        homePagePanel.add(Box.createVerticalStrut(10));
        homePagePanel.add(genderLabel);
        homePagePanel.add(Box.createVerticalStrut(10));
        homePagePanel.add(BirthdayLabel);
        homePagePanel.add(Box.createVerticalStrut(10));
        homePagePanel.add(nextPageButton);

        return homePagePanel;
    };

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
