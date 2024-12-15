package factoryEnvironment;

import org.openqa.selenium.WebDriver;

public class GridFactory {
    private String browserName;
    private WebDriver driver;
    public GridFactory(String browserName,String ipAddress,String portNumber) {
        this.browserName = browserName;
    }
    public WebDriver createDriver() {
        return driver;
    }
}
