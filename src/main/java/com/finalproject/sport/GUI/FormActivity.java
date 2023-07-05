package com.finalproject.sport.GUI;

import com.finalproject.sport.controller.ActivityController;
import com.finalproject.sport.controller.UserController;
import com.finalproject.sport.model.Activity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormActivity extends JFrame {

    private  ActivityController activityController;
    private UserController userController;

    private static class NextTextFieldActionListener implements ActionListener {
        private final JTextField nextField;

        public NextTextFieldActionListener(JTextField nextField) {
            this.nextField = nextField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            nextField.requestFocusInWindow();
        }
    }

    private JTextField sportNameField;
    private JTextField durationField;
    private JTextField dateField;
    private JTextField rpeField;
    private JButton submitButton;
    private boolean isValid = true;
    public FormActivity(ActivityController activityController){
        this.activityController = activityController;
    }

    public JPanel panelFormActivity(Window window) {

        sportNameField = new JTextField(20);
        durationField = new JTextField(10);
        dateField = new JTextField(10);
        rpeField = new JTextField(10);
        submitButton = new JButton("Enregistrer");


        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        formPanel.add(new JLabel("Sport Name:"), gbc);
        gbc.gridy++;
        formPanel.add(new JLabel("Duration:"), gbc);
        gbc.gridy++;
        formPanel.add(new JLabel("Date (date/month/year) :"), gbc);
        gbc.gridy++;
        formPanel.add(new JLabel("RPE:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(sportNameField, gbc);
        gbc.gridy++;
        formPanel.add(durationField, gbc);
        gbc.gridy++;
        formPanel.add(dateField, gbc);
        gbc.gridy++;
        formPanel.add(rpeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);
        gbc.gridy++;

        sportNameField.addActionListener(new FormActivity.NextTextFieldActionListener(durationField));
        durationField.addActionListener(new FormActivity.NextTextFieldActionListener( dateField));
        dateField.addActionListener(new FormActivity.NextTextFieldActionListener( rpeField));
        rpeField.addActionListener(e -> { submitForm(); });
        submitButton.addActionListener(e -> { submitForm(); });
       //  currentUserButton.addActionListener(e -> { displayCurrentUser(); });

        return formPanel;

    }
    private void submitForm() {
        String sportName = sportNameField.getText();
        String durationStr  = durationField.getText();
        String dateStr  = dateField.getText();
        String rpeStr = rpeField.getText();

        if (!sportName.matches("^[a-zA-Z0-9 ]+$")) {
            JOptionPane.showMessageDialog(this, "Le nom du sport n'est pas valide");
        }

        int duration = 0;
        try {
            duration = Integer.parseInt(durationStr);
        } catch (NumberFormatException ex) {
            isValid = false;
            JOptionPane.showMessageDialog(this, "La durée de l'entrainement n'est pas valide");
        }
        int rpe = 0;
        try {
            rpe = Integer.parseInt(rpeStr);
            if(rpe > 10){
                isValid = false;
                JOptionPane.showMessageDialog(this, "Le rpe doit etre inférieur a 10");
            }
        } catch (NumberFormatException ex) {
            isValid = false;
            JOptionPane.showMessageDialog(this, "Le rpe doit etre est un nombre valide");
        }

        Date date = new Date();
        try{
            date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (ParseException e){
            isValid = false;
            JOptionPane.showMessageDialog(this, "La date n'est pas valide");
        }

        if(isValid){
            Activity activity = new Activity(sportName, duration, date, rpe, rpe * duration);
            String response = activityController.saveActivity(activity);
            JOptionPane.showMessageDialog(this, "Activité enregistrer" + response );
            sportNameField.setText("");
            durationField.setText("");
            dateField.setText("");
            rpeField.setText("");
        }
    }
}
