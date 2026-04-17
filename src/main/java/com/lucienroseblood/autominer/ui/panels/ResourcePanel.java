package com.lucienroseblood.autominer.ui.panels;

import com.formdev.flatlaf.FlatClientProperties;
import com.lucienroseblood.autominer.resources.ResourceType;
import javax.swing.*;

public class ResourcePanel extends JPanel {
    private final JLabel label;
    private final ResourceType type;


    ResourcePanel(ResourceType type) {
        this.type = type;
        label = new JLabel();
        UpdateCount(0);
        putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: $Panel.background");
        add(label);
    }


    public void UpdateCount(int count) {
        label.setText(type.name() + ": " + count);
        System.out.print(count);
    }
}
