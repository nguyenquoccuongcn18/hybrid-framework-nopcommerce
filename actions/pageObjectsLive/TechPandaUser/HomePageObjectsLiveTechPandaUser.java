package pageObjectsLive.TechPandaUser;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjectsUser.HomePageObject;
import pageUIsLive.TechPanDa.HomePageUIsUser;

public class HomePageObjectsLiveTechPandaUser extends BasePage {
    WebDriver driver ;
    public HomePageObjectsLiveTechPandaUser(WebDriver driver) {
        this.driver = driver;
    }

    public static HomePageObjectsLiveTechPandaUser gethomePageUser(WebDriver driver) {
        return new HomePageObjectsLiveTechPandaUser(driver);
    }

    public void clickAccountUser(){
        waitForElementClickable(driver, HomePageUIsUser.CLICK_ACCOUNT_USER);
        clickToElement(driver, HomePageUIsUser.CLICK_ACCOUNT_USER);
    }

    public void clickRegisterUser(String registerUser) {
        waitForElementClickable(driver, HomePageUIsUser.CLICK_REGISTER_USER, registerUser);
        clickToElement(driver, HomePageUIsUser.CLICK_REGISTER_USER, registerUser);
    }
    public void inputEmailAddress(String emailAddress, String valueEmail) {
        waitForElementVisible(driver, HomePageUIsUser.ENTER_INPUT_REGISTER, emailAddress);
        sendKeysToElement(driver, HomePageUIsUser.ENTER_INPUT_REGISTER,valueEmail, emailAddress);
    }
    public void inputPasswordUser(String passwordUser, String  valuePassword) {
        waitForElementVisible(driver, HomePageUIsUser.ENTER_INPUT_REGISTER, passwordUser);
        sendKeysToElement(driver, HomePageUIsUser.ENTER_INPUT_REGISTER,valuePassword,passwordUser);
    }
    public void inputConfirmPasswordUser(String confirmPasswordUser,String valueConfirmPassword) {
        waitForElementVisible(driver, HomePageUIsUser.ENTER_INPUT_REGISTER, confirmPasswordUser);
        sendKeysToElement(driver, HomePageUIsUser.ENTER_INPUT_REGISTER,valueConfirmPassword, confirmPasswordUser);

    }
    public void inputFirstName(String firstName, String valueFirstName) {
        waitForElementClickable(driver, HomePageUIsUser.ENTER_INPUT_REGISTER,firstName);
        sendKeysToElement(driver, HomePageUIsUser.ENTER_INPUT_REGISTER,valueFirstName,firstName);
    }
    public void inputLastName(String lastName,String valueLastName) {
        waitForElementClickable(driver, HomePageUIsUser.ENTER_INPUT_REGISTER,lastName);
        sendKeysToElement(driver, HomePageUIsUser.ENTER_INPUT_REGISTER,valueLastName,lastName);
    }
    public void clickButtonRegister() {
        waitForElementClickable(driver, HomePageUIsUser.CLICK_REGISTER);
        clickToElement(driver, HomePageUIsUser.CLICK_REGISTER);
    }
    public String verifyAccountSuccess() {
        waitForElementClickable(driver, HomePageUIsUser.VERIFY_ACCOUNT_SUCCESS);
        return getElementText(driver,HomePageUIsUser.VERIFY_ACCOUNT_SUCCESS);    }
}
