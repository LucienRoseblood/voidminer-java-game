package com.lucienroseblood.autominer.ui.panels;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;

public class ResourcesPanel extends JPanel {
    public ResourcesPanel()
    {
        putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: $Panel.background");
        JLabel labelIron = new JLabel("Iron: 0");
        add(labelIron);
    }
}
