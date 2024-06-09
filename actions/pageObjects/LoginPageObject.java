package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void enterToEmailTextBox(String emailAddressLogin) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddressLogin);
    }

    public void enterToPasswordTextBox(String passwordTextBoxLogin) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordTextBoxLogin);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
