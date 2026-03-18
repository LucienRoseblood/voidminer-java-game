package com.lucienroseblood.autominer.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GUI {
    public GUI(){
        FlatDarkLaf.setup();

        JFrame frame=new JFrame();

        //background
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);


        //main panels
        JPanel panelMine = new JPanel();
        mainPanel.add(panelMine);

        JPanel panelUpgrade = new JPanel();
        mainPanel.add(panelUpgrade);


        //mine panel
        JPanel panelResources = new JPanel();
        panelMine.add(panelResources);

        JPanel panelButton = new JPanel();
        panelMine.add(panelButton);


        //resource
        JLabel labelIron = new JLabel("Iron: 0");
        panelResources.add(labelIron);

        //button
        JButton mineButton = new JButton("Mine");
        panelButton.add(mineButton);


        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
