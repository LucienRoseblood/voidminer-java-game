package com.lucienroseblood.autominer.upgrades;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;
import java.awt.*;

public abstract class Upgrade {
    // I thought about adding it to the constructor but description values might change so this is better I guess.
    public abstract String getName();
    public abstract String getDescription();

    /**
     * Called when the upgrade gets purchased.
     */
    protected abstract void Activate();

    public JPanel GetUI()
    {
        //parent panel
        JPanel panel = new JPanel();
        panel.putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: darken($Panel.background,5%)");
        panel.setLayout(new BorderLayout());
        JPanel child = new JPanel();
        child.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        child.setOpaque(false);
        panel.add(child, BorderLayout.CENTER);
        child.setLayout(new BorderLayout());

        //content
        JLabel name = new JLabel(getName());
        child.add(name, BorderLayout.NORTH);
        //TODO not working
        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon(new ImageIcon("images\\icon.png").getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
        //icon.setSize(new Dimension(32, 32));
        child.add(icon, BorderLayout.WEST);

        JLabel description = new JLabel(getDescription());
        child.add(description, BorderLayout.CENTER);

        JLabel cost = new JLabel("stone: 10  iron: 20  balls: 30000");
        child.add(cost, BorderLayout.SOUTH);

        panel.setMinimumSize(new Dimension(290, panel.getPreferredSize().height));
        panel.setMaximumSize(new Dimension(290, panel.getPreferredSize().height));
        return panel;
    }
}
