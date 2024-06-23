package pageObjectsUser;

import org.openqa.selenium.WebDriver;

public class OrderPageObjects extends MyAccountSideBarPageObjects {
    WebDriver driver;
    public OrderPageObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



}
