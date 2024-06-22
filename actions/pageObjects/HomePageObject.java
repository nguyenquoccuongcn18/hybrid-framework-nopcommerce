package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver ;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public RegisterPageObject clickToRegisterLink() {
        //Bắt Locator -> Gọi hàm -> Gán locator
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);

    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_REGISTER_LINK);
        clickToElement(driver, HomePageUI.LOGIN_REGISTER_LINK);
    }

    public CustomerPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getCustomerPage(driver);
    }
}
