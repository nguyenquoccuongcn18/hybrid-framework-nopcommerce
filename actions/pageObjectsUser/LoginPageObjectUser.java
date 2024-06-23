package pageObjectsUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUserUIs.LoginPageUI;

public class LoginPageObjectUser extends BasePage  {
    WebDriver driver;
    String emailUser ="antonyCompa00000003@gmail.com";
    String passwordUser="12345678";
    public LoginPageObjectUser(WebDriver driver) {
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
    public void loginToUser(WebDriver driver){

        waitForElementVisible(driver, LoginPageUI.EMAIL_LOGIN_USER);
        sendKeysToElement(driver, LoginPageUI.EMAIL_LOGIN_USER,this.emailUser);

        waitForElementVisible(driver, LoginPageUI.PASSWORD_LOGIN_USER);
        sendKeysToElement(driver, LoginPageUI.PASSWORD_LOGIN_USER,this.passwordUser);

        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

    }
}
