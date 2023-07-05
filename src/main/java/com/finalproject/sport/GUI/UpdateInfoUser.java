package com.finalproject.sport.GUI;

import com.finalproject.sport.controller.UserController;
import com.finalproject.sport.helper.ConvertToLocalDate;
import com.finalproject.sport.mapper.UsersMapper;
import com.finalproject.sport.model.User;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.time.LocalDate;

public class UpdateInfoUser extends JFrame {
    private final UserController userController;
    private ConvertToLocalDate convertToLocalDate = new ConvertToLocalDate();


    private JTextField firstNameLabel;
     private JTextField lastNameLabel;
    private JComboBox<String> genderLabel;
     private  JTextField BirthdayLabel;
     private JButton updateInfo;
    private boolean isValid = true;


    public UpdateInfoUser(UserController userController){
            this.userController = userController;
        }

    private void submitForm() {
        if (firstNameLabel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer votre prénom");
            isValid = false;
        }

        if (lastNameLabel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer votre nom");
            isValid = false;
        }

        if (BirthdayLabel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer votre date de naissance");
            isValid = false;
        }
        if(BirthdayLabel.getText().matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")){
            JOptionPane.showMessageDialog(null, "Veuillez entrer une date de naissance valide"
                    + "au format yyyy-mm-dd");
            isValid = false;
        }

        if (isValid) {
            System.out.println(firstNameLabel.getText());
            System.out.println(lastNameLabel.getText());
            System.out.println( Date.valueOf(BirthdayLabel.getText()));

             userController.updateUser(UsersMapper.userToDocument(userController.getUser()),  UsersMapper.userToDocument(new User(firstNameLabel.getText(), lastNameLabel.getText(), Date.valueOf(BirthdayLabel.getText()), genderLabel.getSelectedItem().toString())));
        }

    }
        public JPanel panelUpdateInfoUser(Window window) {

            String[] genders = {"homme", "femme"};
            lastNameLabel = new JTextField(10);
            lastNameLabel.setText(userController.getUser().getLastName());
            firstNameLabel = new JTextField(10);
            firstNameLabel.setText(userController.getUser().getFirstName());
            genderLabel = new JComboBox<>(genders);
            if(userController.getUser().getGender().equals("homme"))
                genderLabel.setSelectedIndex(0);
            else
                genderLabel.setSelectedIndex(1);
            BirthdayLabel = new JTextField(10);
            BirthdayLabel.setText(convertToLocalDate.convertToLocalDateViaInstant(userController.getUser().getBirthday()).toString());
            updateInfo = new JButton("Modifier les informations");

            JPanel updateInfoUserPanel = new JPanel();
            updateInfoUserPanel.setLayout(new BoxLayout(updateInfoUserPanel, BoxLayout.Y_AXIS));
            updateInfoUserPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            updateInfo.setFont(new Font("Arial", Font.PLAIN, 14));
            updateInfo.setBackground(new Color(0, 100, 0));
            updateInfo.setForeground(Color.white);


            updateInfoUserPanel.add(lastNameLabel);
            updateInfoUserPanel.add(Box.createVerticalStrut(20));
            updateInfoUserPanel.add(firstNameLabel);
            updateInfoUserPanel.add(Box.createVerticalStrut(20));
            updateInfoUserPanel.add(genderLabel, BorderLayout.NORTH);
            updateInfoUserPanel.add(Box.createVerticalStrut(30));
            updateInfoUserPanel.add(BirthdayLabel);
            updateInfoUserPanel.add(Box.createVerticalStrut(20));
           updateInfoUserPanel.add(updateInfo);

            updateInfo.addActionListener(e -> {
                submitForm();
                if (isValid) {
                    JOptionPane.showMessageDialog(null, "Vos informations ont été modifiées avec succès");
                    updateInfoUserPanel.removeAll();
                    updateInfoUserPanel.revalidate();
                    Routes routes = new Routes(window);
                    routes.homePage();
                }
            });

            return  updateInfoUserPanel;
    }
}