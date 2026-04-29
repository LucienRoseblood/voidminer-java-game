package com.lucienroseblood.autominer.resources;

import com.lucienroseblood.autominer.ui.panels.ResourcePanel;
import com.lucienroseblood.autominer.ui.panels.UpgradePanel;
import com.lucienroseblood.autominer.upgrades.UpgradeManager;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Keeps all resource values and manages their changes.
 */
public final class ResourceManager {
    private static Map<ResourceType, Integer> resources;
    private static Map<ResourceType, ResourcePanel> resourcePanels;
    private static Map<ResourceType, UpgradePanel> resourceButtons;

    private ResourceManager() {}

    /**
     * Set the attributes
     */
    public static void initialize() {
        resources = new HashMap<>();
        resourcePanels = new HashMap<>();
        for(ResourceType r : ResourceType.values()) {
            resources.put(r, 0);
        }
    }

    // Resource management methods

    /**
     * Get the amount of a resource.
     * @param resource
     * @return
     */
    public static int getResource(ResourceType resource) {
        return resources.getOrDefault(resource, 0);
    }

    /**
     * Check if the resource amount is not lesser than provided amount
     * @param resource resource type
     * @param amount amount to compare to
     * @return true if there is equal or higher resource amount,
     * false if the resource amount is lesser than provided amount
     */
    public static boolean checkResource(ResourceType resource, Integer amount) {
        return getResource(resource)>=amount;
    }

    /**
     * Check if the resource amount is not lesser than provided amount
     * @param cost map containing resource type and amount of said resource to compare to
     * @return true if there is equal or higher resource amount of all types,
     * false if any of the resource amount is lesser than provided amount
     */
    public static boolean checkResource(Map<ResourceType, Integer> cost) {
        for(ResourceType k : cost.keySet()) {
            if(!checkResource(k, cost.get(k))) return false;
        }
        return true;
    }
    public static void setResource(ResourceType resource, int amount) {
        resources.put(resource, amount);
        if(resourcePanels.containsKey(resource)) resourcePanels.get(resource).UpdateCount(amount);
        UpgradeManager.updateAllButtons();
    }
    public static void addResource(ResourceType resource, int amount) {
        resources.computeIfPresent(resource, (key, value) -> value+amount);
        if(resourcePanels.containsKey(resource)) resourcePanels.get(resource).UpdateCount(resources.get(resource));
        UpgradeManager.updateAllButtons();
    }
    public static boolean useResource(ResourceType resource, int amount) {
        Integer value = resources.get(resource);
        if(value == null || value < amount) return false;
        resources.put(resource, value - amount);
        if(resourcePanels.containsKey(resource)) resourcePanels.get(resource).UpdateCount(resources.get(resource));
        UpgradeManager.updateAllButtons();
        return true;
    }
    public static boolean useResource(Map<ResourceType, Integer> cost) {
        //check if there is enough
        for(ResourceType k : cost.keySet()) {
            if(!checkResource(k, cost.get(k))) return false;
        }
        //use the resources
        for(ResourceType k : cost.keySet()) {
            resources.put(k, resources.get(k)-cost.get(k));
            if(resourcePanels.containsKey(k)) resourcePanels.get(k).UpdateCount(resources.get(k));
        }
        UpgradeManager.updateAllButtons();
        return true;
    }

    /**
     * Generate a ResourceType for next mining operation
     * @param depth depth of mine, used to determine ResourceType
     */
    public static ResourceType getNextResource(int depth)
    {
        return ResourceType.stone;
    }

    public static void AttachResourcePanel(ResourceType type, ResourcePanel panel) {
        resourcePanels.put(type, panel);
    }
}