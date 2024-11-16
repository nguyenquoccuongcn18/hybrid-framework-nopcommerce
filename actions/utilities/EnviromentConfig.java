package utilities;

import org.aeonbits.owner.Config;

@Config.Sources({"file:enviromentConfig/${server}.properties"})
public interface EnviromentConfig extends Config {
    @Key("App.User")
    String appUser();
    @Key("App.Password")
    String appPassword();
    @Key("App.Url")
    String appUrl();

    String dbUrl();
}
