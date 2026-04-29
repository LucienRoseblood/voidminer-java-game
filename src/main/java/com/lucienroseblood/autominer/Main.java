package com.lucienroseblood.autominer;
import com.lucienroseblood.autominer.resources.ResourceManager;
import com.lucienroseblood.autominer.ui.*;
import com.lucienroseblood.autominer.upgrades.UpgradeManager;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                ResourceManager.initialize();
                UpgradeManager.initialize();
                GUI gui = new GUI();
                UpgradeManager.addStartingUpgrades();
        });
    }
}