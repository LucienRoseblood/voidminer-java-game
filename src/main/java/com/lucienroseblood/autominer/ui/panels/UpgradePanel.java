package com.lucienroseblood.autominer.ui.panels;

import com.formdev.flatlaf.FlatClientProperties;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class UpgradePanel extends JPanel {
    public UpgradePanel() {
        putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: darken($Panel.background,5%)");
        setLayout(new BorderLayout());
        //TODO make upgrades
    }
}
