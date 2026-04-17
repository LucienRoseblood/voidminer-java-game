package com.lucienroseblood.autominer.resources;

import com.lucienroseblood.autominer.ui.panels.ResourcePanel;

import java.util.HashMap;
import java.util.Map;


/**
 * Keeps all resource values.
 */
public final class ResourceManager {
    private static Map<ResourceType, Integer> resources;
    private static Map<ResourceType, ResourcePanel> resourcePanels;

    private ResourceManager() {}


    public static void initialize() {
        resources = new HashMap<>();
        resourcePanels = new HashMap<>();
        for(ResourceType r : ResourceType.values()) {
            resources.put(r, 0);
        }
    }


    public static int getResource(ResourceType resource) {
        return resources.getOrDefault(resource, 0);
    }
    public static void setResource(ResourceType resource, int amount) {
        resources.put(resource, amount);
        if(resourcePanels.containsKey(resource)) resourcePanels.get(resource).UpdateCount(amount);
    }
    public static void addResource(ResourceType resource, int amount) {
        resources.computeIfPresent(resource, (key, value) -> value+amount);
        if(resourcePanels.containsKey(resource)) resourcePanels.get(resource).UpdateCount(resources.get(resource));
    }
    public static boolean useResource(ResourceType resource, int amount) {
        Integer value = resources.get(resource);
        if(value == null || value < amount) return false;
        resources.put(resource, value - amount);
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