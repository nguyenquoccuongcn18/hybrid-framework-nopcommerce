package orangehrmPageObjects;

import commons.BasePage;
import orangehrmUIs.AddEmployeeUIs;
import orangehrmUIs.LoginPageUIs;
import org.openqa.selenium.WebDriver;

public class AddEmployeeObjects extends BaseActions {
    private WebDriver driver;
    public AddEmployeeObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void enterFirstNameTextBox(String firtname) {
        waitForElementVisible(driver, AddEmployeeUIs.FIRTNAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeeUIs.FIRTNAME_TEXTBOX, firtname);
    }

    public void enterLastNameTextBox(String lastname) {
        waitForElementVisible(driver, AddEmployeeUIs.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, AddEmployeeUIs.LASTNAME_TEXTBOX, lastname);
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, AddEmployeeUIs.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, AddEmployeeUIs.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public void clickToSave() {
        waitForElementClickable(driver,AddEmployeeUIs.SAVE_BUTON);
        clickToElement(driver,AddEmployeeUIs.SAVE_BUTON);
        waitForSpinnerIconInvisible();
    }


    public void clickToAddEmployeeButton() {
    }
}
