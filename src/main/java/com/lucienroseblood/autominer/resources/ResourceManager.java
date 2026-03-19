package com.lucienroseblood.autominer.resources;

import java.util.HashMap;
import java.util.Map;


/**
 * Keeps all resource values.
 */
public final class ResourceManager {
    private static Map<ResourceType, Integer> resources;


    private ResourceManager() {}


    public static void initialize()
    {
        resources = new HashMap<>();
        for(ResourceType r : ResourceType.values())
        {
            resources.put(r, 0);
        }
    }


    public static int getResource(ResourceType resource) {
        return resources.getOrDefault(resource, 0);
    }
    public static void setResource(ResourceType resource, int amount) {
        resources.put(resource, amount);
    }
    public static void addResource(ResourceType resource, int amount) {
        resources.computeIfPresent(resource, (key, value) -> value+=amount);
    }
    public static boolean useResource(ResourceType resource, int amount) {
        Integer value = resources.get(resource);
        if(value == null || value < amount) return false;
        resources.put(resource, value - amount);
        return true;
    }


    public static ResourceType getNextResource(int depth)
    {
        return ResourceType.stone;
    }
}