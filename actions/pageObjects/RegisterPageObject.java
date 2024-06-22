package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getFirstNameErrorMessageText() {
        waitForElementClickable(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    public String getLastNameErrorMessageText() {
        waitForElementClickable(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    public String getEmailMessageText() {
        waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
        return getElementText(driver,RegisterPageUI.EMAIL_TEXTBOX);
    }
    public String getEmailErrorMessageTextEmpty() {
        waitForElementClickable(driver, RegisterPageUI.EMAIL_ERROR_MSG_EMPTY);
        return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MSG_EMPTY);
    }
    public String getEmailErrorMessageText1() {
        waitForElementClickable(driver, RegisterPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MSG);
    }


    public String getConfirmPasswordErrorMessageText() {
        waitForElementClickable(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getElementText(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
    }

    public HomePageObject clickToNopCommerceLogo() {
        waitForElementClickable(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
        clickToElement(driver, RegisterPageUI.NOP_COMMERCE_LOGO);
        return PageGeneratorManager.getHomePage(driver);
    }

    public void enterToFirstNameTextBox(String firtNameValue) {
        waitForElementClickable(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX,firtNameValue);
    }

    public void enterToLastNameTextBox(String lastNameValue) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX,lastNameValue);
    }

    public void enterToEmailTextBox(String emailNameValue) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX,emailNameValue);
    }

    public void enterToPsswordTextBox(String passWordValue) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX,passWordValue);
    }

    public void enterToconfirmPasswordTextBox(String confirmPasswordValue) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPasswordValue);
    }

    public String getRegisterSuccessMessageText() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_COMPLETED_MSG);
        return getElementText(driver,RegisterPageUI.REGISTER_COMPLETED_MSG);
    }
}
