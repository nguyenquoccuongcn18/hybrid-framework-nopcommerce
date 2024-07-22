package pageObjects.Facebook;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.Facebook.HomePageUI;

public class HomePageObjectFacebook extends BasePage {
    public Object clickToNewAccountButton;
    WebDriver driver ;


    public HomePageObjectFacebook(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAccountButton() {
        waitForElementClickable(driver, HomePageUI.CREAT_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, HomePageUI.CREAT_NEW_ACCOUNT_BUTTON);
    }

    public boolean isFirstNameTextBoxDisplayed() {
         waitForElementVisible(driver,HomePageUI.SURNAME_TEXTBOX);
         return isElementDisplay(driver,HomePageUI.SURNAME_TEXTBOX);
    }

    public boolean isSurnNameTextBoxDisplayed() {
        waitForElementVisible(driver,HomePageUI.FIRSTNAME_TEXTBOX);
        return isElementDisplay(driver,HomePageUI.FIRSTNAME_TEXTBOX);
    }

    @Step("Enter Email textbox with value is {0}")
    public boolean isEmailTextBoxDisplayed() {
        waitForElementVisible(driver,HomePageUI.EMAIL_TEXTBOX);
        return isElementDisplay(driver,HomePageUI.EMAIL_TEXTBOX);
    }

    public boolean isPasswordTextBoxDisplayed() {
        waitForElementVisible(driver,HomePageUI.PASSWORD_TEXTBOX);
        return isElementDisplay(driver,HomePageUI.PASSWORD_TEXTBOX);
    }

    @Step("Enter Confirm Email textbox with value is {0}")
    public boolean isConfirmEmailTextBoxDisplayed() {
        waitForElementVisible(driver,HomePageUI.EMAIL_TEXTBOX);
        return isElementDisplay(driver,HomePageUI.EMAIL_TEXTBOX);
    }
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver,HomePageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver,HomePageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void clickToCloseSignUpPopup() {
        waitForElementClickable(driver,HomePageUI.CLOSE_SIGNUP_POPUP);
        clickToElement(driver, HomePageUI.CLOSE_SIGNUP_POPUP);
    }

    public boolean isFirstNameTextBoxUnDisplayed() {
        return isElementUndisplay(driver, HomePageUI.FIRSTNAME_TEXTBOX);
    }

    public boolean isSurnNameTextBoxUnDisplayed() {
        return isElementUndisplay(driver, HomePageUI.SURNAME_TEXTBOX);

    }

    public boolean isEmailTextBoxUnDisplayed() {
        return isElementUndisplay(driver, HomePageUI.EMAIL_TEXTBOX);

    }

    public boolean isPasswordTextBoxUnDisplayed() {
        return isElementUndisplay(driver, HomePageUI.PASSWORD_TEXTBOX);

    }
}
