package factoryEnvironment;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SaucelabFactory {

    private WebDriver driver;
    private String browserName;
    private String osName;
    public SaucelabFactory(String browserName, String osName) {
        this.browserName = browserName;
        this.osName = osName;

    }
    public WebDriver createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", osName);
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("name", "Run on" + osName + " | " + browserName);

        Map<String, Object> sauceOptions = new HashMap<>();
        if (osName.contains("Windows")) {
            sauceOptions.put("screenResolution", "1920x1080");
        }else {
            sauceOptions.put("screenResolution", "1920x1440");
        }
        capabilities.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getSaucelabsUrl()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
