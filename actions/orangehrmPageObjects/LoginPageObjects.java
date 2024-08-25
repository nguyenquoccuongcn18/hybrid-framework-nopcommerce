package orangehrmPageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageObjects extends BasePage {
    WebDriver driver;
    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToUsernameField(String automation) {
    }

    public void inputToPasswordField(String s) {
    }

    public DashboardObjects clickToLoginButton() {
        return null;
    }
}
