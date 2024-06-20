package pageObjectsFactory;

import commons.BasePageFactoty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjectFactory extends BasePageFactoty {
    WebDriver driver;
    @FindBy(id = "FirstName")
    private WebElement firstNameTextBox;
    @FindBy(id = "LastName")
    private WebElement lastNameTextBox;
    @FindBy(id = "Email")
    private WebElement emailTextBox;
    @FindBy(id = "Password")
    private WebElement passwordTextBox;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTextBox;
    @FindBy(id = "register-button")
    private WebElement registerButton;
    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorMessage;
    @FindBy(id = "LastName-error")
    private WebElement lastNameErrorMessage;
    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;
    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordErrorMessage;
    @FindBy(id = "Password-error")
    private WebElement passwordErrorMessage;
    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement CONFIRM_PASSWORD_ERROR_MSG;
    @FindBy(xpath = "//div[@class='result']")
    private WebElement REGISTER_COMPLETED_MSG;
    @FindBy(xpath = "//div[@class='header-logo']//img")
    private WebElement NOP_COMMERCE_LOGO;

    public RegisterPageObjectFactory(WebDriver driver) {
        super();
        this.driver =driver;
        PageFactory.initElements(this.driver,driver);
    }
    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, NOP_COMMERCE_LOGO);
        clickToElement(driver, NOP_COMMERCE_LOGO);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementClickable(driver, REGISTER_COMPLETED_MSG);
        return getElementText(driver,REGISTER_COMPLETED_MSG);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, registerButton);
        clickToElement(driver, registerButton);
    }

    public void enterToconfirmPasswordTextBox(String PasswordTextBox) {
        waitForElementClickable(driver, confirmPasswordTextBox);
        sendKeysToElement(driver, confirmPasswordTextBox);
    }

    public void enterToPsswordTextBox(String PasswordValue) {
        waitForElementClickable(driver, passwordTextBox);
        sendKeysToElement(driver, passwordTextBox);
    }

    public void enterToEmailTextBox(String mail) {
        waitForElementClickable(driver, emailErrorMessage);
        clickToElement(driver, emailErrorMessage);
    }

    public void enterToLastNameTextBox(String compa) {
        waitForElementClickable(driver, lastNameTextBox);
        clickToElement(driver, lastNameTextBox);
    }

    public void enterToFirstNameTextBox(String antony) {
        waitForElementClickable(driver, firstNameTextBox);
        clickToElement(driver, firstNameTextBox);
    }

    public String getConfirmPasswordErrorMessageText() {
        waitForElementClickable(driver, confirmPasswordErrorMessage);
        return getElementText(driver,confirmPasswordErrorMessage);
    }

    public String getEmailErrorMessageText() {
        waitForElementClickable(driver, emailErrorMessage);
        return getElementText(driver,emailErrorMessage);
    }

    public String getFirstNameErrorMessageText() {
        waitForElementClickable(driver, firstNameErrorMessage);
        return getElementText(driver,firstNameErrorMessage);
    }

    public String getLastNameErrorMessageText() {
        waitForElementClickable(driver, lastNameErrorMessage);
        return getElementText(driver,lastNameErrorMessage);
    }
}
