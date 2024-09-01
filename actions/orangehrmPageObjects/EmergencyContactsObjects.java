package orangehrmPageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class EmergencyContactsObjects extends BaseActions {
    WebDriver driver;
    public EmergencyContactsObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
