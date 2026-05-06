package com.lucienroseblood.autominer.ui.panels;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImagePanel extends JPanel {
    //private final BufferedImage image;
    public ImagePanel(String path) {
        setOpaque(false);
        try {
            BufferedImage image = ImageIO.read(new File(path));
            JLabel imgLabel = new JLabel(new ImageIcon(image.getScaledInstance(16, 16, Image.SCALE_FAST)));
            add(imgLabel);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
