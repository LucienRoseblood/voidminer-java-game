package com.lucienroseblood.autominer.upgrades;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Keeps the upgrades in a list, commands button updates
 */
public class UpgradeManager {
    private static ArrayList<Upgrade> upgradePool;
    private static JComponent upgradeRoot;
    public static void setUpgradeRoot(JComponent root) {upgradeRoot = root;}

    public static void initialize()
    {
        upgradePool = new ArrayList<>();
    }

    public static void addUpgradeToPool(Upgrade upgrade) {
        upgradePool.add(upgrade);
        upgradeRoot.add(upgrade.getUI());
    }

    public static void updateAllButtons() {
        for(Upgrade u : upgradePool) {
            u.updateButtons();
        }
    }

    public static void removeUpgrade(Upgrade upgrade) {
        upgradeRoot.remove(upgrade.getUI());
        upgradePool.remove(upgrade);
        upgradeRoot.repaint();
    }

    public static void addStartingUpgrades() {
        addUpgradeToPool(new UpgradeTest());
    }
}
