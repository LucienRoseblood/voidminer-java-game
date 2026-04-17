package com.lucienroseblood.autominer.ui.panels;

import com.formdev.flatlaf.FlatClientProperties;
import com.lucienroseblood.autominer.resources.ResourceManager;
import com.lucienroseblood.autominer.resources.ResourceType;

import javax.swing.*;
import java.awt.*;


/**
 * Intended as part of MinePanel, contains ResourcePanels
 */
public class ResourcesPanel extends JPanel {
    public ResourcesPanel()
    {
        //setMaximumSize(new Dimension(Integer.MAX_VALUE, getMaximumSize().height));

        setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel title = new JLabel("Resources: ");
        add(title);

        // Create a label for each resource
        for(ResourceType r : ResourceType.values()) {
            //invisible separator
            add(Box.createRigidArea(new Dimension(5, 0)));

            //resource label
            ResourcePanel panel = new ResourcePanel(r);
            panel.UpdateCount(0);
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, panel.getMaximumSize().height));
            add(panel);
            ResourceManager.AttachResourcePanel(r, panel);

        }


    }
}
