package com.lucienroseblood.autominer.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import com.lucienroseblood.autominer.ui.panels.MinePanel;
import com.lucienroseblood.autominer.ui.panels.UpgradePanel;

import javax.swing.*;
import java.awt.*;


/// <summary>
/// UI structure:
/// mainPanel
/// -minePanel
/// --resourcePanel
/// ---IResources
/// --excavationPanel
/// ---IMines
/// -upgradePanel
/// --IUpgrades
/// </summary>
public class GUI {
    public GUI() {
        FlatDarkLaf.setup();

        JFrame frame=new JFrame();
        frame.setSize(1024, 780);

        //background
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        frame.add(mainPanel);


        //mine panel
        JComponent minePanel = new MinePanel();
        GridBagConstraints c = new GridBagConstraints();
        //mainPanel.add(minePanel, c);
        //upgrade panel
        JComponent upgradePanel = new UpgradePanel();
        //mainPanel.add(upgradePanel);


        //split
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, minePanel, upgradePanel);
        splitPane.setResizeWeight(1.0);
        splitPane.setEnabled(false);
        mainPanel.add(splitPane, BorderLayout.CENTER);


        frame.setMinimumSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        //frame.setResizable(false);
        frame.setVisible(true);
    }
}
