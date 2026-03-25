package com.lucienroseblood.autominer.mines;

import javax.swing.*;

public interface IMine {
    /**
     * Take action when the mine is clicked
     */
    public void click();


    /**
     * Returns progress value
     *
     * @return Progress value
     */
    public float getProgress();


    /**
     * Used to put the mine UI inside another panel.
     * @return JPanel with mine UI.
     */
    public JPanel getJPanel();


    /**
     * Returns normalized progress value
     *
     * @return progress value in range from 0 to 1
     */
    public int getProgressForProgressBar();


    /**
     * Progress the mine digging by amount
     *
     * @param amount How much should the mine progress
     */
    public void progress(float amount);


    /**
     * Instantly mine the current resource without touching the progress
     */
    public void excavate();
}
