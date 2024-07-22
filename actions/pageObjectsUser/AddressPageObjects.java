package pageObjectsUser;

import org.openqa.selenium.WebDriver;
import pageUserUIs.MyAccountSideBarPageUI;

public class AddressPageObjects extends MyAccountSideBarPageObjects {
    WebDriver driver;
    public AddressPageObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



}
