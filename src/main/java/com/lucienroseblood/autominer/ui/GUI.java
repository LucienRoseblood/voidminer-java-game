package com.lucienroseblood.autominer.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.lucienroseblood.autominer.ui.panels.MinePanel;
import com.lucienroseblood.autominer.ui.panels.UpgradePanel;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.*;

public class GUI {
    public GUI(){
        FlatDarkLaf.setup();

        JFrame frame=new JFrame();
        frame.setSize(1024, 780);

        //background
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2, 5, 5));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(mainPanel);

        //main panels
        JPanel minePanel = new MinePanel();
        GridBagConstraints c = new GridBagConstraints();
        mainPanel.add(minePanel, c);

        //mainPanel.add(new JSeparator(JSeparator.VERTICAL));
        JPanel upgradePanel = new UpgradePanel();
        mainPanel.add(upgradePanel);


        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
