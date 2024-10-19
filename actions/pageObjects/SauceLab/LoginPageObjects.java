package pageObjects.SauceLab;

import commons.BaseTest;
import orangehrmPageObjects.BaseActions;
import orangehrmPageObjects.PageGeneratorManager;
import orangehrmUIs.LoginPageUIs;
import org.openqa.selenium.WebDriver;
import pageUIs.SauceLab.LoginPageUI;


public class LoginPageObjects extends BaseActions {
    WebDriver driver ;
    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsername(String username) {
        waitForElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.USER_NAME_TEXTBOX,username);

    }

    public void enterToPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public ProductPageObjects clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManagerSauceLab.getProductPage(driver);
    }
}
