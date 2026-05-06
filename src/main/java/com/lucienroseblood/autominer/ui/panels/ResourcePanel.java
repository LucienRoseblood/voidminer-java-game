package com.lucienroseblood.autominer.ui.panels;

import com.formdev.flatlaf.FlatClientProperties;
import com.lucienroseblood.autominer.resources.ResourceType;
import javax.swing.*;

/**
 * Intended as part of ResourcesPanel, it's a singular resource entry displaying the amount of it
 */
public class ResourcePanel extends JPanel {
    private final JLabel label;
    private final ResourceType type;


    ResourcePanel(ResourceType type) {
        //image
        add(new ImagePanel("images/"+type.name()+".png"));
        //label
        this.type = type;
        label = new JLabel();
        UpdateCount(0);
        putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: lighten($Panel.background, 5%)");
        add(label);
    }


    public void UpdateCount(int count) {
        label.setText(type.name() + ": " + count);
        System.out.print(count);
    }
}
