package pageObjectsAdmin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageAdminUIs.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {

    WebDriver driver;
    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
//    public void enterToEmailTextBox(String emailAddressLogin) {
//        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
//        sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddressLogin);
//    }

    public void enterToEmailTextBoxAdmin(String emailTextBoxAdmin) {
        waitForElementVisible(driver, AdminLoginPageUI.EMAIL_ADDRESS_TXT_ADMIN);
        sendKeysToElement(driver, AdminLoginPageUI.EMAIL_ADDRESS_TXT_ADMIN,emailTextBoxAdmin);
    }

    public void enterToPasswordTextBoxAdmin(String passwordTextBoxAdmin) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_ADDRESS_TXT_ADMIN);
        sendKeysToElement(driver, AdminLoginPageUI.PASSWORD_ADDRESS_TXT_ADMIN,passwordTextBoxAdmin);
    }

    public AdminDashboardPageObjects clickToLoginButton() {
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN);
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }
    public AdminDashboardPageObjects clickToLoginButtonAdmin(String emailTextBoxAdmin, String passwordTextBoxAdmin) {
        enterToEmailTextBoxAdmin(emailTextBoxAdmin);
        enterToPasswordTextBoxAdmin(passwordTextBoxAdmin);
        return clickToLoginButton();
    }

}
