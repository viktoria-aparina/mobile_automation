package pm.academy.configuration;

import org.aeonbits.owner.Config;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:data/testdata.properties", "classpath:data/credentials.properties"})
public interface TestData extends Config {

    @Key("local.ipAddress")
    String ipAddress();

    @Key("local.appiumPort")
    int appiumPort();

    @DefaultValue(EMPTY)
    String targetBranchName();

    @DefaultValue(EMPTY)
    String targetAppTitle();

    @DefaultValue(EMPTY)
    String existingAppTitle();

    @Key("implicitWait")
    int implicitWait();

    @Key("lowerImplicitWait")
    int lowerImplicitWait();

    @Key("explicitWait")
    int explicitWait();

    @Key("longWait")
    int longWait();

    @Key("newCommandTimeout")
    int newCommandTimeout();
}