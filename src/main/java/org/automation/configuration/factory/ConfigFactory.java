package org.automation.configuration.factory;

import org.aeonbits.owner.ConfigCache;
import org.automation.configuration.FrameworkConfig;

public class ConfigFactory {

    private ConfigFactory() {}

    public static FrameworkConfig getConfig() {
        return ConfigCache.getOrCreate(FrameworkConfig.class);
    }

}
