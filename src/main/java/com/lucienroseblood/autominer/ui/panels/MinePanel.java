package com.lucienroseblood.autominer.ui.panels;

import com.formdev.flatlaf.FlatClientProperties;
import com.lucienroseblood.autominer.mines.IMine;
import com.lucienroseblood.autominer.mines.MineManual;
import com.lucienroseblood.autominer.resources.ResourceType;

import javax.swing.*;
import java.awt.*;

public class MinePanel extends JTabbedPane {
    public MinePanel() {
        //add a panel to add margin
        JPanel child = new JPanel();
        child.setOpaque(false);
        child.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        child.setLayout(new BoxLayout(child, BoxLayout.PAGE_AXIS));
        addTab("Mines", child);

        //add elements
        JPanel panelResources = new ResourcesPanel();
        child.add(panelResources);

        JPanel panelButton = new JPanel();
        child.add(panelButton);

        //panelButton.setLayout(new BorderLayout());
        panelButton.putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: $Panel.background");

        IMine mine = new MineManual();
        panelButton.add(mine.getJPanel());
    }
}
