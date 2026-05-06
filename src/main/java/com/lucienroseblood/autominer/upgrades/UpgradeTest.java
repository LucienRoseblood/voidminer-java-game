package com.lucienroseblood.autominer.upgrades;

import com.lucienroseblood.autominer.resources.ResourceType;

import java.util.Map;

public class UpgradeTest extends Upgrade {
    @Override
    public String getName() {
        return "TestUpgrade";
    }

    @Override
    public String getDescription() {
        return "<html>Some random ass description<br>Also balls<br>Balls2<br><p style=\"color:#FF0000;\">Red paragraph text</p></html>";
    }

    @Override
    public boolean getIsRepetitive() {
        return false;
    }

    @Override
    public Map<ResourceType, Integer> getCost() {
        return Map.of(ResourceType.simple, 1);
    }

    @Override
    protected void Activate() {
        System.out.println("Balls");
    }
}