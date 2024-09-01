package orangehrmPageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DependentsObjects extends BaseActions {
    WebDriver driver;
    public DependentsObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
