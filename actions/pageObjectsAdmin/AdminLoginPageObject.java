package pageObjectsAdmin;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

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
    }

    public void enterToPasswordTextBoxAdmin(String passwordTextBoxAdmin) {
    }

    public AdminDashboardPageObjects clickToLoginButton() {
        return PageGeneratorManager.getAdminDashboardPage(driver);
    }
    public AdminDashboardPageObjects clickToLoginButtonAdmin(String emailTextBoxAdmin, String passwordTextBoxAdmin) {
        enterToEmailTextBoxAdmin(emailTextBoxAdmin);
        enterToPasswordTextBoxAdmin(passwordTextBoxAdmin);
        clickToLoginButton();
        return null;
    }

}
