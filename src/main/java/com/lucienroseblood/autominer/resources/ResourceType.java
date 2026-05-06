package com.lucienroseblood.autominer.resources;

import java.awt.*;

public enum ResourceType {
    simple(1, 1, new Color(255, 255, 255)),
    compound(2, 3, new Color(200, 200, 200)),
    dense(10, 8, new Color(120, 63, 63)),
    metallic(12, 14, new Color(177, 152, 71));

    private final float toughness;
    private final int cost;
    private final Color color;
    ResourceType(float toughness, int cost, Color color) {
        this.toughness = toughness;
        this.cost = cost;
        this.color = color;
    }
    public double getToughness() { return toughness; }
    public int getCost() { return cost; }
    public Color getColor() { return color; }
}