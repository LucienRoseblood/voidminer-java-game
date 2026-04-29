package com.lucienroseblood.autominer.ui.panels;

import com.lucienroseblood.autominer.upgrades.UpgradeManager;
import com.lucienroseblood.autominer.upgrades.UpgradeTest;

import javax.swing.*;
import java.awt.*;

public class UpgradePanel extends JTabbedPane {
    public JPanel upgradeRoot;

    public UpgradePanel() {
        //configuration
        setPreferredSize(new Dimension(300, getPreferredSize().height));
        JPanel child = new JPanel();
        JScrollPane scrollPane = new JScrollPane(child);
        //setLayout(new BorderLayout());
        child.setOpaque(false);
        child.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        addTab("Upgrades", scrollPane);
        child.setLayout(new BoxLayout(child, BoxLayout.Y_AXIS));
        UpgradeManager.setUpgradeRoot(child);
    }
}