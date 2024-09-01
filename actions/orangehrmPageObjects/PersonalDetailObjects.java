package orangehrmPageObjects;

import commons.BasePage;
import orangehrmUIs.PersonalDetailUIs;
import org.openqa.selenium.WebDriver;

public class PersonalDetailObjects extends BaseActions {
    WebDriver driver;
    public PersonalDetailObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameValue() {
        waitForElementVisible(driver, PersonalDetailUIs.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailUIs.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameValue() {
        waitForElementVisible(driver, PersonalDetailUIs.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailUIs.LASTNAME_TEXTBOX,"value");
    }

    public String getEmployeeID() {
        waitForElementVisible(driver, PersonalDetailUIs.EMPLOYEE_ID_TEXTBOX);
        return getElementAttribute(driver, PersonalDetailUIs.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public EmployeeListObjects clickToEmployeeList() {
        waitForElementClickable(driver,PersonalDetailUIs.EMPLOYEE_LIST_BUTTON);
        clickToElement(driver,PersonalDetailUIs.EMPLOYEE_LIST_BUTTON);
        return PageGeneratorManager.getEmployeeListPage(driver);
    }

    public boolean isPersonalDetailHeaderDisplay() {
        waitForElementVisible(driver, PersonalDetailUIs.PERSONAL_DETAIL_PAGE_HEADER);
        return isElementDisplay(driver, PersonalDetailUIs.PERSONAL_DETAIL_PAGE_HEADER);
    }
}
