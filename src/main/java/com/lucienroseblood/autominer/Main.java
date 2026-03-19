package com.lucienroseblood.autominer;
import com.lucienroseblood.autominer.ui.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                GUI gui = new GUI();
        });
    }
}