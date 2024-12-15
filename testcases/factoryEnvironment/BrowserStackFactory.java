package factoryEnvironment;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserStackFactory {

    private WebDriver driver;
    private String browserName;
    private String osName;
    private String osVer;
    public BrowserStackFactory(String browserName, String osName, String osVer) {
        this.browserName = browserName;
        this.driver = driver;
        this.osName = osName;
        this.osVer = osVer;
    }
    public WebDriver createDriver() {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", browserName);
        bstackOptions.put("os", osName);
        bstackOptions.put("osVersion", osVer);
        bstackOptions.put("browserVersion", "latest");
        bstackOptions.put("sessionName", "Run on " + osName + " " + osVer + " with " + browserName + "|" + "CuongTestAuto");
        bstackOptions.put("projectName", "CuongTestCloud");
        bstackOptions.put("debug", "true");
        capabilities.setCapability("bstack:options", bstackOptions);
        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getBrowserstackUrl()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
