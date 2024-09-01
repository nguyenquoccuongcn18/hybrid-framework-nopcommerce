package orangehrmPageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class SalaryObjects extends BaseActions {
    WebDriver driver;
    public SalaryObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
