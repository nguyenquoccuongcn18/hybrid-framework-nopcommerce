package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:envConfig/${server}.properties"})
public interface EnvConfig extends Config {

    @Key("App.Url")
    String appUrl();

    @Key("App.User")
    String appUserName();

    @Key("App.Pass")
    String appPassword();

    String dbUrl();
}