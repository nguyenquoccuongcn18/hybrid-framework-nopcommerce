package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressPageUI;

public class AddressPageObjects extends BasePage {
    WebDriver driver;
    public AddressPageObjects(WebDriver driver) {
        this.driver = driver;
    }


}
