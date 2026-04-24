package com.lucienroseblood.autominer.upgrades;

import com.formdev.flatlaf.FlatClientProperties;
import com.lucienroseblood.autominer.resources.ResourceType;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public abstract class Upgrade {
    // I thought about adding it to the constructor but description values might change so this is better I guess.
    public abstract String getName();
    public abstract String getDescription();

    public abstract Map<ResourceType, Integer> getCost();
    public String getCostString() {
        StringBuilder costString = new StringBuilder();
        for(ResourceType r : ResourceType.values()) {
            if(getCost().containsKey(r)) costString.append(r.name()).append(": ").append(getCost().get(r)).append("  ");
        }
        return costString.toString();
    }

    //UI things
    protected JLabel descriptionLabel;
    protected JLabel costLabel;
    protected JButton buyButton;
    protected JButton buyBulkButton;


    /**
     * Called when the upgrade gets purchased.
     */
    protected abstract void Activate();

    /**
     * Builds UI of an upgrade button and returns it attached to JPanel.
     * @return JPanel containing an upgrade button as a child.
     */
    public JPanel getUI()
    {
        //parent panel
        JPanel panel = new JPanel();
        panel.putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: darken($Panel.background,5%)");
        panel.setLayout(new BorderLayout());
        //text child
        JPanel child = new JPanel();
        child.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        child.setOpaque(false);
        panel.add(child, BorderLayout.CENTER);
        child.setLayout(new BorderLayout());

        //content
        JLabel name = new JLabel(getName());
        name.setFont(new Font(name.getFont().getFontName(), Font.BOLD, 15));
        child.add(name, BorderLayout.NORTH);
        //TODO not working
        //JLabel icon = new JLabel();
        //icon.setIcon(new ImageIcon(new ImageIcon("images\\icon.png").getImage().getScaledInstance(600, 600, Image.SCALE_SMOOTH)));
        //icon.setSize(new Dimension(32, 32));
        //child.add(icon, BorderLayout.WEST);

        descriptionLabel = new JLabel(getDescription());
        child.add(descriptionLabel, BorderLayout.CENTER);

        //cost
        JPanel costPanel = new JPanel();
        costPanel.setOpaque(false);
        costPanel.setLayout(new BorderLayout());
        child.add(costPanel, BorderLayout.SOUTH);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        costPanel.add(separator, BorderLayout.NORTH);

        costLabel = new JLabel(getCostString());
        costPanel.add(costLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        costPanel.add(buttonPanel, BorderLayout.SOUTH);

        //buttons
        buyButton = new JButton("Buy");
        buyBulkButton = new JButton("Buy x10");
        buttonPanel.add(buyButton);
        buttonPanel.add(buyBulkButton);

        panel.setMinimumSize(new Dimension(290, panel.getPreferredSize().height));
        panel.setMaximumSize(new Dimension(290, panel.getPreferredSize().height));
        return panel;
    }

    /**
     * Updates the content of JLabel costLabel.
     */
    public void updateCost()
    {
        if(costLabel==null) return;

        //do something
    }
}
