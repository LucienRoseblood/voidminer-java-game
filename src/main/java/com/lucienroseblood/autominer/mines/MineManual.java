package com.lucienroseblood.autominer.mines;

import com.formdev.flatlaf.FlatClientProperties;
import com.lucienroseblood.autominer.resources.ResourceManager;
import com.lucienroseblood.autominer.resources.ResourceType;

import javax.swing.*;
import java.awt.*;

public final class MineManual extends JPanel implements IMine {
    private float progress;
    private int depth;
    private float digThreshold;
    private JButton mineButton;
    private JProgressBar mineProgressBar;
    private JProgressBar mineDepthBar;

    public MineManual() {
        progress = 0f;
        digThreshold = 1f;

        //create GUI
        setPreferredSize(new Dimension(96, 96));
        putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: darken($Panel.background,5%)");
        //putClientProperty(FlatClientProperties.STYLE, "border: 1,1,1,1,@disabledForeground,1,16; background: $Panel.background");

        //button
        mineButton = new JButton("Stone");
        mineButton.addActionListener(_ -> click());
        mineButton.setPreferredSize(new Dimension(64, 64));
        add(mineButton);
        //progressBar
        mineProgressBar = new JProgressBar(0, 100);
        mineProgressBar.setValue(getProgressForProgressBar());
        mineProgressBar.setPreferredSize(new Dimension(64, 8));
        add(mineProgressBar);
    }

    @Override
    public void click() {
        progress(0.1f);
    }

    @Override
    public float getProgress() {
        return progress;
    }

    @Override
    public JPanel getJPanel() {
        return this;
    }

    @Override
    public int getProgressForProgressBar() {
        return (int)(getProgress()/digThreshold*100f);
    }

    @Override
    public void progress(float amount) {
        progress+=amount;
        while(progress>= digThreshold)
        {
            excavate();
            progress-= digThreshold;
        }
        mineProgressBar.setValue(getProgressForProgressBar());
    }

    @Override
    public void excavate() {
        ResourceManager.addResource(ResourceType.simple, 1);
    }
}