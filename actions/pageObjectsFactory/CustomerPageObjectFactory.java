package pageObjectsFactory;

import commons.BasePageFactoty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPageObjectFactory extends BasePageFactoty {
    WebDriver driver;
    @FindBy(xpath = "//input[@id='Email']")
    private WebElement emailAddressTextbox ;
    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firtsNameTextbox ;
    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameTextbox ;

    public CustomerPageObjectFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, driver);
    }

    public String getFirtNameAtrributeValue() {
        waitForElementVisible(driver,firtsNameTextbox);
        return getElementAttribute(driver, firtsNameTextbox, "value");
    }
    public String getLastNameAtrributeValue() {
        waitForElementVisible(driver,lastNameTextbox);
        return getElementAttribute(driver, lastNameTextbox, "value");
    }

    public String getEmailAtrributeValue() {
        waitForElementVisible(driver,emailAddressTextbox);
        return getElementAttribute(driver, emailAddressTextbox, "value");
    }
}
