package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.OderPageUI;

public class OderPageObjects extends BasePage {
    WebDriver driver;
    public OderPageObjects(WebDriver driver) {
        this.driver = driver;
    }


}
