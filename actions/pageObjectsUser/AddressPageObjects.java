package pageObjectsUser;

import org.openqa.selenium.WebDriver;

public class AddressPageObjects extends MyAccountSideBarPageObjects {
    WebDriver driver;
    public AddressPageObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
