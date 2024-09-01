package orangehrmPageObjects;

import commons.BasePage;
import orangehrmUIs.LoginPageUIs;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects extends BaseActions {
    private WebDriver driver;
    public LoginPageObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void inputToUsernameField(String username) {
        waitForElementVisible(driver, LoginPageUIs.USER_NAME_TEXTBOX);
        sendKeysToElement(driver, LoginPageUIs.USER_NAME_TEXTBOX,username);
    }

    public void inputToPasswordField(String password) {
        waitForElementVisible(driver, LoginPageUIs.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPageUIs.PASSWORD_TEXTBOX,password);
    }

    public DashboardObjects clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUIs.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUIs.LOGIN_BUTTON);
//        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getDashboardPage(driver);
    }
}
