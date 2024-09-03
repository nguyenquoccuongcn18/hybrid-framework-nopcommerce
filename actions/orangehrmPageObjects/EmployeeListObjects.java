package orangehrmPageObjects;

import orangehrmUIs.EmployeeListUIs;
import org.openqa.selenium.WebDriver;

public class EmployeeListObjects extends BaseActions {
    WebDriver driver;
    public EmployeeListObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void enterFirstNameTextBox(String s) {
    }

    public void enterLastNameTextBox(String s) {
    }


    public void enterToEmployeeIDTextBox(String employeeID) {
        waitForElementVisible(driver, EmployeeListUIs.EMPLOYEE_ID_TEXTBOX);
        sendKeysToElement(driver, EmployeeListUIs.EMPLOYEE_ID_TEXTBOX, employeeID);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, EmployeeListUIs.SEARCH_BUTTON);
        clickToElement(driver, EmployeeListUIs.SEARCH_BUTTON);
        waitForSpinnerIconInvisible();
    }

    public AddEmployeeObjects clickToAddEmployeeButton() {
        waitForElementClickable(driver, EmployeeListUIs.ADD_BUTTON);
        clickToElement(driver, EmployeeListUIs.ADD_BUTTON);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getAddEmployeePage(driver);
    }

    public PersonalDetailObjects clickToEditIconByEmployeeID(String employeeID) {
        waitForElementVisible(driver,EmployeeListUIs.EDIT_BUTTON_BY_EMPLOYEE_ID,employeeID);
        clickToElement(driver, EmployeeListUIs.EDIT_BUTTON_BY_EMPLOYEE_ID,employeeID);
        waitForSpinnerIconInvisible();
        return PageGeneratorManager.getPersonalDetailPage(driver);
    }
}
