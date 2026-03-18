package com.lucienroseblood.autominer;
import com.lucienroseblood.autominer.ui.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
            }
        });
    }
}