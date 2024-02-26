package org.automation.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Mutable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/test-config.properties"
})
public interface FrameworkConfig extends Mutable {

    @DefaultValue("test")
    String env();

    @DefaultValue("local")
    String runMode();

    @DefaultValue("chrome")
    String browser();

}
