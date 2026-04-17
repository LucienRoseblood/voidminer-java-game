package com.lucienroseblood.autominer.upgrades;

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
    protected void Activate() {

    }
}
