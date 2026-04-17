package com.lucienroseblood.autominer;
import com.lucienroseblood.autominer.resources.ResourceManager;
import com.lucienroseblood.autominer.ui.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ResourceManager.initialize();
        SwingUtilities.invokeLater(() -> {
                GUI gui = new GUI();
        });
    }
}