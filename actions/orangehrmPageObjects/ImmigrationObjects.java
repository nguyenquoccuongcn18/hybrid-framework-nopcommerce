package orangehrmPageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ImmigrationObjects extends BaseActions {
    WebDriver driver;
    public ImmigrationObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
