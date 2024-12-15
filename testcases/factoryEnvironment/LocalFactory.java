package factoryEnvironment;

import commons.BrowserList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private String browserName;
    private WebDriver driver;
    public LocalFactory(String browserName) {
        this.browserName = browserName;
    }

    public WebDriver createDriver() {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        if (browser == BrowserList.CHROME){
            driver = WebDriverManager.chromedriver().create();
        }
        else if(browser == BrowserList.FIREFOX){
            driver = WebDriverManager.firefoxdriver().create();
        }   else if(browser == BrowserList.EDGE){
            driver = WebDriverManager.edgedriver().create();
        }else {
            throw new RuntimeException("Lỗi không mở được trình duyệt");
        }
        return driver;
    }

}
