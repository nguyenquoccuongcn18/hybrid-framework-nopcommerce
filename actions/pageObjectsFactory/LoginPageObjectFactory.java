package pageObjectsFactory;

import commons.BasePageFactoty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjectFactory extends BasePageFactoty {
    WebDriver driver;
    @FindBy(xpath ="//input[@id='Email']" )
    private String emailTextBox;
    @FindBy(id = "Password")
    private String passwordTextBox;
    @FindBy(xpath ="//button[@class='button-1 login-button']" )

    private String loginTextBox;
    public LoginPageObjectFactory(WebDriver driver) {
        this.driver = driver;
    }

}
