package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage {
    WebDriver driver;
    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getEmailAtrributeValue() {
        waitForElementInvisible(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
       return getElementAttribute(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX,"value");
    }

    public String getFirtNameAtrributeValue() {
        waitForElementInvisible(driver, CustomerPageUI.FIRTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.FIRTNAME_TEXTBOX,"value");
    }

    public String getLastNameAtrributeValue() {
        waitForElementInvisible(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX,"value");
    }


}
