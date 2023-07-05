package com.finalproject.sport.GUI;

import javax.swing.*;

public class Stats extends JFrame {

    private JTextPane title;
    private JTextPane totalLoad;
    private JTextPane monotony;
    private JTextPane strain;
    private JTextPane fitness;
    private JTextPane acuteChronic;

    public JPanel panelStats(Window window) {
        JPanel statsPanel = new JPanel();
        statsPanel.add(new JLabel("Stats"));
        return statsPanel;
    }
}
